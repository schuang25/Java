package com.stephen.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.stephen.authentication.models.LoginUser;
import com.stephen.authentication.models.User;
import com.stephen.authentication.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
        
        if (potentialUser.isPresent())
        	result.rejectValue("email", "unique", "This email is already in use");
        
        if (!newUser.getPassword().equals(newUser.getConfirm()))
        	result.rejectValue("confirm", "matches", "The provided passwords do not match");
        
        if(result.hasErrors())
        	return null;
        
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
        Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
        
        if (!potentialUser.isPresent()) {
        	result.rejectValue("email", "invalid", "Invalid credentials");
        	return null;
        }
        
        User user = potentialUser.get();
        if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword()))
        	result.rejectValue("password", "invalid", "Invalid credentials");
        
        if (result.hasErrors())
        	return null;
        return user;
        
    }
    
    public User findUser(Long id) {
    	Optional<User> potentialUser = userRepo.findById(id);
    	if (potentialUser.isPresent())
    		return potentialUser.get();
    	else
    		return null;
    }
}
