package moe.timicasto.qscheme.component.symbol;

import moe.timicasto.qscheme.component.parts.Pin;

public class LocatedPin {
	public Pin pinMeta;
	public double x;
	public double y;
	public double length;

	public LocatedPin(Pin meta, double x, double y, double length) {
		this.pinMeta = meta;
		this.x = x;
		this.y = y;
		this.length = length;
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
}
