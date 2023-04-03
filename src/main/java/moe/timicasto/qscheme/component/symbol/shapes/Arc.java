package moe.timicasto.qscheme.component.symbol.shapes;

import moe.timicasto.qscheme.utils.Vec2d;

import java.awt.*;
import java.util.Optional;

public class Arc implements IShape {
	public final Vec2d start;
	public final Vec2d mid;
	public final Vec2d end;

	final Stroke stroke;
	final FillingType filling;
	final Optional<Color> color;

	public Arc(Vec2d start, Vec2d mid, Vec2d end, Stroke stroke, FillingType filling) {
		this.start = start;
		this.mid = mid;
		this.end = end;
		this.stroke = stroke;
		this.filling = filling;
		this.color = Optional.empty();
	}

	public Arc(Vec2d start, Vec2d mid, Vec2d end, Stroke stroke, FillingType filling, Color color) {
		this.start = start;
		this.mid = mid;
		this.end = end;
		this.stroke = stroke;
		this.filling = filling;
		this.color = Optional.of(color);
	}

	@Override
	public String getStringDef() {
		return "(arc " +
				"(start " + start.getX() + " " + start.getY() + ") " +
				"(mid " + mid.getX() + " " + mid.getY() + ") " +
				"(end " + end.getX() + " " + end.getY() + ") " +
				"\n" +
				"(stroke " + "(width " + stroke.width + ") " + "(type " + stroke.style.toString().toLowerCase() + "))\n" +
				"(fill (type " + filling.toString().toLowerCase() + ")" + color.map(value -> "(color " + value.getRed() + " " + value.getGreen() + " " + value.getBlue() + " " + "1)").orElse("") + ")" +
				"\n)";
	}
}
