package com.caps.association1to1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Battery")
@Table(name="Battery")
public class Battery_OnetoOneUnidirectional {

	@Id
	@Column
	private String Brand;
	
	@Column(name="power_mAh")
	private int power;

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Battery_OnetoOneUnidirectional [Brand=" + Brand + ", power=" + power + "]";
	}
	
	
}
