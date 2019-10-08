package app.feign.citywstoken.application.port.in;

import app.feign.citywstoken.application.AuthToken;

public interface GetTokenUseCase {

    public AuthToken getToken();
}
