package info.developia.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller
public class MainController {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    HttpResponse<String> main(){
        return HttpResponse.ok("This is a micronaut application!!!");
    }

}
