package io.openshift.booster;                                                      

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

//import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication(scanBasePackages={"io.openshift"})
public class Booster {

    private static final Logger LOG = LoggerFactory.getLogger(Booster.class);

	public static void main(String[] args) {
	    LOG.info("Starting the Application");
		SpringApplication.run(Booster.class);
	}

	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction(WeatherShareHandler handler) {
	    return route(GET("/weather"), handler::weather).andRoute(GET("/shareprice"), handler::sharePrice);
	}

}