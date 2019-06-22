package chk;

public class WordFilter {

    private final String[] words;

    public WordFilter(String[] words) {
        this.words = words;
    }

    public int f(String prefix, String suffix) {
        int weight = -1;
        for (int idx = words.length - 1; idx >= 0; idx--) {
            String word = words[idx];
            if (word.startsWith(prefix) && word.endsWith(suffix)) {
                weight = idx;
                break;
            }
        }

        return weight;
    }
}