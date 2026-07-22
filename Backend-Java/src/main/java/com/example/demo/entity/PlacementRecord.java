package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "placement_records")
public class PlacementRecord 
{
	private Integer placementId;
	private Student student;
	private Batch batch;
	private String position;
	private PlacementDrive drive;
	private BigDecimal packageAmount;
	private LocalDate placementDate;
	private Boolean isFeatured = false;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "placement_id")
	public Integer getPlacementId() {
		return placementId;
	}
	public void setPlacementId(Integer placementId) {
		this.placementId = placementId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", nullable = false)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "batch_id")
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@Column(length = 200)
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "drive_id")
	public PlacementDrive getDrive() {
		return drive;
	}
	public void setDrive(PlacementDrive drive) {
		this.drive = drive;
	}

	@Column(name = "package", precision = 10, scale = 2)
	public BigDecimal getPackageAmount() {
		return packageAmount;
	}
	public void setPackageAmount(BigDecimal packageAmount) {
		this.packageAmount = packageAmount;
	}

	@Column(name = "placement_date")
	public LocalDate getPlacementDate() {
		return placementDate;
	}
	public void setPlacementDate(LocalDate placementDate) {
		this.placementDate = placementDate;
	}

	@Column(name = "is_featured", nullable = false)
	public Boolean getIsFeatured() {
		return isFeatured;
	}
	public void setIsFeatured(Boolean isFeatured) {
		this.isFeatured = isFeatured;
	}
}