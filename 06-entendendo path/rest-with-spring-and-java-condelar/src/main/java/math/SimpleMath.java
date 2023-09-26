package math;

public class SimpleMath {

	public Double sum(Double numberOne, Double numberTwo) {
		Double result = numberOne + numberTwo;
		return result;
	}

	public Double subtraction(Double numberOne, Double numberTwo) throws Exception {
		Double result = numberOne - numberTwo;
		return result;
	}

	public Double multiplication(Double numberOne, Double numberTwo) {
		Double result = numberOne * numberTwo;
		return result;
	}

	public Double division(Double numberOne, Double numberTwo) {
		Double result = numberOne / numberTwo;
		return result;
	}

	public Double media(Double numberOne, Double numberTwo) {
		Double result = (numberOne + numberTwo) / 2;
		return result;
	}

	public Double squareRoot(Double numberOne) {
		Double result = (numberOne);
		return Math.sqrt(result);
	}

}
