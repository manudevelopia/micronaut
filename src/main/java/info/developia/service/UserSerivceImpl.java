package info.developia.service;

import info.developia.model.User;
import info.developia.repository.UserRepository;

import javax.inject.Singleton;

@Singleton
public class UserSerivceImpl implements UserSerivce {

    private final UserRepository userRepository;

    public UserSerivceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id).get();
    }

}
