package moe.timicasto.qscheme.component.symbol;

import moe.timicasto.qscheme.component.symbol.shapes.IShape;

import java.util.List;

public interface ISymbol {
	List<LocatedPin> getPins();
	boolean isNumberHided();
	String getReference();
	String getValue();
	void setValue(String val);
	List<IShape> getShapes();
	String getStringDef();
}
