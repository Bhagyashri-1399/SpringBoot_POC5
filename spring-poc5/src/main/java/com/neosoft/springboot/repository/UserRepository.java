package com.neosoft.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.springboot.model.User;




@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	
 
}
