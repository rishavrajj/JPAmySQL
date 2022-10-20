package net.codejava.JPAmySQL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import net.codejava.JPAmySQL.Model.Expense;
import net.codejava.JPAmySQL.Repository.ExpenseRepository;

@SpringBootApplication
public class JpAmySqlApplication implements CommandLineRunner {
    @Autowired
    ExpenseRepository repository;
    
	public static void main(String[] args) {
		SpringApplication.run(JpAmySqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	        repository.save(new Expense(1L, "coffee", 2));
	        repository.save(new Expense(2L,"New SSD drive", 200));
	        repository.save(new Expense(3L,"Tution for baby", 350));
	        repository.save(new Expense(4L,"Some apples", 5));
	         
	        Iterable<Expense> iterator = repository.findAll();
	         
	        System.out.println("All expense items: ");
	        iterator.forEach(item -> System.out.println(item));
	         
	        List<Expense> breakfast = repository.findByItem("breakfast");
	        System.out.println("\nHow does my breakfast cost?: ");
	        breakfast.forEach(item -> System.out.println(item));
	         
	        List<Expense> expensiveItems = repository.listItemsWithPriceOver(200);
	        System.out.println("\nExpensive Items: ");
	        expensiveItems.forEach(item -> System.out.println(item));   
	    }
}
