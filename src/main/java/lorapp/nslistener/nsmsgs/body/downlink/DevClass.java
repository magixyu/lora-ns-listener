package lorapp.nslistener.nsmsgs.body.downlink;

import com.fasterxml.jackson.annotation.JsonProperty;

import lorapp.nslistener.nsmsgs.body.RequestMessageBody;

public class DevClass extends RequestMessageBody{
	
	@JsonProperty("DevEUI")
	private String devEUI;
	@JsonProperty("CLASS")
	private int classStr;
	

	public DevClass(String appEUI, int cmdSeq) {
		super(appEUI, "CLASS", cmdSeq);
	}
	
	public String getDevEUI() {
		return devEUI;
	}
	public void setDevEUI(String devEUI) {
		this.devEUI = devEUI;
	}
	public int getClassStr() {
		return classStr;
	}
	public void setClassStr(int classStr) {
		this.classStr = classStr;
	}
	
	
	
}
