package com.sandbox.springboot.libraryV2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class LibraryV2Application {

	public static void main(String[] args) {
		SpringApplication.run(LibraryV2Application.class, args);
	}
}
