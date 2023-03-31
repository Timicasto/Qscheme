package moe.timicasto.qscheme;

import moe.timicasto.qscheme.component.Component;
import moe.timicasto.qscheme.net.Net;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Eschematic {
	public List<Net> nets = new ArrayList<>();
	public List<Component> components = new ArrayList<>();
	public SchematicMeta meta;
	public UUID uuid;
	
	public Eschematic(SchematicMeta meta) {
		this.meta = meta;
		this.uuid = UUID.randomUUID();
	}
	
	void addNet(Net net) {
		nets.add(net);
	}
	
	void add(Component component) {
		components.add(component);
	}
	
}
