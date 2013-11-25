public class SeamCarver {
   private Picture picture;
   public SeamCarver(Picture _picture){
   picture = _picture;
   }
   public Picture picture()                       // current picture
   {
       return picture;
   }
   public     int width(
      return picture.width();
   )                         // width  of current picture
   public     int height()                        // height of current picture
   {
      return picture.height();
   }
   public  double energy(int x, int y)            // energy of pixel at column x and row y in current picture
   {
       //throw exception      
       if(x<0||y<0||x > height()||y>height())
       {
            
       }
            
       // Check for edge           
       if(x==0||y==0||y == height()||x== width())
       {
           return 195075;
       }   
       else{
           Color colorX1 = picture.get(x-1,y);
           Color colorX2 = picture.get(x+1,y);
           
           Color colorY1 = picture.get(x,y-1);
           Color colorY2 = picture.get(x,y+1);
           
           int rx = colorX2.getRed()-colorX1.getRed(); 
           int gx = colorX2.getGreen()-colorX1.getGreen();    
           int bx = colorX2.getBlue()-colorX1.getBlue();
 
           int ry = colorY2.getRed()-colorY1.getRed(); 
           int gy = colorY2.getGreen()-colorY1.getGreen();    
           int by = colorY2.getBlue()-colorY1.getBlue();
           
           int dx = rx* rx + gx*gx + bx*bx;
           int dy = yx* ry + gy*gy + by*by;
           
           int sum = dx + dy;
                  
       }
   }
       
   public   int[] findHorizontalSeam()            // sequence of indices for horizontal seam in current picture
   {
       return -1;
   }
   public   int[] findVerticalSeam()              // sequence of indices for vertical   seam in current picture
   {
       return -1;
   }
   public    void removeHorizontalSeam(int[] a)   // remove horizontal seam from current picture
   {
   
   }
   public    void removeVerticalSeam(int[] a)     // remove vertical   seam from current picture
   {
   
   }    
     
}