package io.openshift.booster;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.BodyInserters;

@Component
public class WeatherShareHandler {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherShareHandler.class);
    
	public Mono<ServerResponse> weather(ServerRequest request) {
	    LOG.info("Got request for Weather: {}", request.queryParam("city").get());
		return ServerResponse.ok().body(BodyInserters.fromObject(request.queryParam("city").get()));
	}

	public Mono<ServerResponse> sharePrice(ServerRequest request) {
	    LOG.info("Got request for Share Price: {}", request.queryParams());
	    LOG.info("Got request fron TFA repo for Share Price: {}", request.queryParams());
		return ServerResponse.ok().body(BodyInserters.fromObject("World"));
	}
}