package moe.timicasto.qscheme.component.symbol.simple;

import moe.timicasto.qscheme.component.parts.Pin;
import moe.timicasto.qscheme.component.symbol.LocatedPin;
import moe.timicasto.qscheme.component.symbol.shapes.*;
import moe.timicasto.qscheme.utils.Vec2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolarizedCapacitorSymbol extends AbstractSymbol {
	String val;
	public static final IShape[] shapes =  {
			new Rectangle(new Vec2d(-1.524, -0.3048), new Vec2d(1.524, -0.6858), new Stroke(StrokeStyle.DEFAULT, 0), FillingType.OUTLINE),
			new Rectangle(new Vec2d(-1.524, 0.6858), new Vec2d(1.524, 0.3048), new Stroke(StrokeStyle.DEFAULT, 0), FillingType.NONE),
			new Polyline(new Stroke(StrokeStyle.DEFAULT, 0), FillingType.NONE, new Vec2d(1.27, 1.524), new Vec2d(-0.762, 1.524)),
			new Polyline(new Stroke(StrokeStyle.DEFAULT, 0), FillingType.NONE, new Vec2d(-1.016, 1.27), new Vec2d(-1.016, 1.778))
	};

	public PolarizedCapacitorSymbol(String value) {
		super(value, new Pin("~", "1"), new Pin("~", "2"));
		this.val = value;
	}

	@Override
	public List<LocatedPin> getPins() {
		List<LocatedPin> ret = new ArrayList<>();
		ret.add(new LocatedPin(new Pin("~", "1"), 0, 2.54, 1.8542, 270));
		ret.add(new LocatedPin(new Pin("~", "2"), 0, -2.54, 1.8542, 90));
		return ret;
	}

	@Override
	public boolean isNumberHided() {
		return true;
	}

	@Override
	public String getValue() {
		return val;
	}

	@Override
	public void setValue(String val) {
		super.setValue(val);
		this.val = val;
	}

	@Override
	public List<IShape> getShapes() {
		return Arrays.asList(shapes);
	}

	@Override
	public String getStringDef() {
		StringBuilder pinBuilder = new StringBuilder();
		for (LocatedPin pin : getPins()) {
			pinBuilder.append(String.format("(pin passive line (at %f %f %d) (length %f) (name \"%s\" (effects (font (size 1.27 1.27))))(number \"%s\" (effects (font (size 1.27 1.27)))) )", pin.x, pin.y, pin.rotation, pin.length, pin.getPinMeta().getPinName(), pin.getPinMeta().getPinNumber()));
			pinBuilder.append("\n");
		}
		String pindefs = pinBuilder.toString();

		StringBuilder sb = new StringBuilder();
		String str = super.getStringDef();
		str = str.replaceFirst("\\[ATTACHATTRIBS]", "(pin_numbers hide) (pin_names (offset 0.254) hide)");
		str = str.replaceFirst("\\{PINSDEFS}", pindefs);
		sb.append(str);
		sb.append("\n");
		return sb.toString();
	}

	@Override
	public String getReference() {
		return "C";
	}
}
