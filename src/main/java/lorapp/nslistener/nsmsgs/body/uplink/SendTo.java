package lorapp.nslistener.nsmsgs.body.uplink;

import lorapp.nslistener.nsmsgs.body.ResponseMessageBody;

public class SendTo extends ResponseMessageBody{

	public SendTo(String appEUI, int code, int cmdSeq) {
		super(appEUI, code, cmdSeq);
	}

}
