package com.neosoft.springboot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.Exception.RecordNotFoundException;
import com.neosoft.springboot.model.User;
import com.neosoft.springboot.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> getAllUsers()
	{
		List<User> result = (List<User>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<User>();
		}
	}
	
	public User getUserById(Long id) throws RecordNotFoundException 
	{
		Optional<User> User = repository.findById(id);
		
		if(User.isPresent()) {
			return User.get();
		} else {
			throw new RecordNotFoundException("No User record exist for given id");
		}
	}
	
	public User createOrUpdateUser(User entity) 
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<User> User = repository.findById(entity.getId());
			
			if(User.isPresent()) 
			{
				User newEntity = User.get();
				
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());
				newEntity.setContact(entity.getContact());
				newEntity.setEmail(entity.getEmail());
				newEntity.setCity(entity.getCity());
				newEntity.setCountry(entity.getCountry());
				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteUserById(Long id) throws RecordNotFoundException 
	{
		Optional<User> User = repository.findById(id);
		
		if(User.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No User record exist for given id");
		}
	} 
	
	
}
