package SV24.NguyenTrungVinh.BTH14;

public class Bai2 {
    public static void main(String[] args) {
        String sentence = "   flyyyy me     to    the    moon       ";
        sentence = "  hahahauhs";
        try {
            String lastWord = lastWordOf(sentence);
            System.out.printf("The last word is \"%s\" with length %d\n", lastWord, lastWord.length());
            
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot find last word of string s because " + e.getMessage());
        }
    }

    public static String lastWordOf(String s) throws IllegalArgumentException {
        if (s == null || s.length() == 0 || s.length() > 10_000) 
            throw new IllegalArgumentException("String s must not null and have 1 <= length <= 10^4");
        for(char c : s.toCharArray()){
            if( (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c == ' '))
                continue;
            else
                throw new IllegalArgumentException("String s must ONLY contains english letter and space");
        }
        String[] words = s.split("\\s+");
        if(words.length == 0)
            throw new IllegalArgumentException("String s must have at least 1 character [a-zA-Z]");
        return words[words.length - 1];
    }
}
