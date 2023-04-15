package com.cvds.lab7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {

			System.out.println("Deleting all the employees on the data base....\n");
			employeeService.getAllEmployees().forEach(employee -> employeeService.deleteEmployee(employee.getEmployeeId()));

			System.out.println("Adding employees with date of birth....\n");
			employeeService.addEmployee(new Employee("Ricardo", "Pulido", "Estudiante", 3000.00, "17/09/2002"));
			employeeService.addEmployee(new Employee("Jorge", "Useche", "Profesor", 3100000.00, "20/10/1992"));

			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));
			System.out.println("\n");
		};
	}

}
