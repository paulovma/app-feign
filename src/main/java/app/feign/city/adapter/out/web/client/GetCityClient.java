package app.feign.city.adapter.out.web.client;

import app.feign.city.adapter.out.web.interceptor.AuthorizationInterceptor;
import app.feign.city.application.CityCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cityWebserviceGetCityClient", url = "${city-webservice.url}", configuration = AuthorizationInterceptor.class)
public interface GetCityClient {

    @GetMapping(value = "city/{cityId}")
    CityCommand getCityById(@PathVariable("cityId") Long cityId);


}
