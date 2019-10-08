package app.feign.citywstoken.application;

import app.feign.citywstoken.adapter.out.persistence.GetAuthTokenRepository;
import app.feign.citywstoken.application.port.in.GetTokenUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetTokenService implements GetTokenUseCase {

    @Autowired
    private GetAuthTokenRepository getAuthTokenRepository;

    @Override
    public AuthToken getToken() {
        return null;
    }
}
