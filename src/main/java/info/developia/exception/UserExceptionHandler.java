package info.developia.exception;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Produces(MediaType.APPLICATION_JSON)
@Singleton
@Requires(classes = {UserException.class, ExceptionHandler.class})
public class UserExceptionHandler implements ExceptionHandler<UserException, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, UserException exception) {
        ExceptionMessage message = new ExceptionMessage(exception.getMessage());

        return HttpResponse.ok(message);
    }
}
