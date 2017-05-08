
//represents words that are in certain order
public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        for(String word: myWords){
        	ret += word + " ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if(this.length() != other.length()){
        	return false;
        }
        for(int i = 0; i < this.length() ; i++){
        	if(!((this.wordAt(i)).equals(other.wordAt(i)))){
        		return false;
        	}
        }
        return true;

    }

    //OK
    public WordGram shiftAdd(String word) {	
        WordGram out = new WordGram(myWords, 0, myWords.length);
        // shift all words one towards 0 and add word at the end. 
        // you lose the first word
        //not reaching the last word of the wordGram
        for(int i =0 ; i < out.length() - 1; i ++){
        	out.myWords[i] = out.myWords[i +1];
        }
        out.myWords[out.length()-1] = word;
        return out;
    }
    
    @Override
    public int hashCode(){
    	String ret = "";
        for(String word: myWords){
        	ret += word + " ";
        }
        return ret.trim().hashCode();
    }
}