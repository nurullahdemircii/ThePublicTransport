package com.nurullahdemirci.StationRoute.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="RouteStation")
@Table(name="routes_stations")
public class RouteStation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="routes_id")
	private Route route;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="stations_id")
	private Station station;

}
