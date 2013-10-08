import java.util.Random;

public class PercolationTester{
public static void main(String [] args)
   {
    int N = 20;
       Percolation p = new Percolation(N);
       boolean check = true;
       int counter = 0;
       Random rand = new Random();
       
       while(check)
       {         
           int k = rand.nextInt(N) + 1;
           int j = rand.nextInt(N) + 1;

//           if(!p.isOpen(k,j)){
//               p.open(k,j);
//               counter ++;
//           }
           
           System.out.println(k+ " " + j);
           
           if(p.percolates())
           {
               check = false;
              // System.out.println("True Counter is "+(counter*1.0) / (N*N*1.0);
           }
           
           if(counter >1000)
           {
               check = false;
               System.out.println("False Counter is "+counter);
           }
       }  
       
 ;
}
}