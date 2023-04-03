package moe.timicasto.qscheme.component.symbol;

import moe.timicasto.qscheme.component.parts.Pin;
import moe.timicasto.qscheme.net.Net;

import java.util.ArrayList;
import java.util.List;

public class LocatedPin {
	public final Pin pinMeta;
	public final double x;
	public final double y;
	public final double length;
	public final int rotation;
	public final List<Net> nets = new ArrayList<>();

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
