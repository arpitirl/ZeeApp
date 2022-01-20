package com.zee.zee5app.repository;
import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.*;

public interface UserRepository {
	public String addUser(Register register);
	public Register updateUser(String id, Register register);
	public Optional<Register> getUserById(String id);
	public Register[] getAllUsers();
	public void deleteUserById(String id);

}
