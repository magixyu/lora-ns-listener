package lorapp.nslistener.nsmsgs.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import lorapp.nslistener.nsmsgs.MessageBody;

//{"CMD": "JOIN","CmdSeq": 1,"AppEUI": "2C26C501C0000001","AppNonce": 1234,
// "Challenge": "ABCDEF1234567890ABCDEF1234567890"}

public class ResponseMessageBody extends MessageBody {

	@JsonProperty("CODE")
	private int code;
	@JsonProperty("CmdSeq")
	private int cmdSeq;
	@JsonProperty("MSG")
	private String message;
	
	public ResponseMessageBody() {}
	public ResponseMessageBody(String appEUI, int code, int cmdSeq) {
		super(appEUI);
		this.code = code;
		this.cmdSeq = cmdSeq;
	}
	
}
