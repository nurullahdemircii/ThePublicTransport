package com.nurullahdemirci.StationRoute.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.StationRoute.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
