package com.project.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Account;
import com.project.entity.User;
import com.project.exception.UserNotFoundException;
import com.project.repository.UserRepository;
import com.project.service.AccountService;
import com.project.service.UserService;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private AccountService accountService; 

	
    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@Override
	public void deleteUserById(Integer id) {
		if(!userRepository.existsById(id)) {
			throw new UserNotFoundException("User Id "+id+"  doesn't exist!");
		}
		 userRepository.deleteById(id);
	}
	
	@Override
	public User UpdateUserById(Integer id, User user) {
		 User eUser = userRepository.findById(id)
				 .orElseThrow(()-> new UserNotFoundException("User Id "+id+"  doesn't exist!"));
		        eUser.setFirstName(user.getFirstName());
		        eUser.setLastName(user.getLastName());
		        eUser.setGender(user.getGender());
		        eUser.setDob(user.getDob());
		        eUser.setUsername(user.getUsername());
		        eUser.setPass(user.getPass());
		        return userRepository.save(eUser);
	}
	

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.findById(id)
				.orElseThrow(()-> new UserNotFoundException("User Id "+id+" doesn't exist!"));
	}

	@Override
    public User loginUser(User user) {
        User loggedInUser = userRepository.findByUsernameAndPass(user.getUsername(), user.getPass());
        if (loggedInUser == null) {
            throw new UserNotFoundException("Invalid username or password");
        }
        return loggedInUser;
    }


	@Override
	public User registerUser(User user) {
		if(user.getPass().equals(user.getCpass()))
		{
			
		User savedUser = userRepository.save(user);
		Account account = new Account();
		account.setStatus(false);
	    account.setUser(savedUser);
	    accountService.createAccount(account);
	    return savedUser;
		} else {
			return null;
		}
	}


}
