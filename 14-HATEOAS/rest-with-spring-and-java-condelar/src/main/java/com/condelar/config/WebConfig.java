package com.condelar.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.condelar.serialization.converter.YamlJackson2HttpMesageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/*
	 * XML via header
	 * 
	 * para funcionar deve remover o 3 na assinatura
	 */
	// @Override
	public void configureContentNegotiation3(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(false).ignoreAcceptHeader(false).useRegisteredExtensionsOnly(false)
				.defaultContentType(MediaType.APPLICATION_JSON).mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML);

	}

	/*
	 * XML via query param
	 * 
	 * para funcionar deve remover o 2 na assinatura
	 */
	// @Override
	public void configureContentNegotiation2(ContentNegotiationConfigurer configurer) {

		configurer.favorParameter(true).parameterName("mediaType").ignoreAcceptHeader(true)
				.useRegisteredExtensionsOnly(false).defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("json", MediaType.APPLICATION_JSON).mediaType("xml", MediaType.APPLICATION_XML);
	}

	private static final MediaType MEDIA_TYPE_APPLICATION_YAML = MediaType
			.valueOf(com.condelar.util.MediaType.APPLICATION_YAML);
	
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMesageConverter());
	}

	/*
	 * XML e YAML via header
	 * 
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(false).ignoreAcceptHeader(false).useRegisteredExtensionsOnly(false)
				.defaultContentType(MediaType.APPLICATION_JSON).mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML).mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YAML);
	}

}
