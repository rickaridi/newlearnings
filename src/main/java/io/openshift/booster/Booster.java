package io.openshift.booster;                                                      

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication(scanBasePackages={"io.openshift"})
public class Booster {

	public static void main(String[] args) {
		SpringApplication.run(Booster.class);
	}

	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction(WeatherShareHandler handler) {
		return route(POST("/weather"), handler::weather).andRoute(GET("/shareprice"), handler::sharePrice);
	}

}