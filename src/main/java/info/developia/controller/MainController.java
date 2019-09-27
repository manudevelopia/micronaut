package info.developia.controller;

import info.developia.model.User;
import info.developia.service.UserSerivce;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller
public class MainController {

    private final UserSerivce userSerivce;

    public MainController(UserSerivce userSerivce) {
        this.userSerivce = userSerivce;
    }

    @Get("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    HttpResponse<User> main(Long id){
        User user = userSerivce.getUserById(id);

        return HttpResponse.ok(user);
    }

}

