/**
 * Created by samuelshen on 3/31/18.
 * A case-sensitive Trie implementation
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class Trie implements Iterable<String> {
    //private ArrayList<TrieNode> heads;
    private TrieNode head;
    private ArrayList<String> values;

    //empty constructor
    public Trie(){
        head = new TrieNode();
        values = new ArrayList<>();
    }

    //constructor given @new_head
    public Trie(TrieNode new_head){
        head = new_head;
        values = new ArrayList<>();
    }

    //constructor given a list of Strings @words
    public Trie(List<String> words){
        //TODO: IMPLEMENT
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
        if(head.leadsTo(first_char)){
            temp_node = head.getChild(first_char);
        } else {
            temp_node = first_char;
            head.addChild((temp_node));
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

    public ArrayList<String> complete (TrieNode start_node){
        ArrayList<String> completions = new ArrayList<>();
        String val = String.valueOf(start_node.getValue());
        //base case
        if(start_node.getChildren().isEmpty()){
            completions.add(val);
            return completions;
        } else {
            for(TrieNode child_node: start_node.getChildren()) {
                ArrayList<String> child_call = complete(child_node);
                for (String child_completion : child_call) {
                    completions.add(val + child_completion);
                }
            }
            return completions;
        }
    }

    public ArrayList<String> complete (String wordNub){
        TrieNode temp = head;
        for(char c: wordNub.toCharArray()){
            temp = temp.getChild(c);
            if(temp == null){   //no completions case
                return new ArrayList<String>();
            }
        }
        ArrayList<String> endings = complete(temp);   //these are completions sans wordNub
        ArrayList<String> completions = new ArrayList<>();
        for(String post: endings){
            completions.add(wordNub + post);
        }
        return completions;
    }


    //just returns the iterator for a list of all the words
    public Iterator<String> iterator(){
        return values.iterator();
    }

    //testmain
    public static void main(String [] args){
        Trie test_trie = new Trie();
        test_trie.addWord("Hello");
        test_trie.addWord("hello");
        test_trie.addWord("Goodbye");
        test_trie.addWord("Heat");

        System.out.println(test_trie.complete("He"));
    }

}