package SV24.NguyenTrungVinh.BTH14;

public class Bai3 {
    public static void main(String[] args) {
        String msg = "COMETAPPEARED";
        int key = 3;
        try {
            String enMsg = encode(msg, key);
            System.out.println(enMsg);
            System.out.println(decode(enMsg, key));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static String encode(String msg, int key) throws IllegalArgumentException{
        if(msg == null || msg.length() == 0)
            throw new IllegalArgumentException("'msg' must not empty or null");
        if(key < 0 || key >= 26){
            throw new IllegalArgumentException(String.format(
                "Invalid key value: key=%d\nValid key is 1<=key<26",
                key
            ));
        }

        char[] chars = msg.toCharArray();
        for(int i = 0; i<chars.length; i++){
            if(chars[i] < 'A' || chars[i] > 'Z')
                throw new IllegalArgumentException("'msg' must only contains UPPERCASE english letter. " +
                                                    "Found '" + chars[i] + "' at index " + i );
            chars[i] += key;
            if(chars[i] > 'Z')
                chars[i] -= 26;
        }

        return new String(chars);
    }

    public static String decode(String msg, int key) throws IllegalArgumentException {
        return encode(msg, 26 - key);
    }

}
