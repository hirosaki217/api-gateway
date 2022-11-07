package spring.gateway.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import spring.gateway.app.model.GatewayResponse;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
	private int id =0;
	@GetMapping("/test")
	public Mono<GatewayResponse> fallback()
	{
		return Mono.just(new GatewayResponse(++id, "I'm fallback!"));
	}
}
