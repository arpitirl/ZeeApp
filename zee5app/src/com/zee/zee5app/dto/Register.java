package com.zee.zee5app.dto;
import java.util.Objects;
import java.util.regex.Pattern;

import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class Register {
	
	@Setter(value=AccessLevel.NONE)
	private String firstName;
	@Setter(value=AccessLevel.NONE)
	private String lastName;
	@Setter(value=AccessLevel.NONE)
	private String email;
	private String password;
	@Setter(value=AccessLevel.NONE)
	private String id;
	
	//EDC
	public Register() {
		
		
	}
	

	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6) {
			throw new InvalidIdLengthException("Id Length is less than 6");
		}
		this.id = id;
	}


	public void setFirstName(String firstName) throws InvalidNameException {
		if(firstName==null || firstName.length()<2) {
			throw new InvalidNameException("Invalid First Name");
		}
		this.firstName = firstName;
	}


	public void setLastName(String lastName) throws InvalidNameException {
		if(lastName==null || lastName.length()<2) {
			throw new InvalidNameException("Invalid Last Name");
		}
		this.lastName = lastName;
	}


	public void setEmail(String email) throws InvalidEmailException {
		
	    if(email.length()>2) {
	    	this.email=email;
	    }
	    else {
	    	throw new InvalidEmailException("Invalid Email");
	    }
	}
	@Override
	public int hashCode() {
		return Objects.hash(email,firstName,lastName,password,id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(getClass()!=obj.getClass()) {
			return false;
		}
		Register Other=(Register) obj;
		return Objects.equals(email,Other.email)&& Objects.equals(firstName,Other.firstName)&& Objects.equals(lastName,Other.lastName)&& Objects.equals(id,Other.id)&& Objects.equals(password,Other.password);
		
	}
	
	

}
