package com.example.VismaInternalMeetings;

import com.example.VismaInternalMeetings.repository.MeetingJsonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
//@EnableJpaRepositories(basePackages = "com.example.VismaInternalMeetings.repository")
@EnableJpaRepositories(repositoryBaseClass = MeetingJsonRepository.class)
public class VismaInternalMeetingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VismaInternalMeetingsApplication.class, args);
	}

}
