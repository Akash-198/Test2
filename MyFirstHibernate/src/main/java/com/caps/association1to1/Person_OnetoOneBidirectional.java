package com.caps.association1to1;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Person")
@Table(name="person")
public class Person_OnetoOneBidirectional {
	
	@Id
	@Column(name="person_id")
	private int id;
	
	@Column(name="person_name")
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)	
	@JoinColumn(name="Aadhar_id")
	private Aadhar_OnetoOneBidirectional Aadhar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Aadhar_OnetoOneBidirectional getAadhar() {
		return Aadhar;
	}

	public void setAadhar(Aadhar_OnetoOneBidirectional aadhar) {
		Aadhar = aadhar;
	}

	@Override
	public String toString() {
		return "Person_OnetoOneBidirectional [id=" + id + ", name=" + name + "]";
	}
	

}
