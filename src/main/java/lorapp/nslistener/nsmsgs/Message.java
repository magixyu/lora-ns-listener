package lorapp.nslistener.nsmsgs;

public class Message {
	
	private int header;
	private String body;
	
	public Message(String body) {
		header = body.length();
		this.body = body;
	}
	
	public int getHeader() {
		return header;
	}
	public void setHeader(int header) {
		this.header = header;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override 
	public String toString() {
		return "\n" + String.valueOf(header) + "\n" + body + "\n";
	}
	
}
