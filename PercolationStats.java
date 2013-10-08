public class PercolationStats
{

    private int currentT;
    private int T;
    private int N;
    
    private float[] xt;
    
    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T)
    {
        T = T;
        currentT=0;
        N = N;
        xt = new float[T];
       Percolation p = new Percolation();
        for(int i=0;i<N;i++){
            int k = StdRandom.random()*N;
//            if(!p.isOpen())
//            {
//                p.open();
//            }
            
        }
        
        
    }

    // sample mean of percolation threshold
    public double mean()
    {
        return 0.0;
    }

    // sample standard deviation of percolation threshold
    public double stddev()
    {
        return 0.0;
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo()
    {
        return 0.0;
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi()
    {
        return 0.0;
    }
}
