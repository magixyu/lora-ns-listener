package lorapp.nslistener.nsmsgs.util;

public class Authentication {

	public static int generateNonce() {
		return 1234;
	}
	
	public static String generateChallenge() {
		return "ABCDEF1234567890ABCDEF1234567890";
	}

/*	public static void main(String[] args){
		long appEUI = 0XAA555A0000000000L;
		long appNonce = 1234L;
		System.out.println(appEUI|appNonce|0);
	}*/
}
