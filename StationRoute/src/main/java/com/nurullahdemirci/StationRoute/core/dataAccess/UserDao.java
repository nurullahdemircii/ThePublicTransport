package com.nurullahdemirci.StationRoute.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.StationRoute.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
