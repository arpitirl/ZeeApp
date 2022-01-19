package com.zee.movies.service.impl;

import com.zee.movies.dto.Register;
import com.zee.movies.repository.MovieRepository;
import com.zee.movies.repository.impl.MovieRepositoryImpl;
import com.zee.movies.service.MovieService;
import com.zee.movies.repository.*;
import com.zee.movies.repository.impl.*;
import com.zee.movies.service.impl.*;

public class MovieServiceImpl implements MovieService {
	private static MovieService service;
	public static MovieService getInstance() {
		// TODO Auto-generated constructor stub
		if(service==null) {
			service=new MovieServiceImpl();
		}
		return service;
	}
	MovieRepository repository=MovieRepositoryImpl.getInstance();
	@Override
	public String addMovie(Register register) {
		return this.repository.addMovie(register);
	}


	@Override
	public Register updateMovie(String id, Register register) {
		return repository.updateMovie(id, register);
	}


	@Override
	public Register getMovieById(String id) {
		return repository.getMovieById(id);
	}


	@Override
	public Register[] getAllMovies() {
		// TODO Auto-generated method stub
		return repository.getAllMovies();
	}

	@Override
	public void deleteMovieById(String id) {
		repository.deleteMovieById(id);
	}


}
