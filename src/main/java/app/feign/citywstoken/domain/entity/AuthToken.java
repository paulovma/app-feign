package app.feign.citywstoken.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AuthToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime expirationDate;


}
