public class textProcessor {

    // Count words in a sentence
    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }

        // Split by spaces using regex to handle multiple spaces
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Replace specific words
    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null) return "";
        return text.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        String text = "Java is fun and Java is powerful";

        // Count words
        int wordCount = countWords(text);
        System.out.println("Word count: " + wordCount);

        // Replace "Java" with "Programming"
        String replacedText = replaceWord(text, "Java", "Programming");
        System.out.println("Modified sentence: " + replacedText);
    }
}
