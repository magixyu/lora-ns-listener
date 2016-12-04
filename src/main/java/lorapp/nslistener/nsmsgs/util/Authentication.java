package lorapp.nslistener.nsmsgs.util;

public class Authentication {

	public static int generateNonce() {
		return 1234;
	}
	
	public static String generateChallenge() {
		return "ABCDEF1234567890ABCDEF1234567890";
	}
}
