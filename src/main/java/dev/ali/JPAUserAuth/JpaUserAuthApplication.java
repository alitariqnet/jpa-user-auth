package dev.ali.JPAUserAuth;

import dev.ali.JPAUserAuth.entity.Post;
import dev.ali.JPAUserAuth.entity.User;
import dev.ali.JPAUserAuth.repository.PostRepository;
import dev.ali.JPAUserAuth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JpaUserAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaUserAuthApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository posts, UserRepository users, PasswordEncoder encoder){
		return args -> {
			users.save(new User("user",encoder.encode("password"),"ROLE_USER"));
			users.save(new User("admin",encoder.encode("password"),"ROLE_USER,ROLE_ADMIN"));
			posts.save(new Post("Hello world!","hello-world","Hello world to my blog!","Ali Tariq"));
		};
	}
}
