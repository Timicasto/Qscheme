package moe.timicasto.qscheme.component.symbol.simple;

import moe.timicasto.qscheme.component.parts.Pin;
import moe.timicasto.qscheme.component.symbol.LocatedPin;
import moe.timicasto.qscheme.component.symbol.shapes.*;
import moe.timicasto.qscheme.utils.Vec2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResistorSymbol extends AbstractSymbol {
	String val;
	public static final IShape[] shapes = {
			new Rectangle(new Vec2d(-0.762, 1.778), new Vec2d(0.762, -1.778), new Stroke(StrokeStyle.DEFAULT, 0.2032), FillingType.NONE)
	};

	public ResistorSymbol(String value) {
		super(value, new Pin("~", "1"), new Pin("~", "2"));
		this.val = value;
	}

	@Override
	public List<LocatedPin> getPins() {
		List<LocatedPin> ret = new ArrayList<>();
		ret.add(new LocatedPin(new Pin("~", "1"), 0, 2.54, 0.762, 270));
		ret.add(new LocatedPin(new Pin("~", "2"), 0, -2.54, 0.762, 90));
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
		StringBuilder pinBuilder = new StringBuilder();
		for (LocatedPin pin : getPins()) {
			pinBuilder.append(String.format("(pin passive line (at %f %f %d) (length %f) (name \"%s\" (effects (font (size 1.27 1.27))))(number \"%s\" (effects (font (size 1.27 1.27)))) )", pin.x, pin.y, pin.rotation, pin.length, pin.getPinMeta().getPinName(), pin.getPinMeta().getPinNumber()));
			pinBuilder.append("\n");
		}
		String pindefs = pinBuilder.toString();

		StringBuilder sb = new StringBuilder();
		String str = super.getStringDef();
		str = str.replaceFirst("\\[ATTACHATTRIBS]", "(pin_numbers hide) (pin_names (offset 0.254) hide)");
		str = str.replaceFirst("\\{PINSDEFS}", pindefs);
		sb.append(str);
		sb.append("\n");
		return sb.toString();
	}

	@Override
	public String getReference() {
		return "R";
	}
}
