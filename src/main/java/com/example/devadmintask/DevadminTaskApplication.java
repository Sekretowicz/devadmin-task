package com.example.devadmintask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@SpringBootApplication
public class DevadminTaskApplication{

	@Autowired
	EntityManager em;

	public static void main(String[] args) {

		SpringApplication.run(DevadminTaskApplication.class, args);

	}

}
