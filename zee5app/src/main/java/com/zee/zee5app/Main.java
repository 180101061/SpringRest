package com.zee.zee5app;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidEmailException;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.InvalidUserNameException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.service.UserService;

public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = null;
		context = SpringApplication.run(Zee5appApplication.class, args);
		UserService userService = context.getBean(UserService.class);
		
//			try {
//				userService.insertuser(new User("","akkuA","kumari","akku@zee.com","hi","hi",LocalDate.now(),LocalDate.of(1997, 12, 29),false));
//			} catch (UnableToGenerateIdException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidEmailException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidUserNameException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
//		private String userId;
//		private String userName;
//		private String password;
//		private String firstName;
//		private String lastName;
//		private String email;
//		private LocalDate doj;
//		private LocalDate dob;
////		private boolean active;
//		try {
//			userService.insertuser(new User("","Mohit","Mohit","Mohit","Kumar","Mohit@zee.com",LocalDate.now(),LocalDate.of(1997, 12, 29),false));
//		} catch (UnableToGenerateIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidEmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidUserNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			userService.insertuser(new User("","Mohan","Mohan","Mohian","Kumari","Mohini@zee.com",LocalDate.now(),LocalDate.of(1996, 12, 29),false));
//		} catch (UnableToGenerateIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidEmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidUserNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		
//		try {
//			userService.insertuser(new User("","Rahul","kumar","Rahul@zee.com",LocalDate.now(),LocalDate.of(1997, 12, 29),false));
//		} catch (UnableToGenerateIdException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			userService.deleteUser("ak00000001");
//		} catch (NoDataFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//			try {
//				userService.insertuser( new User("","Lion","Goat","Goat","kumar","Goat@zee.com",LocalDate.now(),LocalDateTime.of(1997, 12, 29,19,30,43),false));
//			} catch (InvalidEmailException | RecordAlreadyExistsException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		try {
//			userService.updateUser("PK00000023",new User("","Prity","Prity@123","Prity","Kumari","Prity_rawat@zee.com",LocalDate.now(),LocalDateTime.of(1996, 12, 29,12,13,14),false));
//		} catch (InvalidIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
	}
}
