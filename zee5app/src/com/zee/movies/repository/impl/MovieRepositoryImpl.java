package com.zee.movies.repository.impl;

import com.zee.movies.dto.*;
import com.zee.movies.repository.*;
import com.zee.movies.repository.impl.*;
import com.zee.movies.service.*;
import com.zee.movies.service.impl.*;
import com.zee.movies.dto.Register;


public class MovieRepositoryImpl implements MovieRepository {
	private MovieRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	private Register[] registers=new Register[10];
	private static int count=-1;
	private static MovieRepository repository;
	public static MovieRepository getInstance() {
		if(repository==null) {
			repository=new MovieRepositoryImpl();
		}
		return repository;
	}
	

	@Override
	public String addMovie(Register register) {
		// TODO Auto-generated method stub
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

	@Override
	public Register updateMovie(String id, Register register) {
		// TODO Auto-generated method stub
		for (Register register1 : registers) {
			if(register1!=null && register1.getId().equals(id)) {
				String uid=register.getId();
				String Name=register.getName();
				String ReleaseDate=register.getReleaseDate();
				String Country=register.getCountry();
				String Cast[]=register.getCast();
				register1.setId(uid);
				register1.setName(Name);
				register1.setReleaseDate(ReleaseDate);
				register1.setCountry(Country);
				register1.setCast(Cast);
				System.out.println("Change successfull");
				return register1;
				
				
			}
		}
		return null;
	}

	@Override
	public Register getMovieById(String id) {
		// TODO Auto-generated method stub
		for (Register register : registers) {
			if(register!=null && register.getId().equals(id)) {
				return(register);
			}
		}		
		return null;
	}

	@Override
	public Register[] getAllMovies() {
		// TODO Auto-generated method stub
		return registers;
	}
	int pos=0;

	@Override
	public void deleteMovieById(String id) {
		// TODO Auto-generated method stub
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

	}


