package com.jsonLee.javaSpringBoot.modules.test.entity;

import java.time.LocalDate;

/**
 * @Description: Gzbd
 * @author: HymanHu
 * @date: 2020年8月20日
 */
public class Gzbd {

	private int id;
	private String region;
	private LocalDate date;
	private int diagnosis;
	private int overseasImport;
	private int cure;
	private int death;
	private int therapy;
	private int observation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(int diagnosis) {
		this.diagnosis = diagnosis;
	}

	public int getOverseasImport() {
		return overseasImport;
	}

	public void setOverseasImport(int overseasImport) {
		this.overseasImport = overseasImport;
	}

	public int getCure() {
		return cure;
	}

	public void setCure(int cure) {
		this.cure = cure;
	}

	public int getDeath() {
		return death;
	}

	public void setDeath(int death) {
		this.death = death;
	}

	public int getTherapy() {
		return therapy;
	}

	public void setTherapy(int therapy) {
		this.therapy = therapy;
	}

	public int getObservation() {
		return observation;
	}

	public void setObservation(int observation) {
		this.observation = observation;
	}
}
