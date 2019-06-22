package chk;

import java.util.*;
import java.util.stream.Stream;

public class WordDictionary {

    private final char _WILDCARD = '.';
    private final Map<Integer, List<String>> wordsByLength;

    public WordDictionary() {
        wordsByLength = new HashMap<>();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        wordsByLength.putIfAbsent(word.length(), new ArrayList<>());
        wordsByLength.get(word.length()).add(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {

        if (wordsByLength.get(word.length()) == null) {
            return false;
        }

        Stream<String> strStream = wordsByLength.get(word.length())
                .stream();

        boolean wildcard = isOnlyWildcard(word);

        if (wildcard) {
            return strStream.findAny().isPresent();
        } else {
            return strStream
                    .anyMatch(dict -> matches(dict, word));
        }


    }

    private boolean isOnlyWildcard(String word) {

        Set<Character> chars = new HashSet<>();
        for (char chars1 : word.toCharArray()) {
            chars.add(chars1);
        }

        return chars.contains(_WILDCARD) && chars.size() == 1;
    }

    private boolean matches(String dict, String word) {

        char[] dictArr = dict.toCharArray();
        char[] wordArr = word.toCharArray();

        boolean matches = true;

        for (int idx = 0; idx < dictArr.length; idx++) {

            if (wordArr[idx] != dictArr[idx] && wordArr[idx] != _WILDCARD) {
                matches = false;
                break;
            }

        }


        return matches;
    }


}
