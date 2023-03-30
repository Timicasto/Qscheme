package moe.timicasto.qscheme.component.symbol;

import java.util.List;

public interface ISymbol {
	List<LocatedPin> getPins();
	boolean isNumberHided();
	String getReference();
	String getValue();
	void setValue();
	
}
