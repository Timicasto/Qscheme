package moe.timicasto.qscheme;

import moe.timicasto.qscheme.component.Component;
import moe.timicasto.qscheme.component.symbol.simple.AntennaSymbol;
import moe.timicasto.qscheme.component.symbol.simple.CapacitorSymbol;
import moe.timicasto.qscheme.component.symbol.simple.ResistorSymbol;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		CapacitorSymbol capacitor = new CapacitorSymbol("68uF");
		CapacitorSymbol capacitorSymbol = new CapacitorSymbol("100uF");
		CapacitorSymbol c = new CapacitorSymbol("100nF");
		ResistorSymbol r = new ResistorSymbol("5.1K");
		AntennaSymbol an = new AntennaSymbol("ANT3216LL00R2400A");
		Eschematic eschematic = new Eschematic(new SchematicMeta("TestTitle", "A", "Timicasto", "2023-04-01"));
		eschematic.add(new Component(capacitor));
		eschematic.add(new Component(capacitorSymbol));
		for (int i = 0; i < 1800; i++) {
			eschematic.add(new Component(an));
		}
		//System.out.println(eschematic.compile());

		BufferedWriter writer = new BufferedWriter(new FileWriter("./test.kicad_sch"));
		writer.write(eschematic.compile());
		writer.close();
	}
}
