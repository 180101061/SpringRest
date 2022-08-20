package com.zee.zee5app.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidEmailException;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.InvalidUserNameException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	@PostMapping("/add") //post method + requestmapping 
	public ResponseEntity<?> createUser(@RequestBody User user)
			throws InvalidEmailException, RecordAlreadyExistsException {
		User user2 = new User();

		user2 = userService.insertuser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
	}
	@GetMapping("/getall")
	public List<User> getAllUser() {

		Optional<List<User>> result = userService.getAllUser();
		List<User> users = result.get();
		for(User user : users)System.out.println(user);
		return users;
	}
	@DeleteMapping("/{userId}")
	public String deleteUserById(@PathVariable("userId") String userId) {
		try {
			userService.deleteUser(userId);
			return "User Deleted by userId : "+ userId;
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fail";
	}
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") String userId) {
		Optional<User> result = userService.getUserByUserId(userId);
		User user = result.get();
		return user;
	}
	@PutMapping("/put/{userId}")
	public String updateUser(@PathVariable("userId")String userId, @RequestBody User user) throws InvalidIdException {
		userService.updateUser(userId, user);
		//System.out.println(userId);
		//System.out.println(user);
		return "Updated Successfully ";
	}
}
