public class SAP{
private Digraph digraph;
private boolean[] marked;

// constructor takes a digraph (not necessarily a DAG)     
public SAP(Digraph G)     
{
    digraph = G.copy();
    marked = new  boolean[G.V()];
}
// length of shortest ancestral path between v and w; -1 if no such path     

public int length(int v, int w)      
{
    return aLenght(v,v,w,true);
}

private alength (int s, int v, int w, boolean length)
{
    BreadthFirstDirectedPaths bfdp = new BreadthFirstDirectedPaths(digraph, v);
    if(bfdp.hasPathTo(w)){
        // get path from s to v and from w to v
        int l1 = bfdp.distTo(s);
        int l2 = bfdp.distTo(w);
        if(length){
            return l1+l2;
        }else{
            return v;
        }
    }
    marked[v] = true;
    for(int i: digraph.adj(v)){
        if(!marked[i]){
           aLength(s,i,w,length);
        }        
    }
    return -1;
}




// a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path     
public int ancestor(int v, int w)          
{
   return aLength(v,v,w,false);
}

// length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path 
public int length(Iterable<Integer> v, Iterable<Integer> w)
{
    
   //
    return -1;
} 

// a common ancestor that participates in shortest ancestral path; -1 if no such path   
 public int ancestor(Iterable<Integer> v, Iterable<Integer> w)     
 {
//     Iterable[] it = new Iterable[2];
//     it[0] = v;
//     it[1] = w;
     
     BreadthFirstDirectedPaths bfdp = new BreadthFirstDirectedPaths(digraph, v);
     //we need to loop through
     for(Integer a : w){
         bfdp.hasPathTo(a.intValue()){
             //return
         return bfdp.
         }
     }
     
  return -1;   
 }
 
 
 
 


// for unit testing of this class (such as the one below)      
public static void main(String[] args) {
    In in = new In(args[0]);          
    Digraph G = new Digraph(in);          
    SAP sap = new SAP(G);          
    while (!StdIn.isEmpty()) {              
        int v = StdIn.readInt();              
        int w = StdIn.readInt();              
        int length   = sap.length(v, w);              
        int ancestor = sap.ancestor(v, w);              
        StdOut.printf("length = %d, ancestor = %d\n", length, ancestor); 
    } 
}
}