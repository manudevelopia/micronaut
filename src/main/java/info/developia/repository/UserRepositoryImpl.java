package info.developia.repository;

import info.developia.model.User;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class UserRepositoryImpl implements UserRepository {

    private final List<User> users = List.of(
            new User(1L,"Name 1", "email@mail1.com"),
            new User(2L,"Name 2", "email@mail2.com"),
            new User(3L,"Name 3", "email@mail3.com"),
            new User(4L,"Name 4", "email@mail4.com")
    );

    @Override
    public Optional<User> getUserById(Long id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

}
