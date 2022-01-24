package com.nurullahdemirci.StationRoute.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	@NotNull(message="Sequence number cannot be null!")
	@Column(name="sequence_number")
	private Integer sequenceNumber;
	
	@NotNull(message="Route cannot be null!")
	@ManyToOne()
	@JoinColumn(name="routes_id")
	private Route route;
	
	@NotNull(message="Station cannot be null!")
	@ManyToOne()
	@JoinColumn(name="stations_id")
	private Station station;

}
