package app.feign.city.adapter.out.web.interceptor;

import app.feign.city.adapter.out.web.CityWebServiceAuth;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class AuthorizationInterceptor {

    @Autowired
    private CityWebServiceAuth cityWebServiceAuth;

    @Bean
    RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                final String auth = cityWebServiceAuth.auth();
                template.header("Authorization", auth);
            }
        };
    }
}
