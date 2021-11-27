/**
 * @author: ntwari egide
 * @description: user repository
 */


package com.rashcomps.rashcomputers.repositories;

import com.rashcomps.rashcomputers.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}