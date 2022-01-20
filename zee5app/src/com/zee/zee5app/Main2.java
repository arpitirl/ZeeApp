package com.zee.zee5app;

import com.zee.zee5app.dto.Register;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Register register=new Register("ab000001","Arpit","Kumar","arpit@gmail.com","pass");
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.hashCode());
			Register register2=new Register("ab000001","Arpit","Kumar","arpit@gmail.com","pass");
			System.out.println(register2);
			System.out.println(register2.toString());
			System.out.println(register2.hashCode());
			System.out.println("Equals call"+register.equals(register2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
