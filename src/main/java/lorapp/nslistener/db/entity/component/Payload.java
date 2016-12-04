package lorapp.nslistener.db.entity.component;

import javax.persistence.Embeddable;

import org.springframework.util.Base64Utils;

@Embeddable
public class Payload {

	private float temperature;
	private float humidity;
	
	public Payload(){}
	public Payload(String payload) {
		String[] arr = new String(Base64Utils.decodeFromString(payload)).split(";");
		temperature = Float.parseFloat(arr[1]);
		humidity = Float.parseFloat(arr[2]);
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	
	
}
