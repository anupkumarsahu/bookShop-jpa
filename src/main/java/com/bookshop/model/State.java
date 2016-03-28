package com.bookshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="State")
public class State implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="StateNo")
	private Long stateNo;
	@Column(name="State")
	@NotEmpty(message="State name is mandatory")
	private String state;
	public Long getStateNo() {
		return stateNo;
	}
	public void setStateNo(Long stateNo) {
		this.stateNo = stateNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
