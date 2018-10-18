/**
 * Created by samuelshen on 3/31/18.
 */
//TODO: FIX COMPLETIONS WHERE WORDNUB IS FULL WORD
import java.util.List;
import java.util.ArrayList;
public class Completer {
    private Trie words;

    //blank constructor
    public Completer(){
        words = new Trie();
    }

    //with param constructor
    public Completer(List<String> dict){
        words = new Trie(dict);
    }

    //
    public boolean addWord(String word){
        return(words.addWord(word));
    }

    //TODO: IMPLEMENT
    public ArrayList<String> getCompletions(String wordNub){
        ArrayList<String> completions = new ArrayList<>();
        completions = words.complete(wordNub);
        return completions;
    }

    //test main
    public static void main (String [] args){
        String[] testWords = {"Test", "test", "Sam", "Supercalifragialistic", "California", "Airplane", "AiRplane", "teeth", "te"};
        Completer tester = new Completer();
        for(String s: testWords){
            tester.addWord(s);
        }
        ArrayList<String> completions = tester.getCompletions("te");
        System.out.println(completions);
    }





}
