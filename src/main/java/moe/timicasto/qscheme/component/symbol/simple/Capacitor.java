package moe.timicasto.qscheme.component.symbol.simple;

import moe.timicasto.qscheme.component.parts.Pin;
import moe.timicasto.qscheme.component.symbol.LocatedPin;
import moe.timicasto.qscheme.component.symbol.shapes.*;
import moe.timicasto.qscheme.utils.Vec2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Capacitor extends AbstractSymbol {
	String val;
	public static final IShape[] shapes =  {new Polyline(new Stroke(StrokeStyle.DEFAULT, 0.3302), FillingType.NONE, new Vec2d(-1.524, -0.508), new Vec2d(1.524, -0.508)), new Polyline(new Stroke(StrokeStyle.DEFAULT, 0.3048), FillingType.NONE, new Vec2d(-1.524, 0.508), new Vec2d(1.524, 0.508))};

	public Capacitor(String value) {
		super(value, new Pin("~", "1"), new Pin("~", "2"));
		this.val = value;
	}

	@Override
	public List<LocatedPin> getPins() {
		List<LocatedPin> ret = new ArrayList<>();
		ret.add(new LocatedPin(new Pin("~", "1"), 0, 2.54, 2.032, 270));
		ret.add(new LocatedPin(new Pin("~", "2"), 0, -2.54, 2.032, 90));
		return ret;
	}

	@Override
	public boolean isNumberHided() {
		return true;
	}

	@Override
	public String getValue() {
		return val;
	}

	@Override
	public void setValue(String val) {
		super.setValue(val);
		this.val = val;
	}

	@Override
	public List<IShape> getShapes() {
		return Arrays.asList(shapes);
	}

	@Override
	public String getStringDef() {
		StringBuilder sb = new StringBuilder();
		sb.append("(symbol \"").append(getReference()).append("\"").append(isNumberHided() ? "(pin_number hide)" : "").append("(pin_names (offset 0.254) hide) (in_bom yes) (on_board yes)\n");

		sb.append(this.getShapes().get(0).getStringDef()).append("\n").append(this.getShapes().get(1).getStringDef());
		return sb.toString();
	}

	@Override
	public String getReference() {
		return "C";
	}
}
