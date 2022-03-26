package com.amirkenesbay.sweater.repository;

import com.amirkenesbay.sweater.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
