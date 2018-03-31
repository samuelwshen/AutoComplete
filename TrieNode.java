/**
 * Created by samuelshen on 3/31/18.
 */
import java.util.ArrayList;
public class TrieNode {
    private ArrayList<TrieNode> children;
    private char value;

    //default constructor
    public TrieNode(){
        children = new ArrayList<>();
    }

    /*constructor with one param
    * @new_val denotes the value of the TrieNode
    * sets @children to an empty arraylist
     */
    public TrieNode(char new_val){
        value = new_val;
        children = new ArrayList<>();
    }

    /*constructor with both params
    * @new_val denotes the value of the TrieNode
    * #new_chil denotes the children of the TrieNode
     */
    public TrieNode(char new_val, ArrayList<TrieNode> new_chil){
        value = new_val;
        children = new_chil;
    }

    // getter/setter methods
    public ArrayList<TrieNode> getChildren(){
        return children;
    }

    public char getValue(){
        return value;
    }

    //adds child if a node of that value isn't present, returns that node
    //returns the already existing node if the value is already present
    public TrieNode addChild(TrieNode new_child){
        if(this.leadsTo(new_child.getValue())){
            return this.getChild(new_child.getValue());
        }
        children.add(new_child);
        return(new_child);
    }

    //adds child by value
    public TrieNode addChild(char child_value){
        return addChild(new TrieNode(child_value));
    }

    public boolean setValue(char new_val){
        try {
            value = new_val;
            return true;
        } catch (Exception e){
            return false;
        }
    }

    //determines if this trie node has @target as its value
    public boolean isValue(char target){
        return(value == target);
    }

    //determines if @target is the value of a child node
    public boolean leadsTo(char target){
        for(TrieNode temp: children){
            if(temp.isValue(target)){
                return true;
            }
        }
        return false;
    }

    //two TrieNodes equal if their values are the same
    public boolean equals(Object other){
        if(other.getClass().equals(this.getClass())){
            return(((TrieNode)other).isValue(this.value));
        }
        return false;
    }

    //gets child with @target as value
    //returns null if no child of that target exists
    private TrieNode getChild(char target){
        if (this.leadsTo(target)){
            for(TrieNode temp: children){
                if(temp.isValue(target)){
                    return temp;
                }
            }
        }
        return null;
    }

}
