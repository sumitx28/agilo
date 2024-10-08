package org.agilo.test.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.agilo.configuration.logger.Log;
import org.agilo.test.service.AgiloService;
import org.agilo.utils.ApiEndpoints;
import org.agilo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(ApiEndpoints.API_VERSION_ENDPOINT)
public class HelloAgilo {
    private static final Log<HelloAgilo> logger = new Log<>(HelloAgilo.class);

    private AgiloService agiloService;

    @Autowired
    public HelloAgilo(AgiloService agiloService) {
        this.agiloService = agiloService;
    }

    @Operation(summary = "Greeting Endpoint", description = "Returns a simple greeting message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = Constants.ApiStatus.SUCCESS, description = "Successful response"),
            @ApiResponse(responseCode = Constants.ApiStatus.INTERNAL_SERVER_ERROR, description = "Internal server error")
    })
    @GetMapping(HelloAgiloEndpoints.HELLO)
    public ResponseEntity<String> helloAgilo() {
        logger.logApiRequest(Constants.ApiConstants.GET, HelloAgiloEndpoints.HELLO, null);
        String greeting = agiloService.getAgiloGreeting();
        return ResponseEntity.ok(greeting);
    }
}
