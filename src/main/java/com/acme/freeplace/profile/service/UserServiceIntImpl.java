package com.acme.freeplace.profile.service;

import com.acme.freeplace.profile.domain.model.entity.User;
import com.acme.freeplace.profile.domain.persistence.UserRepository;
import com.acme.freeplace.profile.domain.service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIntImpl implements UserServiceInt {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User create(User user) {
        if(userRepository.findByUsername(user.getUsername())!=null)
            return userRepository.findByUsername(user.getUsername());
//        District district = districtRepository.findById(districtId).orElseThrow(() -> new ResourceNotFoundException("District", "Id", districtId));
        user.setPassword(encoder.encode(user.getPassword()));
//        freelancer.setDistrict(district);
        User saved = userRepository.save(user);
        return saved;
    }
}
