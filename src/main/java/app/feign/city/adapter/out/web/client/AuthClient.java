package app.feign.city.adapter.out.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cityWebserviceAuthClient", url = "${city-webservice.url}")
public interface AuthClient {

    @PostMapping("/public/auth?username={username}&password={password}")
    ResponseEntity<Void> auth(@RequestParam("username") String username, @RequestParam("password") String password);

}
