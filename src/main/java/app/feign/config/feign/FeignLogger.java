package app.feign.config.feign;

import feign.Logger;
import feign.Request;
import feign.Response;
import feign.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class FeignLogger extends Logger {

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        log.info("I=request, configKey={}, method={}, url={}", configKey, request.httpMethod(), request.url());

        if (logLevel.ordinal() > Level.HEADERS.ordinal()) {
            log.info("I=request, configKey={}, headers={}", configKey, request.headers());

            if (logLevel.ordinal() >= Level.FULL.ordinal() && hasBody(request)) {
                log.info("I=request, configKey={}, body={}", configKey, request.requestBody().asString());
            }
        }
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        log.info("I=response, configKey={}, status={}, elapsedTime={}, logLevel={}", configKey, response.status(), elapsedTime, logLevel);

        if (logLevel.ordinal() >= Level.HEADERS.ordinal()) {
            log.info("I=response, configKey={}, headers={}", configKey, response.headers());

            if (response.body() != null && hasContentInStatus(response.status())) {
                final byte[] bodyData = Util.toByteArray(response.body().asInputStream());
                logBody(configKey, logLevel, bodyData);
                return response.toBuilder().body(bodyData).build();
            }
        }

        return response;
    }

    @Override
    protected void log(String configKey, String format, Object... args) {
        log.info(String.format(methodTag(configKey) + format, args));
    }

    private boolean hasContentInStatus(final int status) {
        return status != HttpServletResponse.SC_NO_CONTENT
                && status != HttpServletResponse.SC_RESET_CONTENT;
    }

    private boolean hasBody(Request request) {
        return
            request != null
            && request.requestBody() != null
            && request.requestBody().asBytes() != null;

    }

    private void logBody(String configKey, Level logLevel, byte[] bodyData) {
        if (logLevel.ordinal() >= Level.FULL.ordinal() && bodyData.length > 0) {
            log.info("I=response, configKey={}, body={}", configKey, new String(bodyData));
        }
    }
}
