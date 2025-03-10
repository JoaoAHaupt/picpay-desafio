package com.joaoahaupt.picpay.service;

import com.joaoahaupt.picpay.model.User;
import com.joaoahaupt.picpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> returnAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id) throws Exception {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found: " + id)));

        return userOptional.orElse(null);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

}
