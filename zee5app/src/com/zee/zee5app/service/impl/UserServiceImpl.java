package com.zee.zee5app.service.impl;

import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

public class UserServiceImpl implements UserService {

	
	private static UserService service;
	public static UserService getInstance() {
		// TODO Auto-generated constructor stub
		if(service==null) {
			service=new UserServiceImpl();
		}
		return service;
	}
	UserRepository repository=UserRepositoryImpl.getInstance();
	@Override
	public String addUser(Register register) {
		
		return this.repository.addUser(register);
	}

	@Override
	public Register updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return repository.updateUser(id, register);
	}

	@Override
	public Optional<Register> getUserById(String id) {
		// TODO Auto-generated method stub
		return repository.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return repository.getAllUsers();
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		repository.deleteUserById(id);
	}

}
