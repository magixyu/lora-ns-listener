package lorapp.nslistener.nsmsgs.body.downlink;

import lorapp.nslistener.nsmsgs.body.RequestMessageBody;

public class Quit extends RequestMessageBody{
	public Quit(String appEUI, int cmdSeq) {
		super(appEUI, "QUIT", cmdSeq);
	}	
}
