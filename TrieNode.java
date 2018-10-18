/**
 * Created by samuelshen on 3/31/18.
 */
import java.util.ArrayList;
public class TrieNode {
    private ArrayList<TrieNode> children;
    private char value;
    private boolean end;

    //default constructor
    public TrieNode(){
        children = new ArrayList<>();
    }

    /*constructor with one param
    * @new_val denotes the value of the TrieNode
    * sets @children to an empty arraylist
     */
    public TrieNode(char new_val, boolean isEnd){
        value = new_val;
        end = isEnd;
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
    public TrieNode addChild(char child_value, boolean eend){
        return addChild(new TrieNode(child_value, eend));
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

    public boolean leadsTo(TrieNode target){
        return(leadsTo(target.getValue()));
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
    public TrieNode getChild(char target){
        if (this.leadsTo(target)){
            for(TrieNode temp: children){
                if(temp.isValue(target)){
                    return temp;
                }
            }
        }
        return null;
    }

    public TrieNode getChild(TrieNode target){
        return(getChild(target.getValue()));
    }

    public boolean isEnd(){
        return end;
    }

}
