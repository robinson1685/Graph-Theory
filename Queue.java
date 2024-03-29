// QueueApp.java
// demonstrates queue
// to run this program: C>java QueueApp
import java.io.*;                 // for I/O
////////////////////////////////////////////////////////////////
class Queue
   {
   private int maxSize;
   private int[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public Queue(int s)         // constructor
      {
      maxSize = s;
      queArray = new int[maxSize];
      front = 0;
      rear = -1;      // Since queArray is initially empty
      nItems = 0;
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public void insert(int j)   // put item at rear of queue
   {
      if (isFull()) {
         System.out.print("ERROR -- QUEUE OVERFLOW");
      }
      else {
        if(rear == maxSize-1)         // deal with wraparound
           rear = -1;
        rear = rear + 1;
        queArray[rear] = j;           // increment rear and insert
        nItems++;                     // one more item
      }
   }
//--------------------------------------------------------------
   public int remove()         // take item from front of queue
   {

      if (isEmpty()) {
         System.out.print("ERROR -- QUEUE UNDERFLOW");
         return -1;
      }
      else {
        int temp = queArray[front];   // get value and incr front
        front = front + 1;
        if(front == maxSize)          // deal with wraparound
           front = 0;
        nItems--;                     // one less item
        return temp;
      }
   }
//--------------------------------------------------------------
   public int peekFront()      // peek at front of queue
      {
      return queArray[front];
      }

//--------------------------------------------------------------
   public int size()           // number of items in queue
      {
      return nItems;
      }
//--------------------------------------------------------------
   }  // end class Queue
////////////////////////////////////////////////////////////////
class QueueApp
   {
   public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);  // queue holds 5 items
      int x;

      theQueue.insert(10);            // insert 4 items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);

      x=theQueue.remove();              // remove 3 items
      x=theQueue.remove();              //    (10, 20, 30)
      x=theQueue.remove();

      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);

      while( !theQueue.isEmpty() )    // remove and display
         {                            //    all items
         int n = theQueue.remove();   // (40, 50, 60, 70, 80)
         System.out.print(n);
         System.out.print(" ");
         }
      System.out.println("");
      }  // end main()
   }  // end class QueueApp
