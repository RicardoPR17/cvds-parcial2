package com.cvds.lab7;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String role;
	private Double salary;
	private LocalDate birthDate;

	public Employee() {

	}

	public Employee(String string, String string2, String string3, double d) {
		this.firstName = string;
		this.lastName = string2;
		this.role = string3;
		this.salary = d;
	}

	public Employee(String string, String string2, String string3, double d, String string4) {
		this.firstName = string;
		this.lastName = string2;
		this.role = string3;
		this.salary = d;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.birthDate = LocalDate.parse(string4, dateFormat);
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long EmployeeId) {
		this.employeeId = EmployeeId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String LastName) {
		this.lastName = LastName;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String Role) {
		this.role = Role;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double Salary) {
		this.salary = Salary;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int calculateAge() {
		LocalDate now = LocalDate.now();
		Period ageCalculated = Period.between(birthDate, now);
		return ageCalculated.getYears();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!role.equals(other.birthDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", role="
				+ role + ", salary=" + salary + ", date of birth=" + birthDate + ", age=" + calculateAge() + "]";
	}

}