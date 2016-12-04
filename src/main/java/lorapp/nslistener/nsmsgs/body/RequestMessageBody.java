package lorapp.nslistener.nsmsgs.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import lorapp.nslistener.nsmsgs.MessageBody;

//{"CMD": "JOIN","CmdSeq": 1,"AppEUI": "2C26C501C0000001","AppNonce": 1234,
// "Challenge": "ABCDEF1234567890ABCDEF1234567890"}

public class RequestMessageBody extends MessageBody{
	@JsonProperty("CMD")
	private String command;
	@JsonProperty("CmdSeq")
	private int cmdSeq;	
	
	public RequestMessageBody(String appEUI, String command, int cmdSeq) {
		super(appEUI);
		this.command = command;
		this.cmdSeq  = cmdSeq;
	}
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getCmdSeq() {
		return cmdSeq;
	}
	public void setCmdSeq(int cmdSeq) {
		this.cmdSeq = cmdSeq;
	}
}
