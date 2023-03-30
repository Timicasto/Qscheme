package moe.timicasto.qscheme.component.symbol.shapes;

import moe.timicasto.qscheme.utils.Vec2d;

import java.awt.*;
import java.util.Optional;

public class Circle implements IShape {
	public Vec2d center;
	public double radius;
	Stroke stroke;
	FillingType filling;
	Optional<Color> color;

	public Circle(Vec2d center, double radius, Stroke stroke, FillingType filling) {
		this.center = center;
		this.radius = radius;
		this.stroke = stroke;
		this.filling = filling;
		this.color = Optional.empty();
	}

	public Circle(Vec2d center, double radius, Stroke stroke, FillingType filling, Color color) {
		this.center = center;
		this.radius = radius;
		this.stroke = stroke;
		this.filling = filling;
		this.color = Optional.of(color);
	}

	@Override
	public String getStringDef() {
		return null;
	}
}
