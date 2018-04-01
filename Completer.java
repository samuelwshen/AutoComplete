/**
 * Created by samuelshen on 3/31/18.
 */
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
    public ArrayList<String> getCompletions(String word){
        return null;
    }







}
