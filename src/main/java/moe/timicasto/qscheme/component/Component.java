package moe.timicasto.qscheme.component;

import moe.timicasto.qscheme.component.parts.Pin;
import moe.timicasto.qscheme.component.symbol.ISymbol;
import moe.timicasto.qscheme.component.symbol.LocatedPin;

import java.util.HashMap;
import java.util.Map;

public class Component {
	public Map<String, LocatedPin> numberMap = new HashMap<>();
	public ISymbol symbol;

	public Component(ISymbol symbol) {
		for (LocatedPin pin : symbol.getPins()) {
			numberMap.put(pin.pinMeta.pinNumber, pin);
		}
		this.symbol = symbol;
	}
	
	public Map<String, LocatedPin> getNumberMap() {
		return numberMap;
	}
	
	public ISymbol getSymbol() {
		return symbol;
	}
}
