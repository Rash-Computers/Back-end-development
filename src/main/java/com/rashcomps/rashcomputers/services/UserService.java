package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> findAll();

    public User findById(Long id);

    public  User signupNewUser();

    public User updateNewUser();

    public Boolean deleteProject(Long id);

    public User updateStatus(Long id, String status);
}
