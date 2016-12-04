package lorapp.nslistener.db.entity;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lorapp.nslistener.db.entity.component.DevAppMap;
import lorapp.nslistener.db.entity.component.Payload;

@Entity(name="upload_messages")
public class UploadMessage {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Embedded
	@JsonUnwrapped
	private DevAppMap devAppMap;
	
	private Date receiveTime = new Date();
	@Embedded
	@JsonUnwrapped
	private Payload payload;
	
	public UploadMessage() {}
	public UploadMessage(String appEUI, String devEUI, String payload) {
		this.devAppMap = new DevAppMap(appEUI, devEUI);
		this.payload = new Payload(payload);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public DevAppMap getDevAppMap() {
		return devAppMap;
	}
	public void setDevAppMap(DevAppMap devAppMap) {
		this.devAppMap = devAppMap;
	}	
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Payload getPayload() {
		return payload;
	}
	public void setPayload(Payload payload) {
		this.payload = payload;
	}

}
