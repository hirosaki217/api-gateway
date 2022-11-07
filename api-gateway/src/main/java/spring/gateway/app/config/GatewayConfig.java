package spring.gateway.app.config;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.circuitbreaker.springretry.SpringRetryCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.springretry.SpringRetryConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.policy.TimeoutRetryPolicy;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Configuration
public class GatewayConfig {
//	@Bean
//	public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
//		return routeLocatorBuilder.routes()
//				.route(p -> p
//						.path("/books/**")
//						.filters(f -> f.circuitBreaker(c-> c.setName("bookCircuitBreaker").setFallbackUri("/fallback/test")))
//								
//						
//						.uri("lb://BOOK-SERVICE")
//						
//						)
//				.route(p -> p.path("/ratings/**").uri("lb://RATING-SERVICE"))
//				.build();
//	}
	
	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
		CircuitBreakerConfig custom = CircuitBreakerConfig.custom()

				.slidingWindowSize(10).slidingWindowType(SlidingWindowType.COUNT_BASED).failureRateThreshold(50f)
				.minimumNumberOfCalls(5).automaticTransitionFromOpenToHalfOpenEnabled(true)
				.maxWaitDurationInHalfOpenState(Duration.ofSeconds(20)).permittedNumberOfCallsInHalfOpenState(3)
				.waitDurationInOpenState(Duration.ofSeconds(10))
				
				.build();
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)

				.circuitBreakerConfig(custom)
				
				.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build()).build());
	}
	@Bean
	public Customizer<SpringRetryCircuitBreakerFactory> defaultCustomizer1() {
	    return factory -> factory.configureDefault(id -> new SpringRetryConfigBuilder(id)
	    
	        .retryPolicy(new TimeoutRetryPolicy())
	        
	        .build());
	}

}
