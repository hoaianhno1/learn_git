package day1;

public class StringUltils {
    public static String reverse(String s){
        if(s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }

    public static int countChar(String s, char c){
        if(s == null) return 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }
        }
        return count;
    }

    public static boolean isPalindrome(String s){
        if(s == null) return false;
        int i = 0;
        int l = s.length() - 1;
        while(i < l){
            if(s.charAt(i) != s.charAt(l)) return false;
            i++;
            l--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "hoaianh";
        System.out.println("Reversed \'" + s + "\': " + reverse(s));
        System.out.println(countChar(s, 'a'));
        System.out.println(isPalindrome(s));
        System.out.println("abba: " + isPalindrome("abba"));
    }
}
