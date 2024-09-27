package org.agilo.test.service;

import org.agilo.exception.Exception;
import org.agilo.test.entity.Agilo;
import org.agilo.test.repository.AgiloResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AgiloService {

    private static final String DUMMY_RESOURCE_ID = "efbbbf00-0000-0000-0000-0000000000";
    private AgiloResource agiloResource;

    @Autowired
    public AgiloService(AgiloResource agiloResource) {
        this.agiloResource = agiloResource;
    }

    public String getAgiloGreeting() {
        Agilo entityFromDB = agiloResource.getResourceById(UUID.randomUUID());
        return entityFromDB.getData();
    }
}
