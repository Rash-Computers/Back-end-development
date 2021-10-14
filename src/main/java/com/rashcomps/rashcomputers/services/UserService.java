package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.dtos.CreateUser;
import com.rashcomps.rashcomputers.dtos.UpdateUser;
import com.rashcomps.rashcomputers.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> findAll();

    public User findById(Long id);

    public  User signupNewUser(CreateUser newUser);

    public User updateNewUser(Long id, UpdateUser updatedUser);

    public Boolean deleteProject(Long id);

    public User updateStatus(Long id, String status);
}
