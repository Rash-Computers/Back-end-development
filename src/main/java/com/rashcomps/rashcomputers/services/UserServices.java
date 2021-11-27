/**
 * @author: ntwari egide
 * @description: user service interface
 */

package com.rashcomps.rashcomputers.services;

import com.rashcomps.rashcomputers.dtos.SignupUserDto;
import com.rashcomps.rashcomputers.dtos.UpdateUser;
import com.rashcomps.rashcomputers.models.StatusEnum;
import com.rashcomps.rashcomputers.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Service
public interface UserServices {

    List<User> findAll();

    User findById(Long id);

    User signupUser(SignupUserDto signupUser) throws RoleNotFoundException;

    User updateUser(UpdateUser updateUser, Long id) throws RoleNotFoundException;

    Boolean deleteUser(Long id);

    User updateStatus(Long id, StatusEnum status);

    Boolean uploadProfile(MultipartFile uploadedFile, Long id);

}
