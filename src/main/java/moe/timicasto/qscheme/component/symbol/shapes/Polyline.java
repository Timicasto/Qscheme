package moe.timicasto.qscheme.component.symbol.shapes;

import moe.timicasto.qscheme.utils.Vec2d;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Polyline implements IShape {
	List<Vec2d> points;
	Stroke stroke;
	FillingType filling;
	Optional<Color> fillingColor;

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
		return null;
	}
}
