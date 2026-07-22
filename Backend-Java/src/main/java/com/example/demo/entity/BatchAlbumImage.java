package com.example.demo.entity;

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
@Table(name = "batch_album_images")
public class BatchAlbumImage 
{
	private Integer imageId;
	private BatchAlbum album;
	private String imageUrl;
	private String caption;
	private Staff uploadedBy;
	private LocalDate uploadDate = LocalDate.now();
	private Integer displayOrder = 0;
	private Boolean isActive = true;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id", nullable = false)
	public BatchAlbum getAlbum() {
		return album;
	}
	public void setAlbum(BatchAlbum album) {
		this.album = album;
	}

	@Column(name = "image_url", nullable = false, length = 500)
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(length = 255)
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uploaded_by")
	public Staff getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(Staff uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	@Column(name = "upload_date", nullable = false)
	public LocalDate getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Column(name = "display_order", nullable = false)
	public Integer getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Column(name = "is_active", nullable = false)
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}