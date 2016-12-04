package lorapp.nslistener.nsmsgs.body.uplink;

import com.fasterxml.jackson.annotation.JsonProperty;

import lorapp.nslistener.nsmsgs.body.ResponseMessageBody;

public class Upload extends ResponseMessageBody{

	@JsonProperty("DevEUI")
	private String devEUI;
	@JsonProperty("Port")
	private int port;
	@JsonProperty("payload")
	private String payload;
	
	public Upload() {}
	public Upload(String appEUI, int code, int cmdSeq,
			String devEUI, int port, String payload) {
		super(appEUI, code, cmdSeq);
		this.devEUI = devEUI;
		this.port = port;
		this.payload = payload;
	}
	public String getDevEUI() {
		return devEUI;
	}
	public void setDevEUI(String devEUI) {
		this.devEUI = devEUI;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	
	
}
