package lorapp.nslistener.nsmsgs;

public enum ResponseMSG {
	JOIN("JOIN ACCEPT"),
	UPLOAD("UPLOAD");
	
	private String msg;
	
	ResponseMSG(String value) {
		this.msg = value;
	}
	
	public String getMSG(){
		return msg;
	}
}
