package info.developia.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller
public class MainController {

    public static final String GREETING = "This is a micronaut application!!!";

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    HttpResponse<String> main(){
        return HttpResponse.ok(GREETING);
    }

}

