package com.smsPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Created by Parul Gangwal on 22/06/2019.
 */
@Entity
@Table(name = "tbl_contacts")
@EntityListeners(AuditingEntityListener.class)
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Long contactId;

	@Column(name = "group_id")
	private Long groupId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "title")
	private String title;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "caste")
	private String caste;

	@NotBlank
	@Column(name = "contact_no1")
	private String contactNo1;

	@Column(name = "contact_no2")
	private String contactNo2;

	@Column(name = "email_address")
	private String email;

	@Column(name = "dob")
	private String dob;

	@Column(name = "ann_date")
	private String annDate;

	@Column(name = "death_date")
	private String deathDate;

	@Column(name = "death_message")
	private String deathMessage;

	@Column(name = "profile_pic")
	private String profilePic;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public String getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAnnDate() {
		return annDate;
	}

	public void setAnnDate(String annDate) {
		this.annDate = annDate;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathMessage() {
		return deathMessage;
	}

	public void setDeathMessage(String deathMessage) {
		this.deathMessage = deathMessage;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

}
