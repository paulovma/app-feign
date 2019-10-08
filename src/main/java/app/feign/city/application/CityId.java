package app.feign.city.application;

import lombok.Getter;

import javax.management.InvalidAttributeValueException;

@Getter
public class CityId {

    private Long value;

    public CityId(Long value) throws InvalidAttributeValueException {
        if (value < 1) {
            throw new InvalidAttributeValueException();
        }
        this.value = value;
    }
}
