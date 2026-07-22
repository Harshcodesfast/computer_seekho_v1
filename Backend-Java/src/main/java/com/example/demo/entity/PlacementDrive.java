package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "placement_drives")
public class PlacementDrive 
{
	private Integer driveId;
	private Course course;
	private String companyName;
	private LocalDate driveDate;
	private DriveMode driveMode;
	private String position;
	private String description;
	private String eligibilityCriteria;
	private BigDecimal packageAmount;
	private String hrContactName;
	private String hrContactEmail;
	private String hrContactPhone;
	private Integer noOfOpenings;
	private Integer noOfStudentsSelected;
	private DriveStatus driveStatus = DriveStatus.Scheduled;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drive_id")
	public Integer getDriveId() {
		return driveId;
	}
	public void setDriveId(Integer driveId) {
		this.driveId = driveId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "company_name", nullable = false, length = 150)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "drive_date", nullable = false)
	public LocalDate getDriveDate() {
		return driveDate;
	}
	public void setDriveDate(LocalDate driveDate) {
		this.driveDate = driveDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "drive_mode", nullable = false, length = 20)
	public DriveMode getDriveMode() {
		return driveMode;
	}
	public void setDriveMode(DriveMode driveMode) {
		this.driveMode = driveMode;
	}

	@Column(nullable = false, length = 100)
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	@Column(length = 2000)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "eligibility_criteria", length = 2000)
	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}
	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

	@Column(name = "package", precision = 10, scale = 2)
	public BigDecimal getPackageAmount() {
		return packageAmount;
	}
	public void setPackageAmount(BigDecimal packageAmount) {
		this.packageAmount = packageAmount;
	}

	@Column(name = "hr_contact_name", length = 150)
	public String getHrContactName() {
		return hrContactName;
	}
	public void setHrContactName(String hrContactName) {
		this.hrContactName = hrContactName;
	}

	@Column(name = "hr_contact_email", length = 150)
	public String getHrContactEmail() {
		return hrContactEmail;
	}
	public void setHrContactEmail(String hrContactEmail) {
		this.hrContactEmail = hrContactEmail;
	}

	@Column(name = "hr_contact_phone", length = 15)
	public String getHrContactPhone() {
		return hrContactPhone;
	}
	public void setHrContactPhone(String hrContactPhone) {
		this.hrContactPhone = hrContactPhone;
	}

	@Column(name = "no_of_openings")
	public Integer getNoOfOpenings() {
		return noOfOpenings;
	}
	public void setNoOfOpenings(Integer noOfOpenings) {
		this.noOfOpenings = noOfOpenings;
	}

	@Column(name = "no_of_students_selected")
	public Integer getNoOfStudentsSelected() {
		return noOfStudentsSelected;
	}
	public void setNoOfStudentsSelected(Integer noOfStudentsSelected) {
		this.noOfStudentsSelected = noOfStudentsSelected;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "drive_status", nullable = false, length = 20)
	public DriveStatus getDriveStatus() {
		return driveStatus;
	}
	public void setDriveStatus(DriveStatus driveStatus) {
		this.driveStatus = driveStatus;
	}

	public enum DriveMode { Online, Offline, Hybrid }

	public enum DriveStatus { Scheduled, Completed, Cancelled }
}