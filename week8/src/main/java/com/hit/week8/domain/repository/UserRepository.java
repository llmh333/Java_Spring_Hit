package com.hit.week8.domain.repository;

import com.hit.week8.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsUserByUsername(String username);
    boolean existsUserByEmail(String email);
    boolean existsById(String id);
}
