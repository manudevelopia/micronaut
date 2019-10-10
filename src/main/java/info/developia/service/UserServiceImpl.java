package info.developia.service;

import info.developia.exception.UserException;
import info.developia.model.User;
import info.developia.repository.UserRepository;

import javax.inject.Singleton;

@Singleton
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository
                .getUserById(id)
                .orElseThrow(() -> new UserException("No user has been found"));
    }

}
