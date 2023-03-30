package moe.timicasto.qscheme.component.symbol.shapes;

import moe.timicasto.qscheme.utils.Vec2d;

import java.awt.*;
import java.util.Optional;

public class Rectangle implements IShape {
	public Vec2d start;
	public Vec2d end;
	Stroke stroke;
	FillingType filling;
	Optional<Color> fillingColor;

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
		return null;
	}
}
