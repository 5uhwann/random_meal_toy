package toy.random_meal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RandomMealApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomMealApplication.class, args);
	}

}
