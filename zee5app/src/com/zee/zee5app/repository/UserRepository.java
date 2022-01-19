package com.zee.zee5app.repository;
import com.zee.zee5app.dto.*;

public interface UserRepository {
	public String addUser(Register register);
	public Register updateUser(String id, Register register);
	public Register getUserById(String id);
	public Register[] getAllUsers();
	public void deleteUserById(String id);

}
