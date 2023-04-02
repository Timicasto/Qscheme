package moe.timicasto.qscheme;

import moe.timicasto.qscheme.component.Component;
import moe.timicasto.qscheme.component.symbol.shapes.*;
import moe.timicasto.qscheme.component.symbol.simple.CapacitorSymbol;
import moe.timicasto.qscheme.utils.Vec2d;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		CapacitorSymbol capacitor = new CapacitorSymbol("68uF");
		CapacitorSymbol capacitorSymbol = new CapacitorSymbol("100uF");
		CapacitorSymbol c = new CapacitorSymbol("100nF");
		Eschematic eschematic = new Eschematic(new SchematicMeta("TestTitle", "A", "Timicasto", "2023-04-01"));
		eschematic.add(new Component(capacitor));
		eschematic.add(new Component(capacitorSymbol));
		for (int i = 0; i < 1800; i++) {
			eschematic.add(new Component(c));
		}
		//System.out.println(eschematic.compile());

		BufferedWriter writer = new BufferedWriter(new FileWriter("./test.kicad_sch"));
		writer.write(eschematic.compile());
		writer.close();
	}
}
