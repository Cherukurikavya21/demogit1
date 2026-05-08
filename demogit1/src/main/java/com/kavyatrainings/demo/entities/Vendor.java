package com.kavyatrainings.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Entity
@Table(name = "VENDOR")
public class Vendor {

	@Id
	@Column(nullable=false, name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	@Column(nullable=false, name="COMPANY_NAME")
	public String companyName;
	@Column(nullable=false, name="FIRST_NAME")
	public String firstName;
	@Column(nullable=false, name="LAST_NAME")
	public String lastName;
	@Column(nullable=false, name="WEBSITE")
	public String webSite;
	@Column(nullable=false, name="EMAILID")
	public String email;
	@Column(nullable=false, name="STATUS")
	public String status;
	@Column(nullable=false, name="GST_NO")
	public String gstNo;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="vendor", referencedColumnName="ID")
	private List<address> addresses = new ArrayList<>();
	
	public Vendor() {
		
	}
	
	public Vendor(Long id, String companyName, String firstName, String lastName, String webSite, String email,
			String status, String gstNo, List<address> addresses) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.webSite = webSite;
		this.email = email;
		this.status = status;
		this.gstNo = gstNo;
		this.addresses = addresses;
	}

	public List<address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<address> addresses) {
		this.addresses = addresses;
	}

	public Vendor(Long id, String companyName, String firstName, String lastName, String webSite, String email,
			String status, String gstNo) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.webSite = webSite;
		this.email = email;
		this.status = status;
		this.gstNo = gstNo;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	    
	
}
