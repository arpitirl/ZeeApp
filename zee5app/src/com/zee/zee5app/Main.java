package com.zee.zee5app;
import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.*;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.service.*;
import com.zee.zee5app.service.impl.UserServiceImpl;
import com.zee.zee5app.repository.*;
public class Main {

	public static void main(String[] args) {
		
		Register register=new Register();
		try {
			register.setFirstName("Arpit");
			register.setLastName("Shreshth");
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			register.setEmail("ar@gmail.com");
		} catch (InvalidEmailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		register.setPassword("Pass");
		try {
			register.setId("ab00001");
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(register);
		System.out.println(register.toString());
		System.out.println(register.getEmail());
		
		
		UserService service = UserServiceImpl.getInstance();
		for(int i=0;i<=11;i++) {
			Register register2=new Register();
			try {
				register2.setId("ab0000"+i);
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				register2.setFirstName("arpit"+i);
				register2.setLastName("kumar"+i);
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			register2.setPassword("AS");
			try {
				register2.setEmail("tripa@gmail.com");
			} catch (InvalidEmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		String result=service.addUser(register2);
		System.out.println(result);
		}
		
		Optional<Register> optional=service.getUserById("ab00001");
		if(optional.isPresent()) {
			System.out.println("GetUser By Id"+ optional.get());
		}
		else {
			System.out.println("Id not found");
		}
		
		
		for(Register register3:service.getAllUsers()) {
			System.out.println(register3);
		}
		String id="ab000011";
		Register register4=new Register();
		try {
			register4.setFirstName("Arpan");
			register4.setLastName("Ishan");
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			register4.setEmail("arpit@gmail.com");
		} catch (InvalidEmailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		register4.setPassword("Word");
		try {
			register4.setId("ab000020");
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Register register5=service.updateUser(id,register4);
		System.out.println(register5);
		service.deleteUserById("ab00001");
		UserRepository repository= null;
		

	}

}
