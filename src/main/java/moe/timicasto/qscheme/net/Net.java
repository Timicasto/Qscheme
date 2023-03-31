package moe.timicasto.qscheme.net;

import moe.timicasto.qscheme.component.symbol.LocatedPin;

import java.util.ArrayList;
import java.util.List;

public class Net {
	public String name;
	public List<LocatedPin> connects;
	
	public Net(String name) {
		this.name = name;
		connects = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public List<LocatedPin> getConnects() {
		return connects;
	}
	
	public void attach(LocatedPin pin) {
		connects.add(pin);
		pin.nets.add(this);
	}
}
