package app.feign.city.application;

import app.feign.city.adapter.out.web.client.GetCityClient;
import app.feign.city.application.port.in.GetCityUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.session.InMemoryWebSessionStore;

import javax.management.InvalidAttributeValueException;

@Slf4j
@Service
public class GetCityService implements GetCityUseCase {

    @Autowired
    private GetCityClient getCityClient;

    @Override
    public CityCommand getCityById(Long id) throws InvalidAttributeValueException {
        log.info("M=GetCityService:getCityById, value={}", id);
        return getCityClient.getCityById(id);
    }
}
