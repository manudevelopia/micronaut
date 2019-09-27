package info.developia.controller

import groovy.json.JsonSlurper;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import spock.lang.Specification;

import javax.inject.Inject;


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
        String response = getClient().retrieve(HttpRequest.GET("/2"));
        then:
        "{\"id\":2,\"name\":\"Name 2\",\"email\":\"email@mail2.com\"}" == response
    }

}
