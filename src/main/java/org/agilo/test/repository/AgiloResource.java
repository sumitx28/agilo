package org.agilo.test.repository;

import org.agilo.exception.Exception;
import org.agilo.test.entity.Agilo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AgiloResource {
    private AgiloRepository agiloRepository;

    @Autowired
    public AgiloResource(AgiloRepository agiloRepository) {
        this.agiloRepository = agiloRepository;
    }

    public Agilo getResourceById(UUID id) {
        Optional<Agilo> entityFromDB = Optional.ofNullable(agiloRepository.findById(id).orElseThrow(() -> new Exception("Not Found", "Entity Not Found")));
        return entityFromDB.get();
    }

}
