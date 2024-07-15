package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService){
        this.userDaoService = userDaoService;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{user_id}")
    public User getUser(@PathVariable int user_id){
        User oneUser = userDaoService.findOne(user_id);
        if(oneUser==null) {
            throw new UserNotFoundException("user_id: "+user_id);
        }
        return oneUser;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser (@Valid@RequestBody User user){ //@Valid does not itself validate User, we need to add validation in specific variable in User class
        User savedUser=userDaoService.createUser(user);
        // /users/{id} => /users, user.getId
        //location will be returned in header
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{user_id}")
    public void  deleteUserById(@PathVariable int user_id){
        if(userDaoService.deleteUserById(user_id)){
            userDaoService.deleteUserById(user_id);
        }else{
            throw new UserNotFoundException("Delete failed!! User with user_id: "+user_id+" does not exist.");
        }
    }
}
