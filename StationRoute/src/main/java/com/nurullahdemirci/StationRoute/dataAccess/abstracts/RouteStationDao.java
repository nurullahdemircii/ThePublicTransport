package com.nurullahdemirci.StationRoute.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.StationRoute.entities.concretes.RouteStation;

public interface RouteStationDao extends JpaRepository<RouteStation, Integer> {

}
