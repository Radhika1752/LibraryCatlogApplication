package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.User;
import com.rest.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	
private UserRepo uRepo;
	
	public User newUser (User u)
	{
		return uRepo.save(u);
	}
	
	public List<User> getAllUser()
	{
		return uRepo.findAll();
	}
	
	public Optional<User> getSingleUser(Long id)
	{
		return uRepo.findById(id);
	}
	
	public void dltUser(Long id)
	{
		uRepo.deleteById(id);
	}
	
	public User getSingleUser1(Long id)
	{
		return uRepo.findById(id).orElse(null);
	}
	
	public User UpdateSingleUser1(Long id, User z)
	{
		Optional<User> s=uRepo.findById(id);
		if(s.isPresent())
		{
			User u1=s.get();
			u1.setUsername(z.getUsername());
			u1.setPassword(z.getPassword());
			u1.setFullName(z.getFullName());
			u1.setEmail(z.getEmail());
		//	b1.setAvailable(z.isAvailable());
			return uRepo.save(u1);
		}
		return null;
	}
	

}
