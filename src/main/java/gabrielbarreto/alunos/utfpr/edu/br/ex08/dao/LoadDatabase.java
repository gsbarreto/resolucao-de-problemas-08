package gabrielbarreto.alunos.utfpr.edu.br.ex08.dao;


import gabrielbarreto.alunos.utfpr.edu.br.ex08.entity.Employee;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(EmployeeDao repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Employee("Gabriel",22,2000)));
			log.info("Preloading " + repository.save(new Employee("Pedro",15,1000)));
		};
	}
}
