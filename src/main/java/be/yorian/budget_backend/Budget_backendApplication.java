package be.yorian.budget_backend;

import be.yorian.budget_backend.config.BudgetBackendConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(BudgetBackendConfig.class)
public class Budget_backendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Budget_backendApplication.class, args);
	}

}
