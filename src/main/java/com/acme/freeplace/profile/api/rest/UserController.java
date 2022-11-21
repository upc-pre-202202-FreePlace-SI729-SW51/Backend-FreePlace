package com.acme.freeplace.profile.api.rest;

import com.acme.freeplace.profile.resource.SaveUserResource;
import com.acme.freeplace.profile.resource.UserResource;
import com.acme.freeplace.profile.domain.model.entity.User;
import com.acme.freeplace.profile.domain.persistence.UserRepository;
import com.acme.freeplace.profile.domain.service.UserServiceInt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceInt userServiceInt;
    @Autowired
    private ModelMapper mapper;
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(convertToResource(user.get()), HttpStatus.OK);
    }

    @PostMapping("/user")
    public SaveUserResource createFreelancer(@Valid @RequestBody SaveUserResource resource){
        User user = convertToEntity(resource);
        return convertToResource2(userServiceInt.create(user));
    }

    private UserResource convertToResource(User entity){
       return mapper.map(entity, UserResource.class);
    }

    private SaveUserResource convertToResource2(User entity){
        return mapper.map(entity, SaveUserResource.class);
    }

    private User convertToEntity(SaveUserResource resource){
        return mapper.map(resource, User.class);
    }

}
