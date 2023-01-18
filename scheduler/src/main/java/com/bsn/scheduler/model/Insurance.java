package com.bsn.scheduler.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Insurance {
	private String providerName;
	private Double coPay;
	
	/**
	 * 
	 */
	public Insurance() {
	}
	/**
	 * @param providerName
	 * @param coPay
	 */
	public Insurance(String providerName, Double coPay) {
		this.providerName = providerName;
		this.coPay = coPay;
	}
	/**
	 * @return the providerName
	 */
	public String getProviderName() {
		return providerName;
	}
	/**
	 * @param providerName the providerName to set
	 */
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	/**
	 * @return the coPay
	 */
	public Double getCoPay() {
		return coPay;
	}
	/**
	 * @param coPay the coPay to set
	 */
	public void setCoPay(Double coPay) {
		this.coPay = coPay;
	}
	@Override
	public String toString() {
		return "Insurance [providerName=" + providerName + ", coPay=" + coPay + "]";
	}
}
