package lorapp.nslistener.nsmsgs.body.downlink;

import com.fasterxml.jackson.annotation.JsonProperty;

import lorapp.nslistener.nsmsgs.body.RequestMessageBody;

public class Status extends RequestMessageBody {
	@JsonProperty("DevEUI")
	private String devEUI;

	public Status(String appEUI, int cmdSeq, String devEUI) {
		super(appEUI, "STATUS", cmdSeq);
		this.devEUI = devEUI;
	}	
	
	public String getDevEUI() {
		return devEUI;
	}

	public void setDevEUI(String devEUI) {
		this.devEUI = devEUI;
	}
	
}
