package org.agilo.auth.repository;

import org.agilo.auth.model.Role;
import org.agilo.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User , UUID> {
    Optional<Role> findByName(String name);
}
