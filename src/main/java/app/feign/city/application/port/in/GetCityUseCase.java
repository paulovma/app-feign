package app.feign.city.application.port.in;

import app.feign.city.application.CityCommand;

import javax.management.InvalidAttributeValueException;

public interface GetCityUseCase {

    public CityCommand getCityById(Long id) throws InvalidAttributeValueException;
}
