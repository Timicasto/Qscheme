package moe.timicasto.qscheme.component.symbol.simple;

import moe.timicasto.qscheme.component.parts.Pin;
import moe.timicasto.qscheme.component.symbol.ISymbol;
import moe.timicasto.qscheme.component.symbol.LocatedPin;
import moe.timicasto.qscheme.component.symbol.shapes.IShape;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSymbol implements ISymbol {
	final List<LocatedPin> pins;
	List<IShape> shapes;
	String value;
	
	public AbstractSymbol(String value, Pin... pins) {
		int i = 0;
		this.pins = new ArrayList<>();
		this.value = value;
		for (Pin pin : pins) {
			this.pins.add(new LocatedPin(pin, 0, i * 2.54, 2.54, 0));
			++i;
		}
	}
	
	@Override
	public List<LocatedPin> getPins() {
		return pins;
	}
	
	@Override
	public boolean isNumberHided() {
		return false;
	}
	
	@Override
	public abstract String getReference();
	
	@Override
	public String getValue() {
		return this.value;
	}
	
	@Override
	public void setValue(String val) {
		this.value = val;
	}
	
	@Override
	public List<IShape> getShapes() {
		return shapes;
	}
	
	@Override
	public String getStringDef() {
		StringBuilder builder = new StringBuilder();

		builder.append("(symbol ");
		builder.append("\"").append("[LIBID]").append("\" [ATTACHATTRIBS]").append(" (in_bom yes) (on_board yes)\n");

		builder.append("  (property \"Reference\"" + " \"").append("[REFERENCE]").append("\" ").append("(at 0 1.27 0)\n");
		builder.append("    (effects (font (size 1.27 1.27)))\n  )\n");

		builder.append("  (property \"Value\"" + " \"").append("[VALUE]").append("\" ").append("(at 0 1.27 0)\n");
		builder.append("    (effects (font (size 1.27 1.27)))\n  )\n");

		builder.append("  (property \"Footprint\"" + " \"").append("[FOOTPRINT]").append("\" ").append("(at 0 1.27 0)\n");
		builder.append("    (effects (font (size 1.27 1.27)) hide)\n  )\n");

		builder.append("  (property \"Datasheet\"" + " \"").append("[DATASHEET]").append("\" ").append("(at 0 1.27 0)\n");
		builder.append("    (effects (font (size 1.27 1.27)) hide)\n  )\n");

		builder.append("  (symbol \"").append("[LIBSUBID]").append("_1_1\"\n");

		for (IShape shape : getShapes()) {
			builder.append(shape.getStringDef());
			builder.append("\n");
		}


		builder.append("{PINSDEFS}");

		builder.append("  )\n");

		builder.append(')');
		// TODO: Generate Symbol String
		return builder.toString();
	}
}
