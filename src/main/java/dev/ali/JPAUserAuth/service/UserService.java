package dev.ali.JPAUserAuth.service;

import dev.ali.JPAUserAuth.entity.User;
import dev.ali.JPAUserAuth.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public void save(User user){
        userRepository.save(user);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public Iterable findAll() {
        return userRepository.findAll();
    }
}
