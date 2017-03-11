package com.droidzilla.apiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

//	@Autowired
//	private CustomerRepository repository;

	public static void main(String[] args) {
//		ApplicationContext ctx = SpringApplication.run(ApiaryApplication.class, args);

		SpringApplication.run(Application.class, args);
//		writeNumber(0);
	}

//	public static boolean writeNumber(int number) {
//		System.out.println(""+ number);
//		return (number == 10) || writeNumber(++number);
//	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		repository.deleteAll();
//
//		// save a couple of customers
//		repository.save(new Customer("Alice", "Smith"));
//		repository.save(new Customer("Bob", "Smith"));
//
//		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Customer customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//
//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(repository.findByFirstName("Alice"));
//
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (Customer customer : repository.findByLastName("Smith")) {
//			System.out.println(customer);
//		}
//
//	}

}
