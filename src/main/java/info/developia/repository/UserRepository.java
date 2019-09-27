package info.developia.repository;

import info.developia.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> getUserById(Long id);
}
