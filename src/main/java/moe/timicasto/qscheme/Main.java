package moe.timicasto.qscheme;

import moe.timicasto.qscheme.component.symbol.shapes.*;
import moe.timicasto.qscheme.component.symbol.simple.Capacitor;
import moe.timicasto.qscheme.utils.Vec2d;

import java.awt.geom.Dimension2D;

public class Main {
	public static void main(String[] args) {
		Arc arc = new Arc(new Vec2d(2.54, -1.524), new Vec2d(2.9621, 0), new Vec2d(2.54, 1.524), new Stroke(StrokeStyle.SOLID, 0), FillingType.BACKGROUND);
		Circle circle = new Circle(new Vec2d(0, 0), 2.54, new Stroke(StrokeStyle.SOLID, 0), FillingType.BACKGROUND)
;
		Capacitor capacitor = new Capacitor("68uF");
		Eschematic eschematic = new Eschematic(new SchematicMeta("TestTitle", "A", "Timicasto", "2023-04-01"));
		System.out.println(eschematic.compile());
	}
}
