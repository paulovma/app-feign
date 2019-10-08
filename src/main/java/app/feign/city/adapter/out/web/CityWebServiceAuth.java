package app.feign.city.adapter.out.web;

import app.feign.city.adapter.out.web.client.AuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CityWebServiceAuth {

    @Autowired
    private AuthClient authClient;

    private String token;

    @Value("${city-webservice.username}")
    private String username;

    @Value("${city-webservice.password}")
    private String password;

    public String auth() {
        ResponseEntity<Void> response = authClient.auth(username, password);
        return response.getHeaders().getFirst("Authorization");
    }
}
