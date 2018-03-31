/**
 * Created by samuelshen on 3/31/18.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class Trie implements Iterable<String> {
    private ArrayList<TrieNode> heads;
    private ArrayList<String> values;

    //empty constructor
    public Trie(){
        heads = new ArrayList<>();
        values = new ArrayList<>();
    }

    //constructor give @new_heads
    public Trie(ArrayList<TrieNode> new_heads){
        heads = new_heads;
        values = new ArrayList<>();
    }

    //constructor given a list of Strings @words
    public Trie(List<String> words){
        ///IMPLEMENT
    }

    //add a word
    //return true if word is added, false if already present
    public boolean addWord(String word){
        if(values.contains(word)){
            return false;
        }
        values.add(word);
        TrieNode first_char = new TrieNode(word.charAt(0));
        try {
            word = word.substring(1);
        } catch (IndexOutOfBoundsException e){
            word = "";
        }
        TrieNode temp_node = new TrieNode();
        if(heads.contains(first_char)){
            temp_node = heads.get(heads.indexOf(first_char));
        } else {
            temp_node = first_char;
            heads.add(temp_node);
        }
        while(word.length() > 0){
            char temp_char = word.charAt(0);
            temp_node = temp_node.addChild(temp_char);
            try {
                word = word.substring(1);
            } catch (IndexOutOfBoundsException e){
                word = "";
            }
        }
        return true;
    }


    //just returns the iterator for a list of all the words
    public Iterator<String> iterator(){
        return values.iterator();
    }

    //testmain
    public static void main(String [] args){
        Trie test_trie = new Trie();
        test_trie.addWord("Hello");
        test_trie.addWord("Goodbye");
        test_trie.addWord("Heat");

        Iterator it = test_trie.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}