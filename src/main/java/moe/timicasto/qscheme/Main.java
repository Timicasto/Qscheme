package moe.timicasto.qscheme;

import moe.timicasto.qscheme.component.symbol.shapes.Arc;
import moe.timicasto.qscheme.component.symbol.shapes.FillingType;
import moe.timicasto.qscheme.component.symbol.shapes.Stroke;
import moe.timicasto.qscheme.component.symbol.shapes.StrokeStyle;
import moe.timicasto.qscheme.utils.Vec2d;

import java.awt.geom.Dimension2D;

public class Main {
	public static void main(String[] args) {
		Arc arc = new Arc(new Vec2d(2.54, -1.524), new Vec2d(2.9621, 0), new Vec2d(2.54, 1.524), new Stroke(StrokeStyle.SOLID, 0), FillingType.BACKGROUND);
		System.out.println(arc.getStringDef());
	}
}
