package moe.timicasto.qscheme.component.parts;

public class Pin {
	public final String pinName;
	public final String pinNumber;

	public Pin(String name, String number) {
		this.pinName = name;
		this.pinNumber = number;
	}

	public String getPinName() {
		return pinName;
	}

	public String getPinNumber() {
		return pinNumber;
	}
}
