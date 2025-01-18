import java.io.*;
import java.util.*;

public class QA2 {

    public static void main(String[] args) throws IOException {
        String inputFile = "C:\\Users\\ASUS\\IdeaProjects\\try\\src\\Input_02.txt";
        // copy the path of the file for input (input 1 and input 2 ) which will be stored in String datatype
        List<String> inputWords = extractWordsFromFile(inputFile);

        long processingStart = System.currentTimeMillis();

        String[] longestWords = determineLongestCompoundWords(inputWords);

        long processingEnd = System.currentTimeMillis();
        System.out.println("Longest Compound Word: " + longestWords[0]);
        System.out.println("Second Longest Compound Word: " + longestWords[1]);
        System.out.println("Processing time: " + (processingEnd - processingStart) + " milliseconds");
    }

    private static List<String> extractWordsFromFile(String inputFile) throws IOException {
        List<String> wordList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                wordList.add(currentLine.trim());
            }
        }
        return wordList;
    }

    private static String[] determineLongestCompoundWords(List<String> wordList) {
        Set<String> uniqueWords = new HashSet<>(wordList);
        PriorityQueue<String> lengthQueue = new PriorityQueue<>((w1, w2) -> w2.length() - w1.length());
        lengthQueue.addAll(wordList);

        String primaryLongest = "";
        String secondaryLongest = "";

        while (!lengthQueue.isEmpty()) {
            String currentWord = lengthQueue.poll();
            if (isConstructedFromOtherWords(currentWord, uniqueWords, true)) {
                if (primaryLongest.isEmpty()) {
                    primaryLongest = currentWord;
                } else {
                    secondaryLongest = currentWord;
                    break;
                }
            }
        }

        return new String[]{primaryLongest, secondaryLongest};
    }

    private static boolean isConstructedFromOtherWords(String candidate, Set<String> uniqueWords, boolean isOriginal) {
        if (!isOriginal && uniqueWords.contains(candidate)) return true;

        for (int index = 1; index < candidate.length(); index++) {
            String prefixPart = candidate.substring(0, index);
            String suffixPart = candidate.substring(index);

            if (uniqueWords.contains(prefixPart) && isConstructedFromOtherWords(suffixPart, uniqueWords, false)) {
                return true;
            }
        }

        return false;
    }
}

