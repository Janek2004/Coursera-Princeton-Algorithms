import java.util.Arrays;
public class Percolation {
   private int[][] grid;
   //1 open 0 closed

   public Percolation(int N)              // create N-by-N grid, with all sites blocked
   {
      grid = new int[N][N];
      
       for (int i=0;i<N;i++)
       {
           for (int j=0;j<N;j++)
           {
               grid[i][j]=0; 
           }   
       }
   }
   
   public void open(int i, int j)         // open site (row i, column j) if it is not already
   {
       if(!isOpen(i,j))
       {
         grid[i-1][j-1] = 1;  
       }
   }
       
   public boolean isOpen(int i, int j)    // is site (row i, column j) open?
   {
       
       return  grid[i-1][j-1] == 0;
   }
   public boolean isFull(int i, int j)    // is site (row i, column j) full?
   {
      return  grid[i-1][j-1] == 1; 
   }
   public boolean percolates()            // does the system percolate?
   {

       
       return true;
   }

}


