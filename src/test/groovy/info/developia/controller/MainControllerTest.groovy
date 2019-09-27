package info.developia.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import spock.lang.Specification;

import javax.inject.Inject;

import static info.developia.controller.MainController.GREETING;

@MicronautTest
class MainControllerTest extends Specification{

    @Inject
    @Client("/")
    public RxHttpClient client;

    private BlockingHttpClient getClient(){
        return client.toBlocking();
    }

    void "testMainController"(){
        when:
        String message = getClient().retrieve(HttpRequest.GET("/"));
        then:
        GREETING == message
    }

}
