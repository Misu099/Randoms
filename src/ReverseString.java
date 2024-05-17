public class ReverseString {


    public String reverse(String str) {
        str.trim();
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }

    public boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(reverse(str));
    }

}
