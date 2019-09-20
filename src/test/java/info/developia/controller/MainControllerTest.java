package info.developia.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static info.developia.controller.MainController.GREETING;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class MainControllerTest {

    @Inject
    @Client("/")
    public RxHttpClient client;

    private BlockingHttpClient getClient(){
        return client.toBlocking();
    }

    @Test
    public void testMainController(){
        String message = getClient().retrieve(HttpRequest.GET("/"));

        assertEquals(GREETING, message);
    }



}
