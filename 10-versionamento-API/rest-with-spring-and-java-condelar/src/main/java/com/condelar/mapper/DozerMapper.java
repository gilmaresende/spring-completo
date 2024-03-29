package com.condelar.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

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
