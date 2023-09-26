package com.condelar.converters;

public class NumberConveter {

	public static boolean isNumeric(String numberOne) {
		if (numberOne == null)
			return false;
		String number = numberOne.replaceAll(",", ".");
		return number.matches("[+-]?[0-9]*\\.?[0-9]+");

	}

	public static Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);
		return 0D;
	}

}
