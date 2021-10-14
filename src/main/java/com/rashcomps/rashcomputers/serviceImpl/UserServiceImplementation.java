package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.CreateUser;
import com.rashcomps.rashcomputers.dtos.UpdateUser;
import com.rashcomps.rashcomputers.models.User;
import com.rashcomps.rashcomputers.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User signupNewUser(CreateUser newUser) {
        return null;
    }

    @Override
    public User updateNewUser(Long id, UpdateUser updatedUser) {
        return null;
    }

    @Override
    public Boolean deleteProject(Long id) {
        return null;
    }

    @Override
    public User updateStatus(Long id, String status) {
        return null;
    }
}
