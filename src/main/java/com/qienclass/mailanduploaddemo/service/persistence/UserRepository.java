package com.qienclass.mailanduploaddemo.service.persistence;

import org.springframework.stereotype.Component;
import org.springframework.data.repository.CrudRepository;

import com.qienclass.mailanduploaddemo.domain.User;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

}
