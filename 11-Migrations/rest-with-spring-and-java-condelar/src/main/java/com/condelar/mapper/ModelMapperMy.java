package com.condelar.mapper;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;

public class ModelMapperMy {

	private static ModelMapper mapper = new ModelMapper();

	public static <O, D> D parceObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}

	public static <O, D> List<D> parceListObject(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<>();
		origin.forEach(o -> {
			destinationObjects.add(parceObject(o, destination));
		});
		return destinationObjects;
	}
}
