package lorapp.nslistener.nsmsgs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageBody {
	@JsonProperty("AppEUI")
	private String appEUI;
	
	public MessageBody(){}
	public MessageBody(String appEUI) {
		this.appEUI = appEUI;
	}

	public String getAppEUI() {
		return appEUI;
	}

	public void setAppEUI(String appEUI) {
		this.appEUI = appEUI;
	}
	
	
}
