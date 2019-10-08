package app.feign.citywstoken.adapter.out.persistence;

import app.feign.citywstoken.domain.entity.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetAuthTokenRepository extends JpaRepository<AuthToken, Long> {

}
