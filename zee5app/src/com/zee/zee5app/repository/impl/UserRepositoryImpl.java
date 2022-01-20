package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	private UserRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	private ArrayList<Register> arraylist=new ArrayList<>();
    private Register[] registers =new Register[10];
	private static int count=-1;
	private static UserRepository repository;
	public static UserRepository getInstance() {
		if(repository==null) {
			repository= new UserRepositoryImpl();
		}
		return repository;
	}
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		boolean result=this.arraylist.add(register);
		if(result) {
			return("Success");
		}
		
		
		if (count==registers.length-1) {
			Register temp[]=new Register[registers.length*2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers=temp;
			registers[++count]=register;
			
		}
		registers[++count]=register;
		System.out.println(count);
		return("Fail");
		
		
	}

	@Override
	public Register updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		for (Register register1 : registers) {
			if(register1!=null && register1.getId().equals(id)) {
				String uid=register.getId();
				String FirstName=register.getFirstName();
				String LastName=register.getLastName();
				String email=register.getEmail();
				String password=register.getPassword();
				try {
					register1.setId(uid);
					register1.setFirstName(FirstName);
					register1.setLastName(LastName);
					register1.setEmail(email);
				} catch (InvalidIdLengthException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidNameException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidEmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				register1.setPassword(password);
				System.out.println("Change successfull");
				return register1;
				
				
			}
		}
		
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) {
		// TODO Auto-generated method stub
		Register register2=null;
		for (Register register : arraylist) {
			if(register.getId().equals(id)) {
				register2=register;
			}
		}
		return Optional.ofNullable(register2);
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return registers;
	}

	int pos=0;
	@Override	
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
for (Register register : arraylist) {
			
			if(register!=null) {
				if(register.getId().equals(id))
				break;
			}
			pos++;
		}
			for(int i=pos;i<registers.length-1;i++) {
				registers[i]=registers[i+1];
			}
			for(int i=0;i<registers.length-1;i++) {
				System.out.println(registers[i]);
			}
	}

}
