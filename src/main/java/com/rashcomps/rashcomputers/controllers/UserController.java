/**
 * @author: ntwari egide
 * @description: User end points controller
 */

package com.rashcomps.rashcomputers.controllers;

import com.rashcomps.rashcomputers.dtos.SignupUserDto;
import com.rashcomps.rashcomputers.dtos.UpdateUser;
import com.rashcomps.rashcomputers.models.User;
import com.rashcomps.rashcomputers.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.management.relation.RoleNotFoundException;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

//    @Autowired
//    private RetrieveStoredFileService storedFileService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @Value("${upload.beneficiary-profile}")
    private String userProfileDirectory;

    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        Boolean isDeleted =  userService.deleteUser(id);

        return ResponseEntity.ok().build();

    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UpdateUser updateUser) throws RoleNotFoundException {

        User saveUser = userService.updateUser(updateUser,id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/users/{id}/upload-profile-pic")
    public ResponseEntity uploadDocument(@PathVariable Long id,
            @RequestParam("file") MultipartFile uploadedFile)throws Exception {


            userService.uploadProfile(uploadedFile,id);

        return ResponseEntity.ok().build();

    }

    @PostMapping
    public ResponseEntity<?>save(@RequestBody SignupUserDto user) throws RoleNotFoundException {

        System.out.println("User: "+user.toString());

        User savedUser =userService.signupUser(user);

        URI location= ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedUser.getId())

                .toUri();


        return  ResponseEntity.created(location).build();

    }

//    @GetMapping("/api/users/file-display/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> getDisplayFile(@PathVariable String filename) {
//
//        Resource file = storedFileService.load(userProfileDirectory, filename);
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
//                .body(file);
//    }


}
