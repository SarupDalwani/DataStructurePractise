package strings;

/**
 *
 *
 * Problem : Implement run-length encoding and decoding functions. Assume the string to be encoded consists of letters of the alphabet, with no digits, and the string to be decoded is a valid encoding.
 *<br>
 *<br>
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Not counting space for output
 *<br>
 *<br>
 * External links :
 *   <ul>
 *       <li><a href=""></a></li>
 *  </ul>
 *
 * @author Sarup Dalwani
 *
 */

public class RunLength {
    public static void main(String[] args) {

        String encodeInput1 ="";
        String encodeInput2 ="abcdefg";
        String encodeInput3 ="aaaabbbaaabbaaaba";

        System.out.println("Encoded string for "+encodeInput1+" is "+encode(encodeInput1));
        System.out.println("Encoded string for "+encodeInput2+" is "+encode(encodeInput2));
        System.out.println("Encoded string for "+encodeInput3+" is "+encode(encodeInput3));

        System.out.println("Decoded string for "+encode(encodeInput1)+" is "+decode(encode(encodeInput1)));
        System.out.println("Decoded string for "+encode(encodeInput2)+" is "+decode(encode(encodeInput2)));
        System.out.println("Decoded string for "+encode(encodeInput3)+" is "+decode(encode(encodeInput3)));

    }

    private static String encode(String str){
        int count=0;
        char c =' ';
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        if(str.length()>0){
            c = str.charAt(startIndex++);
            count=1;
        }

        while (startIndex<str.length()){
            if(str.charAt(startIndex) == c){
                count ++;
            }
            else {
                sb.append(count);
                sb.append(c);
                count=1;
                c=str.charAt(startIndex);
            }
            startIndex++;
        }
        sb.append(count);
        sb.append(c);

        return sb.toString();
    }

    private static String decode(String encoded){
        int count=0;
        char c = ' ';
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;

        while(startIndex<encoded.length()){
            while (startIndex<encoded.length() && encoded.charAt(startIndex)>='0' && encoded.charAt(startIndex)<='9'){
                count *= 10;
                count += encoded.charAt(startIndex)-'0';
                startIndex++;
            }
            c=encoded.charAt(startIndex++);
            while(count>0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}
