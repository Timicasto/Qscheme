package moe.timicasto.qscheme.component.symbol.simple;

import moe.timicasto.qscheme.component.parts.Pin;
import moe.timicasto.qscheme.component.symbol.ISymbol;
import moe.timicasto.qscheme.component.symbol.LocatedPin;
import moe.timicasto.qscheme.component.symbol.shapes.IShape;

import java.util.List;

public abstract class AbstractSymbol implements ISymbol {
	List<LocatedPin> pins;
	List<IShape> shapes;
	String value;
	
	public AbstractSymbol(String value, Pin... pins) {
		int i = 0;
		this.value = value;
		for (Pin pin : pins) {
			this.pins.add(new LocatedPin(pin, 0, i * 2.54, 2.54));
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
		// TODO: Generate Symbol String
		return null;
	}
}
