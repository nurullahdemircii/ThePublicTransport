package com.nurullahdemirci.StationRoute.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nurullahdemirci.StationRoute.entities.concretes.Station;

public interface StationDao extends JpaRepository<Station, Integer> {

}
