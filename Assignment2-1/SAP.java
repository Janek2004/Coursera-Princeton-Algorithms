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
   
     int dist=-1;
     for(int i =0; i<digraph.V(); i++){
         if(bfdp.hasPathTo(i)&&bfdp1.hasPathTo(i))
         {

             int l = bfdp.distTo(i) + bfdp1.distTo(i);
             if(dist==-1){
                 dist = l;
             }
             if(l<dist) dist =l;
         }
     } 
    return dist;
    
}


// a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path     
public int ancestor(int v, int w)          
{
     BreadthFirstDirectedPaths bfdp = new BreadthFirstDirectedPaths(digraph, w); 
     BreadthFirstDirectedPaths bfdp1 = new BreadthFirstDirectedPaths(digraph, v);
   
     int dist=-1;
     int ancestor = -1;
     for(int i =0; i<digraph.V(); i++){
          System.out.println("v "+v + " " + w + " "+ i);
         if(bfdp.hasPathTo(i)&&bfdp1.hasPathTo(i))
         {
             int l = bfdp.distTo(i) + bfdp1.distTo(i);
             if(dist==-1) {dist =l;} 
             if(l<dist) {
                 dist =l;
                 ancestor = i;
             }
         }
     } 
    return ancestor;
}

// length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path 
public int length(Iterable<Integer> v, Iterable<Integer> w)
{
     BreadthFirstDirectedPaths bfdp = new BreadthFirstDirectedPaths(digraph, w); 
     BreadthFirstDirectedPaths bfdp1 = new BreadthFirstDirectedPaths(digraph, v);
   
     int dist=-1;
     for(int i =0; i<digraph.V(); i++){
         if(bfdp.hasPathTo(i)&&bfdp1.hasPathTo(i))
         {

             int l = bfdp.distTo(i) + bfdp1.distTo(i);
             if(dist==-1){
                 dist = l;
             }
             if(l<dist) dist =l;
         }
     } 
    return dist;
}
// a common ancestor that participates in shortest ancestral path; -1 if no such path   
 public int ancestor(Iterable<Integer> v, Iterable<Integer> w)     
 {
     BreadthFirstDirectedPaths bfdp = new BreadthFirstDirectedPaths(digraph, w); 
     BreadthFirstDirectedPaths bfdp1 = new BreadthFirstDirectedPaths(digraph, v);
   
     int dist=-1;
     int ancestor = -1;
     for(int i =0; i<digraph.V(); i++){
         if(bfdp.hasPathTo(i)&&bfdp1.hasPathTo(i))
         {
             int l = bfdp.distTo(i) + bfdp1.distTo(i);
             if(dist==-1) {dist =l;} 
             if(l<dist) {
                 dist =l;
                 ancestor = i;
             }
         }
     } 
    return ancestor;
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