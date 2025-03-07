package com.joaoahaupt.picpay.repository;

import com.joaoahaupt.picpay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
