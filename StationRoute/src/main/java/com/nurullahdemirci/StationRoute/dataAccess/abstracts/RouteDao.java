package com.nurullahdemirci.StationRoute.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.StationRoute.entities.concretes.Route;

public interface RouteDao extends JpaRepository<Route, Integer> {

}
