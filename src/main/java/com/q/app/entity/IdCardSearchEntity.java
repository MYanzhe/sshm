package com.q.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "t_idcardserch",catalog = "app")
public class IdCardSearchEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
	
	@Column(name="search_phone")
	private String searchPhone;
	
	@Column(name="location_x")
	private String locationX;
	
	@Column(name="location_y")
	private String locationY;
	
	@Column(name="id_card_num")
	private String idCardNum;

	@Column(name="location")
	private String location;
	
	@Column(name="device_ip")
	private String deviceIp;
	
	@Column(name="uuid")
	private String uuid;
	
	@Column(name="macAddress")
	private String macAddress;
	
	@Column(name="phoneDetile")
	private String phoneDetile;
	
	@Column(name="create_date", nullable=true, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@org.hibernate.annotations.CreationTimestamp
  private Date createDate;   
     
	
  @Column(name="last_updated", nullable=true)
  @Temporal(TemporalType.TIMESTAMP)
  @org.hibernate.annotations.UpdateTimestamp
  private Date lastUpdated;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSearchPhone() {
		return searchPhone;
	}

	public void setSearchPhone(String searchPhone) {
		this.searchPhone = searchPhone;
	}

	public String getLocationX() {
		return locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getPhoneDetile() {
		return phoneDetile;
	}

	public void setPhoneDetile(String phoneDetile) {
		this.phoneDetile = phoneDetile;
	}
	
}
