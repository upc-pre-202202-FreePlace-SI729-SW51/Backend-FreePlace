package com.acme.freeplace.profile.domain.persistence;


import com.acme.freeplace.profile.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
    User findByEmail(String email);
    Optional<User> findById(Long id);
    User findByUsername(String username);
}
