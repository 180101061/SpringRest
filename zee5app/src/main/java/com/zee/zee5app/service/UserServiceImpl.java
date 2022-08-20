package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidEmailException;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.InvalidUserNameException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.RecordAlreadyExistsException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

import com.zee.zee5app.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService {


	@Autowired
    private UserRepository repo ;
	@Override
	public User insertuser(User user) throws  InvalidEmailException, RecordAlreadyExistsException {
		// TODO Auto-generated method stub
		if(repo.existsByEmail(user.getEmail())) {
			throw new InvalidEmailException("Email already exist");
		}
		if(repo.existsByUserName(user.getUserName())) {
			throw new RecordAlreadyExistsException("UserName already existed");
		}
		return repo.save(user);
	}

	@Override
	public String updateUser(String userId, User user) throws InvalidIdException  {
		if(repo.existsById(userId)) {
			user.setUserId(userId);
			repo.save(user);
			return "Updated Successfully";
		}else {
			throw new InvalidIdException("UserId "+userId+" not found");
		}
		// TODO Auto-generated method stub
		//return repo.updateUser(userId, user);
	}

	@Override
	public String deleteUser(String userId) throws NoDataFoundException {

		try {
			// TODO Auto-generated method stub
			if (repo.existsById(userId)) {
				repo.deleteById(userId);
				return "SUCCESSFULLY DELETED";
			} else {
				throw new NoDataFoundException("Id Not Existing");
			}
		} catch (NoDataFoundException e) {
			// TODO: handle exception

			throw e;
		}catch(Exception e) {
			//to handle any exception except nodatafoundexception
			throw e;
		}
		
	}

	
	@Override
	public  Optional<List<User>> getAllUser() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repo.findAll());
	}

	@Override
	public Optional<User> getUserByUserId(String UserId) {
		// TODO Auto-generated method stub
		return repo.findById(UserId);
	}

}
