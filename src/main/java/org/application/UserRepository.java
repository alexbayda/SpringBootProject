package org.application;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByPartialNameContaining(String partialName);

    List<User> findAll();
}
