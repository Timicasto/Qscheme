package moe.timicasto.qscheme.component;

import moe.timicasto.qscheme.component.parts.Pin;
import moe.timicasto.qscheme.component.symbol.ISymbol;

import java.util.HashMap;
import java.util.Map;

public class Component {
	public Map<String, String> nameMap = new HashMap<>();
	public Map<String, String> numberMap = new HashMap<>();
	public ISymbol symbol;

	public Component(Pin... pins) {
		for (Pin pin : pins) {
			nameMap.put(pin.pinName, pin.pinNumber);
			numberMap.put(pin.pinNumber, pin.pinName);
		}
	}
}
