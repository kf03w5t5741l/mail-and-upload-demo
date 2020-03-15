package com.qienclass.mailanduploaddemo.service.persistence;

import com.qienclass.mailanduploaddemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    public void deleteAll() {
        this.userRepository.deleteAll();
    }
}
