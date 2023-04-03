package moe.timicasto.qscheme.component.symbol.shapes;

import java.awt.*;
import java.util.Optional;

public class Stroke {
	public final StrokeStyle style;
	public final double width;
	public final Optional<Color> color;

	public Stroke(StrokeStyle style, double width, Color color) {
		this.style = style;
		this.width = width;
		this.color = Optional.of(color);
	}

	public Stroke(StrokeStyle style, double width) {
		this.style = style;
		this.width = width;
		this.color = Optional.empty();
	}
}
