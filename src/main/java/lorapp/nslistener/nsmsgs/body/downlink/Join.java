package lorapp.nslistener.nsmsgs.body.downlink;

import com.fasterxml.jackson.annotation.JsonProperty;

import lorapp.nslistener.nsmsgs.body.RequestMessageBody;

public class Join extends RequestMessageBody{
	@JsonProperty("AppNonce")
	private int appNonce;
	@JsonProperty("Challenge")
	private String challenge;
	
	public Join(String appEUI, int cmdSeq, int appNonce, String challenge) {
		super(appEUI, "JOIN", cmdSeq);
		this.appNonce = appNonce;
		this.challenge = challenge;
	}
	public int getAppNonce() {
		return appNonce;
	}
	public void setAppNonce(int appNonce) {
		this.appNonce = appNonce;
	}
	public String getChallenge() {
		return challenge;
	}
	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}
	
	
}
