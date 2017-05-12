public class RomanToArabic {

    private int getArabic(char ch) {
        int output = 0;
        switch (ch) {
            case 'I':
                output = 1;
                break;
            case 'V':
                output = 5;
                break;
            case 'X':
                output = 10;
                break;
            case 'L':
                output = 50;
                break;
            case 'C':
                output = 100;
                break;
            case 'D':
                output = 500;
                break;
            case 'M':
                output = 1000;
                break;
            default:
                break;
        }
        return output;
    }

    public int convert(String input) {
        char[] inputArray = input.toUpperCase().toCharArray();
        int output = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            int s1 = getArabic(inputArray[i]);
            int s2 = getArabic(inputArray[i + 1]);
            if (s1 < s2) {
                output -= s1;
            } else {
                output += s1;
            }
        }
        return output + getArabic(inputArray[inputArray.length - 1]);
        //adding last element
    }
// I
// II
// III
// IV
// V
// VI
// VII
// VIII
// IX
// X
// XI
// XII
// XIII
// XIV
}
