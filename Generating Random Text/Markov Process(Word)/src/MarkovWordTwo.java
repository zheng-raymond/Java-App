
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-2);  // random word to start with
		String key1 = myText[index];
		String key2 = myText[index+1];
		sb.append(key1);
		sb.append(" ");
		sb.append(key2);
		for(int k=0; k < numWords-1; k++){
		    ArrayList<String> follows = getFollows(key1,key2);
		    //System.out.println("The follows of "+ key1 + " and "+ key2 + "are" + follows);
		    //System.out.println("The key is " + key + " and the follows are : "+ follows);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key1 = key2;
			key2 = next;
		}
		
		return sb.toString().trim();
	}
	
	private ArrayList<String> getFollows(String key1, String key2) {
	    ArrayList<String> follows = new ArrayList<String>();
	    int start = 0;
	    while(start < myText.length){
	    	int keyIdx = indexOf(myText, key1,key2, start);
	    	//not found 
	    	if(keyIdx == -1){
	    		break;
	    	}
	    	//key is the last word of the array
	    	if(keyIdx >= myText.length -2){
	    		break;
	    	}
	    	follows.add(myText[keyIdx +2]);
	    	//use +1 or +2 here ?
	    	start = keyIdx + 1;
	    }
	    return follows;
    }
	
	private int indexOf(String words[], String target1, String target2, int start){
		for(int i = start ; i < words.length -1 ; i ++){
			if(words[i].equals(target1) && words[i+1].equals(target2)){
				return i;
			}
		}
		return -1;
	}
	
	public void testIndexOf(){
		String s = "this is just a test yes this is a simple test";
		String words[] = s.split("\\s+");
		System.out.println("Testing : " + s);
		System.out.println("this is starting form 3 is " + indexOf(words,"this","is",3));
	}
	

}
