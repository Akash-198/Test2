package com.caps.association1to1;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Mobile")
@Table(name="Mobile")
public class Mobile_OnetoOneUnidirectional {

	@Id
	@Column(name="mobile_id")
	private int id;
	
	@Column(name="brand")
	private String Brand;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Battery_brand", referencedColumnName="Brand" )
	private Battery_OnetoOneUnidirectional battery;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public Battery_OnetoOneUnidirectional getBattery() {
		return battery;
	}

	public void setBattery(Battery_OnetoOneUnidirectional battery) {
		this.battery = battery;
	}

	@Override
	public String toString() {
		return "Mobile_OnetoOneUnidirectional [id=" + id + ", Brand=" + Brand + "]";
	}
	
	
}
