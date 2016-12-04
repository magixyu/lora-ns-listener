package lorapp.nslistener.db.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lorapp.nslistener.db.entity.component.DevAppMap;

@Entity(name="devices")
public class DevConfig {

	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private DevAppMap devAppMap;

	private float longitude;
	private float latitude;

	private int messageInterval;
	private boolean showOnMap;
	
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
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public boolean isShowOnMap() {
		return showOnMap;
	}
	public void setShowOnMap(boolean showOnMap) {
		this.showOnMap = showOnMap;
	}
	public int getMessageInterval() {
		return messageInterval;
	}
	public void setMessageInterval(int messageInterval) {
		this.messageInterval = messageInterval;
	}

}
