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
	
	public void addNet(Net net) {
		nets.add(net);
	}
	
	public void add(Component component) {
		components.add(component);
	}

	public String compile() {
		StringBuilder sb = new StringBuilder();

		sb.append("(kicad_sch \n");

		sb.append("  (version 20230221) (generator qcheme)\n");

		sb.append("  (uuid ").append(this.uuid.toString()).append(")\n");

		sb.append("  (paper \"A3\")\n");

		sb.append("(lib_symbols\n");

		sb.append(")");

		sb.append(")");

		return sb.toString();
	}
	
}
