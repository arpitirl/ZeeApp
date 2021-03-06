package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.Register;

public interface UserService {
	public String addUser(Register register);
	public Register updateUser(String id, Register register);
	public Optional<Register> getUserById(String id);
	public Register[] getAllUsers();
	public void deleteUserById(String id);

}
