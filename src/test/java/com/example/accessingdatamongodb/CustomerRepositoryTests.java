package com.example.accessingdatamongodb;
/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.example.accessingdatamongodb.Customer;
import com.example.accessingdatamongodb.CustomerRepository;

@SpringBootTest
public class CustomerRepositoryTests {

	@Autowired
	CustomerRepository repository;

	Customer dave, oliver, carter;

	@BeforeEach
	public void setUp() {

		repository.deleteAll();

		dave = repository.save(new Customer("Dave", "Matthews","bike1", "type1","description1","imageURL1","modelURL1",null,null));
		oliver = repository.save(new Customer("Oliver August", "Matthews","bike1", "type1","description1","imageURL1","modelURL1",null,null));
		carter = repository.save(new Customer("Carter", "Beauford","bike1", "type1","description1","imageURL1","modelURL1",null,null));
	}

	@Test
	public void setsIdOnSave() {

		Customer dave = repository.save(new Customer("Dave", "Matthews","bike1", "type1","description1","imageURL1","modelURL1",null,null));

		assertThat(dave.id).isNotNull();
	}

	@Test
	public void findsByLastName() {

		List<Customer> result = repository.findByLastName("Beauford");

		assertThat(result).hasSize(1).extracting("firstName").contains("Carter");
	}

	@Test
	public void findsByExample() {

		Customer probe = new Customer(null, "Matthews","bike1", "type1","description1","imageURL1","modelURL1",null,null);

		List<Customer> result = repository.findAll(Example.of(probe));

		assertThat(result).hasSize(2).extracting("firstName").contains("Dave", "Oliver August");
	}
}
