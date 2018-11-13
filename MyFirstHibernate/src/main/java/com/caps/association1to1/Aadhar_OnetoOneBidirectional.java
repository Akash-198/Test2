package com.caps.association1to1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Aadhar_info")
@Table(name="Aadhar_info")
public class Aadhar_OnetoOneBidirectional {

	@Id
	@Column(name="Aadhar_no")
	private int number;
	
	@OneToOne(mappedBy="Aadhar")
	@JoinColumn(name="person",referencedColumnName="person_name")
	private Person_OnetoOneBidirectional person;

	@Override
	public String toString() {
		return "Aadhar_OnetoOneBidirectional [number=" + number + ", person=" + person + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Person_OnetoOneBidirectional getPerson() {
		return person;
	}

	public void setPerson(Person_OnetoOneBidirectional person) {
		this.person = person;
	}
}
