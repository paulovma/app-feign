package app.feign.citywstoken.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthToken {

    private Long id;

    private String token;

    private LocalDateTime expirationDate;
}
