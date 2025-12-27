/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
    	System.out.println(isPalindrome(args[0]));
    }
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String s) {
    if (s.length() <= 1) {
	return true;
}
    char first = s.charAt(0);
    char last = s.charAt(s.length() - 1);
    //אם הקצוות לא שווים - זה בטוח לא פלינדרום
    if (first != last) {
        return false;
    }
    return isPalindrome(s.substring(1,s.length()-1));
    }
}