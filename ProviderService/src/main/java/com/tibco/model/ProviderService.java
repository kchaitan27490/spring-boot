package com.tibco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="providerservice")
public class ProviderService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int providerid;
	private String providername;
	private int fare;
	
		
	public int getProviderid() {
		return providerid;
	}


	public void setProviderid(int providerid) {
		this.providerid = providerid;
	}


	public String getProvidername() {
		return providername;
	}


	public void setProvidername(String providername) {
		this.providername = providername;
	}


	public int getFare() {
		return fare;
	}


	public void setFare(int fare) {
		this.fare = fare;
	}


	@Override
	public String toString() {
		return "Cab [provider id=" + providerid + ", provider name=" + providername + ", fare =" + fare + "]";
	}
	

}
