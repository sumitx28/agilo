package org.agilo.test.repository;

import org.agilo.test.entity.Agilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgiloRepository extends JpaRepository<Agilo, UUID> {

}
