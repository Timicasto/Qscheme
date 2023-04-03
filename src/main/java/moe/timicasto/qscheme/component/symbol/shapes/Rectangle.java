package moe.timicasto.qscheme.component.symbol.shapes;

import moe.timicasto.qscheme.utils.Vec2d;

import java.awt.*;
import java.util.Optional;

public class Rectangle implements IShape {
	public final Vec2d start;
	public final Vec2d end;
	final Stroke stroke;
	final FillingType filling;
	final Optional<Color> fillingColor;

	public Rectangle(Vec2d start, Vec2d end, Stroke stroke, FillingType filling, Color fillingColor) {
		this.start = start;
		this.end = end;
		this.stroke = stroke;
		this.filling = filling;
		this.fillingColor = Optional.of(fillingColor);
	}

	public Rectangle(Vec2d start, Vec2d end, Stroke stroke, FillingType filling) {
		this.start = start;
		this.end = end;
		this.stroke = stroke;
		this.filling = filling;
		this.fillingColor = Optional.empty();
	}

	@Override
	public String getStringDef() {
		return "(rectangle " +
				"(start " + start.getX() + " " + start.getY() + ") " +
				"(end " + end.getX() + " " + end.getY() + ") " +
				"\n" +
				"(stroke " + "(width " + stroke.width + ") " + "(type " + stroke.style.toString().toLowerCase() + "))\n" +
				"(fill (type " + filling.toString().toLowerCase() + ")" + fillingColor.map(value -> "(color " + value.getRed() + " " + value.getGreen() + " " + value.getBlue() + " " + "1)").orElse("") + ")" +
				"\n)";
	}
}
