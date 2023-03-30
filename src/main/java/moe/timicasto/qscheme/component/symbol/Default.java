package moe.timicasto.qscheme.component.symbol;

import java.util.List;

public class Default implements ISymbol {

	private List<LocatedPin> pins;



	@Override
	public List<LocatedPin> getPins() {
		return pins;
	}

	@Override
	public boolean isNumberHided() {
		return false;
	}

	@Override
	public String getReference() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setValue() {

	}
}
