import java.util.HashMap;


public class WordNet {
        //private final SAP paths;
        private final HashMap<Integer, String> id2synset;
        private final HashMap<Integer, Bag<Integer>> hypernyms;
        private final HashMap<String, Bag<Integer>> noun2ids;
        private final HashMap<String, Integer> nounsMap;
        private final Digraph G;
 private Synset[] synsets;
// constructor takes the name of the two input files     
public WordNet(String synsets, String _hypernyms)   // the set of nouns (no duplicates), returned as an Iterable  
{
   In in = new In(synsets);
   String delimiter = ",";
  
   nounsMap =  new  HashMap<String, Integer>();
   id2synset = new  HashMap<Integer, String>();
   noun2ids =  new HashMap<String, Bag<Integer>>();
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
           if(noun2ids.containsKey(noun)){
               Bag <Integer> b = noun2ids.get(noun);
               b.add(new Integer(id));
               noun2ids.put(noun,b);
           }
           else{
               Bag <Integer> b = new Bag<Integer>();
               b.add(new Integer(id));
               noun2ids.put(noun,b);
           }
       }       
   }
   
   Digraph digraph = new Digraph(id2synset.size());
   G= digraph;
   
   in = new In(_hypernyms);
   //get hypernynms
    while (in.hasNextLine()){
       //parse 
       String line = in.readLine();
       String[] fields = line.split(delimiter);
       //get id 
       int id = Integer.parseInt(fields[0]);
       Bag<Integer> bag = new Bag<Integer>();
       
              
       for( int i=1;i<fields.length;i++){
           int f = Integer.parseInt(fields[i]);
           bag.add(new Integer(f)); 
           // I think we should add edges here...
           digraph.addEdge(id, f);
       }
       hypernyms.put(id,bag);
    }
        
}
public Iterable<String> nouns()   {
    
    
    return nounsMap.keySet();
} 
// is the word a WordNet noun?    
public boolean isNoun(String word)  {

    
    return noun2ids.containsKey(word);
}          

// distance between nounA and nounB (defined below)
public int distance(String nounA, String nounB)    
{
    if(!isNoun(nounA)||!isNoun(nounB)){
        throw new java.lang.IllegalArgumentException();
    }
    //get vertex id
 
    Bag<Integer> a1 = (Bag<Integer>) noun2ids.get(nounA);
    Bag<Integer> b1 = (Bag<Integer>) noun2ids.get(nounB);
    for(Integer a: a1){
        for(Integer b: b1){
            int s = a.intValue();
            int v = b.intValue();
             DepthFirstDirectedPaths dfdp = new DepthFirstDirectedPaths(G,s);
                 if(dfdp.hasPathTo(v)){
                     //return(dfdp.pathTo(v));
    
                 }
        }
    }
    
    return -1;
 }
  
// a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB      
// in a shortest ancestral path (defined below)      
public String sap(String nounA, String nounB)      
{
    //Here we probably need to create a SAP
    
    
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