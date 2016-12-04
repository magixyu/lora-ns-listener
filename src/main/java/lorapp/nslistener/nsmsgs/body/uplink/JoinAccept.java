package lorapp.nslistener.nsmsgs.body.uplink;

import com.fasterxml.jackson.annotation.JsonProperty;

import lorapp.nslistener.nsmsgs.body.ResponseMessageBody;

public class JoinAccept extends ResponseMessageBody{


	@JsonProperty("CMD")
	private String command;
	
	public JoinAccept() {}
	public JoinAccept(String appEUI, int code, int cmdSeq, String command) {
		super(appEUI, code, cmdSeq);
		this.command = command;
	}
}
