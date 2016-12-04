package lorapp.nslistener.db.entity.component;

import javax.persistence.Embeddable;

@Embeddable
public class DevAppMap {
	
	private String devEUI;
	private String appEUI;
	
	public DevAppMap(){}
	public DevAppMap(String appEUI2, String devEUI2) {
		appEUI = appEUI2;
		devEUI = devEUI2;
	}
	public String getDevEUI() {
		return devEUI;
	}
	public void setDevEUI(String devEUI) {
		this.devEUI = devEUI;
	}
	public String getAppEUI() {
		return appEUI;
	}
	public void setAppEUI(String appEUI) {
		this.appEUI = appEUI;
	}
	
	
}
