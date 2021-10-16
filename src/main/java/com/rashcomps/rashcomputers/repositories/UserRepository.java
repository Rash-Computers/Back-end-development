package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author : ntwari egide - Rash Computers
 * @description:  Create User repository
 */



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
