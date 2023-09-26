package com.condelar;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.condelar.converters.NumberConveter;
import com.condelar.exception.UnsupportedMathOperationException;

import math.SimpleMath;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s";
	private static final AtomicLong counter = new AtomicLong();

	private SimpleMath math = new SimpleMath();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConveter.isNumeric(numberOne) || !NumberConveter.isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("please set a numeric value!");

		Double result = math.sum(NumberConveter.convertToDouble(numberOne), NumberConveter.convertToDouble(numberTwo));
		return result;
	}

	@RequestMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConveter.isNumeric(numberOne) || !NumberConveter.isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("please set a numeric value!");

		Double result = math.subtraction(NumberConveter.convertToDouble(numberOne),
				NumberConveter.convertToDouble(numberTwo));
		return result;
	}

	@RequestMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConveter.isNumeric(numberOne) || !NumberConveter.isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("please set a numeric value!");

		Double result = math.multiplication(NumberConveter.convertToDouble(numberOne),
				NumberConveter.convertToDouble(numberTwo));
		return result;
	}

	@RequestMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConveter.isNumeric(numberOne) || !NumberConveter.isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("please set a numeric value!");

		Double result = math.division(NumberConveter.convertToDouble(numberOne),
				NumberConveter.convertToDouble(numberTwo));
		return result;
	}

	@RequestMapping("/media/{numberOne}/{numberTwo}")
	public Double media(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConveter.isNumeric(numberOne) || !NumberConveter.isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("please set a numeric value!");

		Double result = math.media(NumberConveter.convertToDouble(numberOne),
				NumberConveter.convertToDouble(numberTwo));
		return result;
	}

	@RequestMapping("/squareRoot/{numberOne}")
	public Double squareRoot(@PathVariable(value = "numberOne") String numberOne) throws Exception {

		if (!NumberConveter.isNumeric(numberOne))
			throw new UnsupportedMathOperationException("please set a numeric value!");

		Double result = math.squareRoot(NumberConveter.convertToDouble(numberOne));
		return Math.sqrt(result);
	}

}