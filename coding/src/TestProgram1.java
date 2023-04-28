import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestProgram1 {
    public static void main(String[] args) {
        String test = "hel2lo hi1 wel3come to prog6ram o5ur";
        System.out.println(method(test));
    }

    private static String method(String s) {
        char[] charNumbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String[] words = s.split("\\s");
        StringBuilder addString = new StringBuilder();
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        System.out.println(wordList);
        for (String word: words){
            String num = word.replaceAll("[^1-9]", "");
            if(!num.equals("")){
                int index = Integer.parseInt(num) - 1;
                wordList.set(index, word);
            }
        }
        for(String word: wordList){
            addString.append(word).append(" ");
        }
        return addString.toString().replaceAll("[1-9^]*", "");
    }
}
