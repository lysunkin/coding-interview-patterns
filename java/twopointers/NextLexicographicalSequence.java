package twopointers;

public class NextLexicographicalSequence {
    public String nextLexicographicalSequence(String s) {
        char[] letters = s.toCharArray();
        // Locate the pivot, which is the first character from the right that breaks non-increasing order.
        // Start searching from the second-to-last position.
        int pivot = s.length() - 2;
        while (pivot >= 0 && letters[pivot] >= letters[pivot + 1]) {
            pivot--;
        }
        // If pivot is not found, the string is already in its largest permutation.
        // In this case, reverse the string to obtain the smallest permutation.
        if (pivot == -1) {
            reverseCharArray(letters, 0, letters.length - 1);
            return new String(letters);
        }
        // Find the rightmost successor to the pivot.
        int rightMostSuccessor = s.length() - 1;
        while (letters[rightMostSuccessor] <= letters[pivot]) {
            rightMostSuccessor--;
        }
        // Swap the rightmost successor with the pivot to increase the lexicographical order of the suffix.
        char temp = letters[pivot];
        letters[pivot] = letters[rightMostSuccessor];
        letters[rightMostSuccessor] = temp;

        // Reverse the suffix after the pivot to minimize its permutation.
        reverseCharArray(letters, pivot + 1, letters.length - 1);
        return new String(letters);
    }

    public void reverseCharArray(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println("Tests a string with a single character.\n" +
                " Input: s='a'\n" +
                " Expected output: 'a'\n" +
                " Actual output: " + new NextLexicographicalSequence().nextLexicographicalSequence("a"));

        System.out.println("Tests a string with a repeated character.\n" +
                " Input: s='aaaa'\n" +
                " Expected output: 'aaaa'\n" +
                " Actual output: " + new NextLexicographicalSequence().nextLexicographicalSequence("aaaa"));

        System.out.println("Tests a string with a random pivot character.\n" +
                " Input: s='ynitsed'\n" +
                " Expected output: 'ynsdeit'\n" +
                " Actual output: " + new NextLexicographicalSequence().nextLexicographicalSequence("ynitsed"));

        System.out.println("Tests a string with a single character.\n" +
                " Input: s='a'\n" +
                " Expected output: 'a'\n" +
                " Actual output: " + new NextLexicographicalSequence().nextLexicographicalSequence2("a"));

        System.out.println("Tests a string with a repeated character.\n" +
                " Input: s='aaaa'\n" +
                " Expected output: 'aaaa'\n" +
                " Actual output: " + new NextLexicographicalSequence().nextLexicographicalSequence2("aaaa"));

        System.out.println("Tests a string with a random pivot character.\n" +
                " Input: s='ynitsed'\n" +
                " Expected output: 'ynsdeit'\n" +
                " Actual output: " + new NextLexicographicalSequence().nextLexicographicalSequence2("ynitsed"));  }

}
