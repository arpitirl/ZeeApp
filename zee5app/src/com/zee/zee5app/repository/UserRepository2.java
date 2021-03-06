package com.zee.zee5app.repository;
import com.zee.zee5app.dto.Register;



public class UserRepository2 {
	private Register[] registers =new Register[10];
	private static int count=-1;
	private UserRepository2() {
		
	}
	//to return all the user details
	public Register[] getUsers() {
		return registers;
	}
	public Register updateUser(String id, Register register) {
		for (Register register1 : registers) {
			if(register1!=null && register1.getId().equals(id)) {
				String uid=register.getId();
				String FirstName=register.getFirstName();
				String LastName=register.getLastName();
				String email=register.getEmail();
				String password=register.getPassword();
				register1.setId(uid);
				register1.setFirstName(FirstName);
				register1.setLastName(LastName);
				register1.setEmail(email);
				register1.setPassword(password);
				System.out.println("Change successfull");
				return register1;
				
				
			}
		}
		
		return null;
	}
	int pos=0;
	public void deleteUser(String id) {
		for (Register register : registers) {
			
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
	public Register getUserById(String id) {
		for (Register register : registers) {
			if(register!=null && register.getId().equals(id)) {
				return(register);
			}
		}
		return(null);
	}
	public String addUser(Register register) {
		
		if (count==registers.length-1) {
			Register temp[]=new Register[registers.length*2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers=temp;
			registers[++count]=register;
			return("Successfully handled");
		}
		registers[++count]=register;
		System.out.println(count);
		return("Success");
	}
	private static UserRepository2 userRepository;
	public static UserRepository2 getInstance() {
		if(userRepository==null)
			userRepository=new UserRepository2();
		return userRepository;
	}

}
