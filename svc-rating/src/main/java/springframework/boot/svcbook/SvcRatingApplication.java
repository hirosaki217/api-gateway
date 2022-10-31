package springframework.boot.svcbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.core.Ordered;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(order=Ordered.LOWEST_PRECEDENCE, mode=AdviceMode.ASPECTJ)
public class SvcRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcRatingApplication.class, args);
	}

}
