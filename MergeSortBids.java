import java.util.ArrayList;
public class MergeSortBids
{
    static Bid[]aux;    
    // a primitive array of type Bids used te temporary store bids to be sorted 
    private static void merge(ArrayList<Bid> a, int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
        {
            //populating the array aux with bid objects to be sorted from ArayList<Bid> a
            aux[k] = a.get(k);
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++)
        {
            //loop through the array and replace bids into the arrayList in ascending order
            if (i > mid)               a.set(k, aux[j++]); 
            else if (j > hi )          a.set(k, aux[i++]); 
            else if (aux[j].amountBid < aux[i].amountBid)  a.set(k, aux[j++]);
            else                       a.set(k, aux[i++]); 
        }
    }

    public static void sort(ArrayList<Bid> a)
    {
        aux = new Bid[a.size()];
        // a new primitive array of type Bid is created  
        int N = a.size();
        // merge the elements back into the ArrayList<Bid>a in ascending order 
        for (int size = 1; size < N; size = size + size)
        {
            for (int lo = 0; lo < N - size; lo += size + size)
            {
                merge(a, lo, lo + size - 1, Math.min(lo + size + size - 1, N - 1));
            }
        }
    }

    public static void print (ArrayList<Bid> a)
    {
       // a method to print sorted ArrayList<Bid> a
        for (Bid i : a)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
