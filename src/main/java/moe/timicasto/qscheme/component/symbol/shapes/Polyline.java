package moe.timicasto.qscheme.component.symbol.shapes;

import moe.timicasto.qscheme.utils.Vec2d;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Polyline implements IShape {
	final List<Vec2d> points;
	final Stroke stroke;
	final FillingType filling;
	final Optional<Color> fillingColor;

	public Polyline(Stroke stroke, FillingType filling, Vec2d... points) {
		this.stroke = stroke;
		this.filling = filling;
		this.points = Arrays.asList(points);
		this.fillingColor = Optional.empty();
	}

	public Polyline(List<Vec2d> points, Stroke stroke, FillingType filling, Color fillingColor) {
		this.points = points;
		this.stroke = stroke;
		this.filling = filling;
		this.fillingColor = Optional.of(fillingColor);
	}

	@Override
	public String getStringDef() {
		StringBuilder points = new StringBuilder("(pts ");
		for (Vec2d point : this.points) {
			points.append("(xy ").append(point.x).append(" ").append(point.y).append(")");
		}
		points.append(")");
		return "(polyline " + "\n" +
				points +
				"\n" +
				"(stroke " + "(width " + stroke.width + ") " + "(type " + stroke.style.toString().toLowerCase() + "))\n" +
				"(fill (type " + filling.toString().toLowerCase() + ")" + fillingColor.map(value -> "(color " + value.getRed() + " " + value.getGreen() + " " + value.getBlue() + " " + "1)").orElse("") + ")" +
				"\n)";
	}

	public List<Vec2d> getPoints() {
		return points;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public FillingType getFilling() {
		return filling;
	}

	public Optional<Color> getFillingColor() {
		return fillingColor;
	}
}
