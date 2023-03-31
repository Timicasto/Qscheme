package moe.timicasto.qscheme.component.symbol;

import moe.timicasto.qscheme.component.parts.Pin;

public class LocatedPin {
	public Pin pinMeta;
	public double x;
	public double y;
	public double length;
	public int rotation;

	public LocatedPin(Pin meta, double x, double y, double length, int rotation) {
		this.pinMeta = meta;
		this.x = x;
		this.y = y;
		this.length = length;
		this.rotation = rotation;
	}

	public Pin getPinMeta() {
		return pinMeta;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getLength() {
		return length;
	}

	public int getRotation() {
		return rotation;
	}
}
