package com.zee.zee5app;
import com.zee.zee5app.dto.*;
import com.zee.zee5app.service.*;
import com.zee.zee5app.service.impl.UserServiceImpl;
import com.zee.zee5app.repository.*;
public class Main {

	public static void main(String[] args) {
		// Register
		Register register=new Register();
		register.setFirstName("Arpit");
		register.setLastName("Shreshth");
		register.setEmail("arpit@gmail.com");
		register.setPassword("Pass");
		System.out.println(register);
		System.out.println(register.toString());
		System.out.println(register.getEmail());
		//Login
		
		UserService service = UserServiceImpl.getInstance();
		for(int i=0;i<=11;i++) {
			Register register2=new Register();
			register2.setId("ab00"+i);
			register2.setFirstName("arpit"+i);
			register2.setLastName("kumar"+i);
			register2.setPassword("AS");	
			
		String result=service.addUser(register2);
		System.out.println(result);
		}
		
		Register register2=service.getUserById("ab000");
		System.out.println(register2!=null);
		
		for(Register register3:service.getAllUsers()) {
			System.out.println(register3);
		}
		String id="ab000";
		Register register4=new Register();
		register4.setFirstName("Arpan");
		register4.setLastName("Ishan");
		register4.setEmail("arpit@gmail.com");
		register4.setPassword("Word");
		register4.setId("v");
		Register register5=service.updateUser(id,register4);
		System.out.println(register5);
		service.deleteUserById("ab006");
		UserRepository repository= null;
		

	}

}
