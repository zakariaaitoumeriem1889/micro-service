package org.sid.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MicroServiceApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private LaboratoryRepository laboratoryRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Student.class);
		Laboratory l1 = laboratoryRepository.save(new Laboratory(null, "Computer Science", "contact@gmail.com", null));
		Laboratory l2 = laboratoryRepository.save(new Laboratory(null, "Biology", "contact@gmail.com", null));
		studentRepository.save(new Student(null, "Hassan", "hassan@gmail.com", new Date(), l1));
		studentRepository.save(new Student(null, "Mohamed", "mohamed@gmail.com", new Date(), l2));
		studentRepository.save(new Student(null, "Samira", "samira@gmail.com", new Date(), l1));
		studentRepository.save(new Student(null, "Hasna", "hasna@gmail.com", new Date(), l2));
	}
}
