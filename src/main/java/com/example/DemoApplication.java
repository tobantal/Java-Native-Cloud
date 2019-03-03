package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lombok.Getter;
import lombok.NoArgsConstructor;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@Entity
@NoArgsConstructor
class Cat {

	@Id
	@GeneratedValue
	@Getter private Long id;

	@Getter private String name;

	public Cat(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Cat{id=%l, name='%s'}", id, name);
	}
}

@RepositoryRestResource
interface CatRepository extends JpaRepository<Cat, Long> { }

