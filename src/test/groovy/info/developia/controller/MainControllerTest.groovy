package info.developia.controller

import groovy.json.JsonSlurper
import info.developia.exception.ExceptionMessage
import info.developia.model.User
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MainControllerTest extends Specification{

    @Shared
    @Inject
    @Client("/")
    RxHttpClient client;

    JsonSlurper slurper = new JsonSlurper()

    def setupSpec(){
    }

    def "Should return user 1"() {
        when:
        String response = client.toBlocking().retrieve(HttpRequest.GET("/1"));
        then:
        User user = slurper.parseText(response)
        with(user){
            id == 1
            name == "Name 1"
            email == "email@mail1.com"
        }
    }

    def "Should not return any user"(){
        when:
        String response = client.toBlocking().retrieve(HttpRequest.GET("/-1"))
        then:
        ExceptionMessage exceptionMessage = slurper.parseText(response)
        with(exceptionMessage){
            message == "No user has been found"
        }
    }

}
