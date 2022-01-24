package com.nurullahdemirci.StationRoute.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Vehicle")
@Table(name="vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotNull(message="Plate cannot be null!")
	@Column(name="plate")
	private String plate;
	
	@NotNull(message="Name cannat be null!")
	@Column(name="name")
	private String name;
	
	@OneToOne
	@JoinColumn(name="route_id")
	private Route route; 

}
