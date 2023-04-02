package moe.timicasto.qscheme;

import moe.timicasto.qscheme.component.Component;
import moe.timicasto.qscheme.component.symbol.LocatedPin;
import moe.timicasto.qscheme.component.symbol.shapes.*;
import moe.timicasto.qscheme.net.Net;
import moe.timicasto.qscheme.utils.Vec2d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Eschematic {

	public static final String LIBID_PREFIX = "ProjectLib:";
	public List<Net> nets = new ArrayList<>();
	public List<Component> components = new ArrayList<>();
	public SchematicMeta meta;
	public UUID uuid;

	private float drawX = 14.0F;
	private float drawY = 14.0F;
	private long ref = 1L;
	
	public Eschematic(SchematicMeta meta) {
		this.meta = meta;
		this.uuid = UUID.randomUUID();
	}
	
	public void addNet(Net net) {
		nets.add(net);
	}
	
	public void add(Component component) {
		components.add(component);
	}

	public String compile() {
		float tmpY = 0.0F;
		StringBuilder sb = new StringBuilder();

		sb.append("(kicad_sch \n");

		sb.append("  (version 20230221) (generator qcheme)\n");

		sb.append("  (uuid ").append(this.uuid.toString()).append(")\n");

		sb.append("  (paper \"A3\")\n");

		sb.append("(lib_symbols\n");

		for (Component component : components) {
			String libDef = component.symbol.getStringDef();
			libDef = libDef.replaceAll("\\[LIBID]", LIBID_PREFIX + component.getSymbol().getReference() + "_" + component.hashCode());
			libDef = libDef.replaceAll("\\[LIBSUBID]", component.getSymbol().getReference() + "_" + component.hashCode());
			libDef = libDef.replaceAll("\\[REFERENCE]", component.getSymbol().getReference());
			libDef = libDef.replaceAll("\\[VALUE]", component.getSymbol().getValue());
			sb.append(libDef);
			sb.append("\n");
		}

		sb.append(")");

		for (Component component : components) {

			float minX, minY;

			List<Float> startXs = new ArrayList<>();
			List<Float> startYs = new ArrayList<>();
			List<Float> stopXs = new ArrayList<>();
			List<Float> stopYs = new ArrayList<>();

			for (IShape shape : component.symbol.getShapes()) {
				if (shape instanceof Polyline) {
					Polyline lines = ((Polyline)shape);
					List<Double> ptsX = new ArrayList<>();
					List<Double> ptsY = new ArrayList<>();
					for (Vec2d point : lines.getPoints()) {
						ptsX.add(point.getX());
						ptsY.add(point.getY());
					}
					startXs.add(Collections.min(ptsX).floatValue());
					startYs.add(Collections.min(ptsY).floatValue());
					stopXs.add(Collections.max(ptsX).floatValue());
					stopYs.add(Collections.max(ptsY).floatValue());
				} else if (shape instanceof Arc) {
					Arc arc = ((Arc)shape);
					List<Double> ptsX = new ArrayList<>();
					List<Double> ptsY = new ArrayList<>();
					ptsX.add(arc.start.getX());
					ptsX.add(arc.mid.getX());
					ptsX.add(arc.end.getX());
					ptsY.add(arc.start.getY());
					ptsY.add(arc.mid.getY());
					ptsY.add(arc.end.getY());
					startXs.add(Collections.min(ptsX).floatValue());
					startYs.add(Collections.min(ptsY).floatValue());
					stopXs.add(Collections.max(ptsX).floatValue());
					stopYs.add(Collections.max(ptsY).floatValue());
				} else if (shape instanceof Circle) {
					Circle circle = ((Circle)shape);
					startXs.add((float) (circle.center.getX() - circle.radius));
					stopXs.add((float)  (circle.center.getX() + circle.radius));
					startYs.add((float) (circle.center.getY() - circle.radius));
					stopYs.add((float)  (circle.center.getY() + circle.radius));
				} else if (shape instanceof Rectangle) {
					Rectangle rect = (Rectangle) shape;
					startXs.add((float) Math.min(rect.start.getX(), rect.end.getX()));
					startYs.add((float) Math.min(rect.start.getY(), rect.end.getY()));
					stopXs.add((float)  Math.max(rect.start.getX(), rect.end.getX()));
					stopYs.add((float)  Math.max(rect.start.getY(), rect.end.getY()));
				}
			}

			for (String s : component.getNumberMap().keySet()) {
				LocatedPin pin = component.getNumberMap().get(s);
				startXs.add((float) (pin.rotation == 0 ? (pin.x) : pin.rotation == 90 ? (pin.x) : pin.rotation == 180 ? (pin.x  - pin.length) : (pin.x)));
				stopXs.add((float)  (pin.rotation == 0 ? (pin.x + pin.length) : (pin.x)));
				startYs.add((float) (pin.rotation == 0 ? (pin.y) : pin.rotation == 90 ? (pin.y - pin.length) : (pin.y)));
				stopYs.add((float)  (pin.rotation == 0 ? (pin.y) : pin.rotation == 90 ? (pin.y) : pin.rotation == 180 ? (pin.y) : (pin.y + pin.length)));
			}

			float startX = Collections.min(startXs);
			float startY = Collections.min(startYs);
			float stopX = Collections.max(stopXs);
			float stopY = Collections.max(stopYs);

			drawX += Math.abs(startX);
			drawY += Math.abs(startY);

			StringBuilder pindefs = new StringBuilder();
			for (LocatedPin pin : component.symbol.getPins()) {
				String fmt = String.format("(pin \"%s\" (uuid %s))\n", pin.pinMeta.getPinNumber(), UUID.randomUUID());
				pindefs.append(fmt);
			}

			String def = String.format("(symbol (lib_id \"%s\") (at %f %f %d) (unit 1) (in_bom yes) (on_board yes) (dnp no) (uuid %s) \n " +
					"(property \"Reference\" \"%s%d\" (at %f %f %f) (effects (font (size 0.8 0.8)) (justify left))" +
					")\n" +
					"(property \"Value\" \"%s\" (at %f %f %f)\n (effects (font (size 0.8 0.8)) (justify left))\n" +
					")\n" +
					"(property \"Footprint\" \"%s\" (at %f %f %f)\n (effects (font (size 0.8 0.8)) hide)\n" +
					")\n" +
					"{PINDEFS}" +
					"(instances (project \"%s\" (path \"/%s\" (reference \"%s\") (unit 1)))\n" +
					")\n" +
					")", LIBID_PREFIX + component.getSymbol().getReference() + "_" + component.hashCode(), drawX, drawY, 0, UUID.randomUUID(), component.getSymbol().getReference(), ref, drawX, drawY + 1.2F, 0f, component.getSymbol().getValue(), drawX, drawY - 1.2F, 0f, "", drawX, drawY, 0f, this.meta.title, this.uuid, component.getSymbol().getReference());
			def = def.replaceAll("\\{PINDEFS}", pindefs.toString());
			++ref;

			drawX += stopX + 2.54;
			drawY -= Math.abs(startY);
			tmpY = Math.max(Math.abs(startY) + Math.abs(stopY), tmpY);
			if (drawX >= 400) {
				drawY += tmpY;
				tmpY = 0;
				drawX = 14.0F;
			}

			sb.append(def);
			sb.append("\n");
			
		}

		sb.append(")");

		return sb.toString();
	}
	
}
