import java.util.HashMap;


public class WordNet {
        //private final SAP paths;
        private final HashMap<Integer, String> id2synset;
        private final HashMap<Integer, Bag<Integer>> hypernyms;
        private final HashMap<String, Bag<Integer>> noun2ids;
        private final HashMap<String, Integer> nounsMap;
 private Synset[] synsets;
// constructor takes the name of the two input files     
public WordNet(String synsets, String hypernyms)   // the set of nouns (no duplicates), returned as an Iterable  
{
   In in = new In(synsets);
   String delimiter = ",";
  
   
   nounsMap =  new  HashMap<String, Integer>();
   id2synset = new  HashMap<Integer, String>();
   noun2ids =  new HashMap<Integer, Bag<Integer>>();
   hypernyms =  new HashMap<Integer, Bag<Integer>>();
 
   int count =0;
   //get synsets
   while (in.hasNextLine()){
       //parse 
       String synsetLine = in.readLine();
       String[] fields = synsetLine.split(delimiter);
       //get id 
       int id = Integer.parseInt(fields[0]);
       String synset = fields[1];
       id2synset.put(id,synset); 
       //parsing nouns
       String[] nouns = synset.split(" ");
   
       for(String noun : nouns){
           if(noun2ids.containsKey(noun){
               Bag b = noun2ids[noun];
               b.add(Integer(id));
               noun2ids.put(id,bag);
           }
           else{
               Bag b = new Bag();
               b.add(Integer(id));
               noun2ids.put(id,bag);
           }
       }       
   }
   
   //get hypernynms
    while (in.hasNextLine()){
       //parse 
       String line = in.readLine();
       String[] fields = line.split(delimiter);
       //get id 
       int id = Integer.parseInt(fields[0]);
       Bag bag = new Bag();
       
       for( int i=1;i<fields.lenght;i++){
           bag.add(new Integer(fields[i])); 
           // I think we should add edges here...
           digraph.addEdge(id, fields[i]);
       }
       hypernyms.put(id,bag);       
    }
        
}
public Iterable<String> nouns()   {
    
    
    return nounsMap.values();
} 
// is the word a WordNet noun?    
public boolean isNoun(String word)  {

    
    return noun2ids.containsKey(noun);
}          
// distance between nounA and nounB (defined below)
public int distance(String nounA, String nounB)    
{
    if(!isNoun(nounA)||!isNoun(nounB)){
        return new java.lang.IllegalArgumentException();
    }
    
    //get distance from A to B
    
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