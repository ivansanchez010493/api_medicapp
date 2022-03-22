package mx.com.medicapp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoder.encode("12345"));
	}
}
