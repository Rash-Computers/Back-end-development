package com.rashcomps.rashcomputers.serviceImpl;

import com.rashcomps.rashcomputers.dtos.IdTemplate;
import com.rashcomps.rashcomputers.dtos.SignupUserDto;
import com.rashcomps.rashcomputers.dtos.UpdateUser;
import com.rashcomps.rashcomputers.exceptions.UserNotFoundModifiedException;
import com.rashcomps.rashcomputers.models.Role;
import com.rashcomps.rashcomputers.models.StatusEnum;
import com.rashcomps.rashcomputers.models.User;
import com.rashcomps.rashcomputers.repositories.RoleRepository;
import com.rashcomps.rashcomputers.repositories.UserRepository;
import com.rashcomps.rashcomputers.services.FileService;
import com.rashcomps.rashcomputers.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.RoleNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FileService fileStorageService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Value("${upload.beneficiary-profile}")
    private String userProfileDirectory;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User checkExistence(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())

            throw new UserNotFoundModifiedException("User with id :"+id+" is not found");

        return userOptional.get();
    }

    @Override
    public User findById(Long id) {
        return checkExistence(id);
    }

    @Override
    public User signupUser( SignupUserDto newUser) throws RoleNotFoundException {

        if(userRepository.existsByEmail(newUser.getEmail()) || userRepository.existsByUsername(newUser.getUsername())){
            throw new UserNotFoundModifiedException("user with username or email exists");
        }

        List<Role> roles = new ArrayList<>();

        for (IdTemplate idTemplate : newUser.getRolesIds()) {

            Optional<Role> roleOptional = roleRepository.findById(idTemplate.getIdValue());

            if(! roleOptional.isPresent()) throw new RoleNotFoundException("ROle with id: "+idTemplate.getIdValue()+" is not found");

            roles.add(roleOptional.get());

        }

        User saveUser = new User(
                newUser.getUsername(),
                newUser.getEmail(),
                bcryptEncoder.encode(newUser.getPassword()),
                newUser.getStatus(),
                roles
        );

        User savedUser = userRepository.save(saveUser);

        return savedUser;
    }

    @Override
    public User updateUser(UpdateUser updateUser, Long id) throws RoleNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())

            throw new UserNotFoundModifiedException("User with id :"+id+" is not found");


        List<Role> roles = new ArrayList<>();

        for (IdTemplate idTemplate : updateUser.getRoles()) {

            Optional<Role> roleOptional = roleRepository.findById(idTemplate.getIdValue());

            if(! roleOptional.isPresent()) throw new RoleNotFoundException("ROle with id: "+idTemplate.getIdValue()+" is not found");

            roles.add(roleOptional.get());

        }

        User saveUser = new User(
                updateUser.getFirstName(),
                updateUser.getSecondName(),
                updateUser.getUsername(),
                updateUser.getEmail(),
                updateUser.getFirstTelPhoneNumber(),
                updateUser.getSecondTelPhoneNumber(),
                updateUser.getProfilePicturePath(),
                updateUser.getGender(),
                bcryptEncoder.encode(updateUser.getPassword()),
                updateUser.getStatus(),
                roles
        );

        saveUser.setId(id);

        User savedUpdatedUser = userRepository.save(saveUser);

        return savedUpdatedUser;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())

            throw new UserNotFoundModifiedException("User with id :"+id+" is not found");

        userRepository.deleteById(id);

        return true;
    }

    @Override
    public User updateStatus(Long id, StatusEnum status) {

        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())

            throw new UserNotFoundModifiedException("User with id :"+id+" is not found");

        User saveUser = userOptional.get();

        saveUser.setId(id);

        saveUser.setStatus(status);

        User savedUpdatedUser = userRepository.save(saveUser);

        return savedUpdatedUser;
    }

    @Override
    public Boolean uploadProfile(MultipartFile uploadedFile,Long id)  {

//        Optional<User> userOptional = userRepository.findById(id);
//
//        if (!userOptional.isPresent())
//
//            throw new UserNotFoundModifiedException("User with id :"+id+" is not found");
//
//        UploadDocResponse fileUploadedDetails = null;
//
//        if (uploadedFile != null) {
//            fileUploadedDetails = fileStorageService.uploadUserProfile(uploadedFile, userProfileDirectory);
//
//        }
//
//
//        User saveUser = new User(
//                userOptional.get().getUsername(),
//                userOptional.get().getEmail(),
//                userOptional.get().getPassword(),
//                fileUploadedDetails.getFileGeneratedFileName(),
//                userOptional.get().getProject(),
//                userOptional.get().getPhoneNumber(),
//                userOptional.get().getStatus(),
//                userOptional.get().getRoles()
//        );
//
//        saveUser.setId(id);
//
//        userRepository.save(saveUser);
//
//        return true;

        return null;
    }
}
