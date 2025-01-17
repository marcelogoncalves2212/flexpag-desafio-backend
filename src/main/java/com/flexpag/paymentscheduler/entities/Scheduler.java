package com.flexpag.paymentscheduler.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flexpag.paymentscheduler.entities.enums.StatusPayment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Scheduler implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone="GMT-3")
	private LocalDateTime date;
	private BigDecimal price;
	private String description;
	@Enumerated(EnumType.STRING)
	private StatusPayment status;
	
	public Scheduler(Scheduler scheduler) {
		this.id = scheduler.getId();
		this.date = scheduler.getDate();
		this.price = scheduler.getPrice();
		this.description = scheduler.getDescription();
		this.status = scheduler.getStatus();
	}
}
