package app.feign.city.adapter.in.web;

import app.feign.city.application.port.in.GetCityUseCase;
import app.feign.city.application.CityCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InvalidAttributeValueException;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/city")
public class GetCityAPI {

    @Autowired
    private GetCityUseCase getCityUseCase;

    @GetMapping("/{id}")
    public ResponseEntity getCityById(@PathVariable("id") @Valid Long id) {
        try {
            log.info("M=GetCityAPI:getCityById, value={}", id);
            return new ResponseEntity<CityCommand>(getCityUseCase.getCityById(id), HttpStatus.OK);
        } catch (InvalidAttributeValueException e) {
            log.info("M=GetCityAPI:getCityById, exception={}", e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
