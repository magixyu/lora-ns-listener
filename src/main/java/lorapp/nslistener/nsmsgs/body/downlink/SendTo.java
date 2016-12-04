package lorapp.nslistener.nsmsgs.body.downlink;

import lorapp.nslistener.nsmsgs.body.RequestMessageBody;

public class SendTo extends RequestMessageBody{
	private boolean confirm;
	private String payload;
	private int port;
	private String devEUI;
	
	public SendTo(String appEUI, int cmdSeq, String devEUI, boolean confirm,
			String payload, int port) {
		super(appEUI, "SENDTO", cmdSeq);
		this.setDevEUI(devEUI);
		this.confirm = confirm;
		this.payload = payload;
		this.port    = port;
	}	
	
	public boolean isConfirm() {
		return confirm;
	}
	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	public String getDevEUI() {
		return devEUI;
	}

	public void setDevEUI(String devEUI) {
		this.devEUI = devEUI;
	}
}
