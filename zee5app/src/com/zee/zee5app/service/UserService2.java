package com.zee.zee5app.service;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.*;
import com.zee.zee5app.repository.UserRepository;
public class UserService2 {
	private UserRepository2 repository=UserRepository2.getInstance();
	//service is consuming the repository
	
	private UserService2() {
		// TODO Auto-generated constructor stub
	}
	private static UserService2 service=null;
	public static UserService2 getInstance() {
		if (service==null)
			service=new UserService2();
		return(service);
		
	}
	public String addUser(Register register) {
		return this.repository.addUser(register);
		
	}
	public Register getUserById(String id) {
		return repository.getUserById(id);
	}
	public Register updateUser(String id, Register register) {
		return repository.updateUser(id, register);
	}
	public void deleteUser(String id) {
		repository.deleteUser(id);
	}
	public Register[] getUsers() {
		return repository.getUsers();
	}
	

}
