package com.nurullahdemirci.StationRoute.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Route")
@Table(name="routes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="Name cannot be null!")
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@JsonIgnore
	@OneToOne(mappedBy="route")
	private Vehicle vehicle;
	
	@JsonIgnore
	@OneToMany(mappedBy="route")
	private List<RouteStation> routeStations;
	
}
