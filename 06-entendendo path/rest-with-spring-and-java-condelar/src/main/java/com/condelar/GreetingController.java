package com.condelar;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.condelar.exception.UnsupportedMathOperationException;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s";
	private static final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("please set a numeric value!");

		Double result = convertToDouble(numberOne) + convertToDouble(numberTwo);
		System.out.println(result);
		return result;
	}

	private boolean isNumeric(String numberOne) {
		if (numberOne == null)
			return false;
		String number = numberOne.replaceAll(",", ".");
		return number.matches("[+-]?[0-9]*\\.?[0-9]+");

	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);
		return 0D;
	}
}