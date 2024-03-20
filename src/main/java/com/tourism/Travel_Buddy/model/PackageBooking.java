package com.tourism.Travel_Buddy.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class PackageBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String travellerName;
	private String travellerMobile;
	@Temporal(TemporalType.DATE)
	private Date tourStartDate;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date packageBookDate;

	private int totalMember;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userId")
	private String username;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "packageId")
	private String packageId;


	public PackageBooking() {
	}

	public PackageBooking(int id, String travellerName, String travellerMobile, Date tourStartDate, Date packageBookDate, int totalMember, String username, String packageId) {
		this.id = id;
		this.travellerName = travellerName;
		this.travellerMobile = travellerMobile;
		this.tourStartDate = tourStartDate;
		this.packageBookDate = packageBookDate;
		this.totalMember = totalMember;
		this.username = username;
		this.packageId = packageId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTravellerName() {
		return travellerName;
	}

	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}

	public String getTravellerMobile() {
		return travellerMobile;
	}

	public void setTravellerMobile(String travellerMobile) {
		this.travellerMobile = travellerMobile;
	}

	public Date getTourStartDate() {
		return tourStartDate;
	}

	public void setTourStartDate(Date tourStartDate) {
		this.tourStartDate = tourStartDate;
	}

	public Date getPackageBookDate() {
		return packageBookDate;
	}

	public void setPackageBookDate(Date packageBookDate) {
		this.packageBookDate = packageBookDate;
	}

	public int getTotalMember() {
		return totalMember;
	}

	public void setTotalMember(int totalMember) {
		this.totalMember = totalMember;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPackages() {
		return packageId;
	}

	public void setPackages(String packageId) {
		this.packageId = packageId;
	}
}