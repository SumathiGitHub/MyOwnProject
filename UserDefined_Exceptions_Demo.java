package com.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDefined_Exceptions_Demo {

	public static void main(String[] args) {

		UserDefined_Exceptions_Demo obj1 = new UserDefined_Exceptions_Demo();
		try {
			obj1.validateAge(12);
		} catch (InvalidAgeException e) {
			e.printStackTrace();
		}

		try {
			obj1.withdraw(10000, 5000);
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}

		try {
			obj1.validateEmail("goalsumathi*gmail.com");
		} catch (InvalidEmailException e) {
			e.printStackTrace();
		}

		try {
			obj1.findProduct("Computer");
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}

		try {
			obj1.validateMarks(-12);
		} catch (NegativeMarksException e) {
			e.printStackTrace();
		}

		try {
			obj1.userExist("Mohana");
		} catch (UsernameAlreadyExistsException e) {
			e.printStackTrace();
		}

		try {
			obj1.validatePhoneNumber("9876543210"); // valid
			obj1.validatePhoneNumber("98AB543210"); // invalid: contains letters
			obj1.validatePhoneNumber("12345");      // invalid: not 10 digits
		} catch (InvalidPhoneNumberException e) {
			e.printStackTrace();
		}

		try {
			int result1 = obj1.safeDivide(10, 2); // valid
			System.out.println("Result: " + result1);

			int result2 = obj1.safeDivide(10, 0); // will throw exception
			System.out.println("Result: " + result2);
		} catch (DivisionByZeroNotAllowedException e) {
			e.printStackTrace();
		}

		try {
			obj1.openFile("document.txt"); // valid
			obj1.openFile("resume.pdf"); // will throw exception
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
		}

		try {
			obj1.validatePassword("pass");
			obj1.validatePassword("password");
			obj1.validatePassword("pass1234");
			obj1.validatePassword("Pass@1234");
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		}
	}

	public void validatePassword(String password) throws InvalidPasswordException {
		if (password.length() < 8) {
			throw new InvalidPasswordException("Password must be at least 8 characters long.");
		}
		if (!password.matches(".*\\d.*")) {
			throw new InvalidPasswordException("Password must contain at least one digit.");
		}
		if (!password.matches(".*[!@#$%^&*()].*")) {
			throw new InvalidPasswordException("Password must contain at least one special character (!@#$%^&*()).");
		}

		System.out.println("Password '" + password + "' is valid ✅");
	}

	public void openFile(String fileName) throws InvalidFileFormatException {
		if (!fileName.endsWith(".txt")) {
			throw new InvalidFileFormatException(
					"Invalid file format: Only .txt files are allowed! (" + fileName + ")");
		}
		System.out.println("File '" + fileName + "' opened successfully!");
	}

	public int safeDivide(int a, int b) throws DivisionByZeroNotAllowedException {
		if (b == 0) {
			throw new DivisionByZeroNotAllowedException("Division by zero is not allowed!");
		}
		return a / b;
	}

	public void validatePhoneNumber(String phone) throws InvalidPhoneNumberException {
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new InvalidPhoneNumberException("Invalid phone number: " + phone);
		} else {
			System.out.println("Valid phone number: " + phone);
		}
	}

	public void userExist(String userName) throws UsernameAlreadyExistsException {
		List<String> userList = new ArrayList<>(Arrays.asList("Sumathi", "Karthick", "Priya", "Mohith", "Jawahar"));
		if (userList.contains(userName)) {
			throw new UsernameAlreadyExistsException("Username - " + userName + " already exists.");
		} else {
			userList.add(userName);
			System.out.println("User '" + userName + "' successfully registered!");
		}
	}

	public void validateMarks(int marks) throws NegativeMarksException {
		if (marks < 0) {
			throw new NegativeMarksException("Marks cannot be negative: " + marks);
		} else {
			System.out.println("Marks entered: " + marks);
		}
	}

	public void findProduct(String product) throws ProductNotFoundException {
		List<String> products = Arrays.asList("Laptop", "Phone", "TV");
		if (!products.contains(product)) {
			throw new ProductNotFoundException("Product not found: " + product);
		} else {
			System.out.println(product + " is available in stock.");
		}
	}

	public void validateEmail(String email) throws InvalidEmailException {
		if (!email.contains("@")) {
			throw new InvalidEmailException("Invalid email format: " + email);
		} else {
			System.out.println("Valid email: " + email);
		}
	}

	public void withdraw(int amount, int balance) throws InsufficientBalanceException {

		if (amount > balance) {
			throw new InsufficientBalanceException("Withdrawal failed! Insufficient balance.");
		} else {
			System.out.println("Withdrawal successful. Remaining balance: " + (balance - amount));
		}
	}

	public void validateAge(int age) throws InvalidAgeException {

		if (age < 18) {
			throw new InvalidAgeException("Age must be 18 or above for voting.");
		} else {
			System.out.println("you are eligible...you can vote!");
		}
	}

}

class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String msg) {
		super(msg);
	}
}

class InvalidFileFormatException extends Exception {
	public InvalidFileFormatException(String msg) {
		super(msg);
	}
}

class DivisionByZeroNotAllowedException extends Exception {
	public DivisionByZeroNotAllowedException(String msg) {
		super(msg);
	}
}

class InvalidPhoneNumberException extends Exception {
	public InvalidPhoneNumberException(String message) {
		super(message);
	}
}

class UsernameAlreadyExistsException extends Exception {
	public UsernameAlreadyExistsException(String message) {
		super(message);
	}
}

class NegativeMarksException extends Exception {
	public NegativeMarksException(String message) {
		super(message);
	}
}

class ProductNotFoundException extends Exception {
	public ProductNotFoundException(String message) {
		super(message);
	}
}

class InvalidEmailException extends Exception {
	public InvalidEmailException(String message) {
		super(message);
	}
}

class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message);
	}
}

class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
}
