package org.agilo.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Value("${openapi.server-url}")
    private String SERVER_URL;

    @Value("${openapi.version}")
    private String API_VERSION;

    private final String SERVER_DESCRIPTION = "development";
    private final String CONTACT_NAME = "Agilo Admin";
    private final String CONTACT_EMAIL = "sumit.savaliya@dal.ca";
    private final String API_TITLE = "A Modern Day Task Management App";
    private final String API_DESCRIPTION = "This API exposes endpoints to manage tasks.";

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl(SERVER_URL);
        server.setDescription(SERVER_DESCRIPTION);

        Contact myContact = new Contact();
        myContact.setName(CONTACT_NAME);
        myContact.setEmail(CONTACT_EMAIL);

        Info information = new Info()
                .title(API_TITLE)
                .version(API_VERSION)
                .description(API_DESCRIPTION);

        return new OpenAPI().info(information).servers(List.of(server));
    }
}