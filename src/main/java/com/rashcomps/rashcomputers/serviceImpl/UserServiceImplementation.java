package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.CreateUser;
import com.rashcomps.rashcomputers.dtos.UpdateUser;
import com.rashcomps.rashcomputers.exceptions.UserNotFoundException;
import com.rashcomps.rashcomputers.models.User;
import com.rashcomps.rashcomputers.repositories.UserRepository;
import com.rashcomps.rashcomputers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : ntwari egide - Rash Computers
 * @description:  User service implementation
 */

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {

        Optional<User> userOptional = userRepository.findById(id);

        if(! userOptional.isPresent() )

            throw new UserNotFoundException("User with id "+id+" is not found");

        return userOptional.get();
    }

    @Override
    public User signupNewUser(CreateUser newUser) {

        User newUserToAdd = new User(newUser.getEmail(), newUser.getName(), bcryptEncoder.encode(newUser.getPassword()), newUser.getStatus());

        User createdUser = userRepository.save(newUserToAdd);

        return createdUser;

    }

    @Override
    public User updateNewUser(Long id, UpdateUser updatedUser) {

        Optional<User> userOptional = userRepository.findById(id);

        if(! userOptional.isPresent() )

            throw new UserNotFoundException("User with id "+id+" is not found");

        User updateUser = new User(updatedUser.getEmail(), updatedUser.getName(), updatedUser.getPassword(), updatedUser.getStatus());
        updateUser.setId(userOptional.get().getId());

        return userRepository.save(updateUser);

    }

    @Override
    public Boolean deleteProject(Long id) {

        Optional<User> userOptional = userRepository.findById(id);

        if(! userOptional.isPresent() )

            throw new UserNotFoundException("User with id "+id+" is not found");

        userRepository.deleteById(id);

        return true;
    }

    @Override
    public User updateStatus(Long id, String status) {

        Optional<User> userOptional = userRepository.findById(id);

        if(! userOptional.isPresent() )

            throw new UserNotFoundException("User with id "+id+" is not found");

        User updatedUser = userOptional.get();

        updatedUser.setStatus(status);

        return userRepository.save(updatedUser);
    }


    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }
}
