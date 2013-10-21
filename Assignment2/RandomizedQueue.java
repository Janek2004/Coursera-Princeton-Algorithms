import java.util.Iterator;
public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item items[];
    private int size;
    private int lastIndex = 0;
    public RandomizedQueue() {
        size = 0;
        items = (Item[]) new Object[2];
        lastIndex =0;
    }          // construct an empty randomized queue

// is the queue empty?
    public boolean isEmpty(){
    
        return size==0;
    }           

    public int size() {

        return size;
    }   // return the number of items on the queue
    
    public void enqueue(Item item){// add the item
        if(item==null){
          throw new java.lang.NullPointerException();
        }
     //resize the array        
     if(size == items.length){
         resize(2*size);
         
     }

     items[lastIndex] = item;
     lastIndex++;   
     size++;

    } 

    private void resize(int newSize){

        int index =0;
        Item newitems[] = (Item[]) new Object[newSize];

        for(int i = 0;i<items.length; i++)
           {
               if(items[i]!=null){
                  newitems[index] = items[i];
               }
           }
         items = newitems;
        
    }
    
    private void exchange(Item[] a, int i, int j) {
        if (i == j)
            return;
        Item swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    
    
    public Item dequeue(){ // delete and return a random item
      if(isEmpty()){
          throw new java.util.NoSuchElementException();
      }
        exchange(items, StdRandom.uniform(size), --size);
        Item result = items[size];
        items[size] = null;
      
        if (size * 4 < items.length && items.length > 1)
            resize(size/2);
        return result;

    }             
    public Item sample(){ // return (but do not delete) a random item
         if (size == 0)
            throw new java.util.NoSuchElementException("Empty queue");
         
        int N =items.length;
        int r = StdRandom.uniform(N);
        Item it = items[r]; 
        return it;
        
    }               
    
    

    public Iterator<Item> iterator()   // return an iterator over items in order from front to end
   {
   
       return new RandomizedQueueIterator();
   }

   private class RandomizedQueueIterator implements Iterator <Item>{

        private int[] idx;
        private int count = size;
        public RandomizedQueueIterator() {
            idx = new int[count];
            for (int i = 0; i < count; i++) {idx[i] = i;}
            StdRandom.shuffle(idx);
        }
    
       public boolean hasNext(){
           return --count==0;
       }
       
       public Item next(){
          if(!hasNext())
           {
               throw new java.util.NoSuchElementException();
           }
           System.out.println("A "+items[idx[--count]]);
           return items[idx[--count]];
  
       }
       public void remove(){
        throw new java.lang.UnsupportedOperationException();
       }
   }
       



public static void main(String[] args) {
     RandomizedQueue d = new RandomizedQueue();  
     System.out.println("Check if it is empty :"+d.isEmpty());
     d.enqueue(1);
      Iterator itr =d.iterator();
      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + " ");
      }
      
     System.out.println("Check if it is empty :"+d.isEmpty());
     d.dequeue();
     itr =d.iterator();
      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + " ");
      }
      
      
     System.out.println("Check if it is empty :"+d.isEmpty());
     d.enqueue(3);
     d.enqueue(5);
     d.enqueue(45);
     d.dequeue();
     
     System.out.println("Check if it is empty :"+d.isEmpty());
    itr =d.iterator();
      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + " ");
      }
   }

}




