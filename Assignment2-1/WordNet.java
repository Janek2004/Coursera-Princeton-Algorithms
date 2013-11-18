import java.util.HashMap;


public class WordNet {
        //private final SAP paths;
        private final HashMap<Integer, String> id2synset;
        private final HashMap<String, Bag<Integer>> noun2ids;
 private Synset[] synsets;
// constructor takes the name of the two input files     
public WordNet(String synsets, String hypernyms)   // the set of nouns (no duplicates), returned as an Iterable  
{
   In in = new In(synsets);
   String delimiter = ",";
  
   
   
   id2synset = new  HashMap<Integer, String>();
   noun2ids =  new HashMap<String, Bag<Integer>>();
   
   //String[] s = in.readAllStrings();
   //System.out.println("Count "+s.length);
   while (in.hasNextLine()){
       //parse 
       String synsetLine = in.readLine();
       String[] fields = synsetLine.split(delimiter);
       //get id 
       int id = Integer.parseInt(fields[0]);
       String synset = fields[1];
       String def = fields[2];
       id2synset.put(id,synset); 
       
       //Digraph G
   }
   Digraph G = new Digraph(id2synset.size());
   
   
//    while (!StdIn.isEmpty()) {             
//         int v = StdIn.readInt();              
//         int w = StdIn.readInt();              
//        }
//    in = new In(hypernyms);
//
//    while (!StdIn.isEmpty()) {             
//         int v = StdIn.readInt();              
//         int w = StdIn.readInt();              
//        }
        
}
public Iterable<String> nouns()   {
    
    
    return null;
} 
// is the word a WordNet noun?    
public boolean isNoun(String word)  {

    return false;
}          
// distance between nounA and nounB (defined below)
public int distance(String nounA, String nounB)    
{
    return -1;
}    
// a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB      
// in a shortest ancestral path (defined below)      
public String sap(String nounA, String nounB)      
{
    
    
    return "";
}


private class Synset{
    private int id;
    private String synset;
    private String def;
    
    Synset(int id, String synset, String def){
       this.id = id;
       this.synset = synset;
       this.def = def;
    }

}

// for unit testing of this class      
public static void main(String[] args)
{
    WordNet wn = new WordNet("synsets.txt","synonyms.txt");
}



}