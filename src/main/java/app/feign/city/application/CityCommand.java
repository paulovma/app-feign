package app.feign.city.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityCommand {

    private Long ibgeId;

    private String name;

    private String state;
}
