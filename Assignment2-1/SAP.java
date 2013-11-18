public class SAP{
private Digraph digraph;
private boolean[] marked;

// constructor takes a digraph (not necessarily a DAG)     
public SAP(Digraph G)     
{
    digraph = G;//.copy();
    marked = new  boolean[G.V()];
}
// length of shortest ancestral path between v and w; -1 if no such path     

public int length(int v, int w)      
{
     BreadthFirstDirectedPaths bfdp = new BreadthFirstDirectedPaths(digraph, w); 
     BreadthFirstDirectedPaths bfdp1 = new BreadthFirstDirectedPaths(digraph, v);
     int dist;
     for(int i =0; i<digraph.V(); i++){
         if(bfpd.hasPathTo(i)&&bfdp1.hasPathTo(i))
         {
             //get dist 1
             int l = bfpd.distTo(i) + bfpd1.distTo(i);
             
         }
     }
    return alength(v,v,w,true);
    
}

private int alength(int s, int v, int w, boolean length)
{
    System.out.println("s "+s + " v "  +v + " w " + w +  " l " + length );
    BreadthFirstDirectedPaths bfdp = new BreadthFirstDirectedPaths(digraph, w);
    if(bfdp.hasPathTo(v)){
        
        // get path from s to v and from w to v
        int l1 = bfdp.distTo(s);
        int l2 = bfdp.distTo(w);
        
        if(length){
        int l = l1+l2;
        System.out.println("L1 " +l1 + " l2 "+l2);
            return l;
        }else{
            return v;
        }
    }
   
    for(int i: digraph.adj(v)){
        if(!marked[i]){
            marked[i] = true;
            alength(s,i,w,length);
        }        
    }
    return -1;
}




// a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path     
public int ancestor(int v, int w)          
{
   return alength(v,v,w,false);
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
     
//     BreadthFirstDirectedPaths bfdp = new BreadthFirstDirectedPaths(digraph, v);
//     //we need to loop through
//     for(Integer a : w){
//         bfdp.hasPathTo(a.intValue()){
//             //return
//         return bfdp.
//         }
//     }
//     

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