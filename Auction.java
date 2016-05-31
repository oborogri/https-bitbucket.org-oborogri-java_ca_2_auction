import java.util.ArrayList;
import java.util.HashMap;
/**
 * Class to manage an auction
 * Accepts bids
 * Runs auction
 * Creates collection winning bids
 * Reports on status particular bid
 * 
 * @author jf 
 * @version 07.3.2016
 *
 */
public class Auction
{
    // a map of lists of bids
    // a list of bids exists for each lot
    // the map key is the lotId integer value in Integer wrapper
    // the value is the arraylist of bids for a specific lot
    private HashMap<Integer, ArrayList<Bid>> bids;
    // a list of winning bids
    private ArrayList<Bid> winningBids;
    // this flag indicates if the auction is open for bidding or not
    boolean biddingOpen;

    /**
     * This is the connstructor method for Auction instance
     */
    public Auction(Catalogue catalogue)
    {
        // bidding is set to closed by default
        biddingOpen = false;
        bids = new HashMap<Integer, ArrayList<Bid>>();
        winningBids = new ArrayList<Bid>();
    }

    /**
     * allow bidding
     */
    public void openBidding()
    {
        biddingOpen = true;
    }

    /**
     * no further bids accepted
     */
    public void closeBidding()
    {  
        biddingOpen = false;
    }

    /**
     * The auction comprises a check on all bids
     * Winning bid is second highest for each lot
     * Traverse map of bids
     * Sort each array list of bids (corresponding to each lot)
     * And sell to second highest bid
     */
    public void holdAuction()
    {
        for (Integer key : bids.keySet())
        {
            ArrayList<Bid> listBids = bids.get(key);

            //SelectSort may be used to sort bids
            //SelectSort.sort(listBids);
            
            MergeSortBids.sort(listBids);
            //using the sort() method from refactored class MegeSortBids 
            
            // winning bid is the second highest bid amount in listBids 
            Bid winningBid = listBids.get(listBids.size() -2);
            
            //adds winning bid to winningBids ArrayList
            winningBids.add(winningBid);  
        }
    } 

    /**
     * Submit a bid
     * The method adds the bid to the map of bids
     * The map key is the number of the lot being bid for
     * The corresponding map value is the array list of bids associated with that key
     * 
     * @param bid The bid being submitted
     * @return true if the bid accepted else false
     */
    public boolean submitBid(Bid bid)
    {
        if (biddingOpen == false)
        {
            System.out.println("Bid not accepted: bidding closed");
            return false;
        }

        Integer key = bid.lot.lotId;
        ArrayList<Bid> listBids = bids.get(key);
        if (listBids == null)
        {
            listBids = new ArrayList<Bid>();
        }
        listBids.add(bid);
        bids.put(key, listBids);
        return true;
    }

    /**
     * Checks if a particular person won the auction for particular lot
     * Traverse all winning bids
     * Search for match of lotId and person in each element of winning bids list
     * 
     * @param lotId The id of the lot in question
     * @param person The person whose bid is being checked
     * @return True if the person's bid successful else return false
     */
    public boolean status(int lotId, Person person)
    {
        for (Bid bid : winningBids)
        {
            if (bid.lot.lotId == lotId && bid.bidder == person)
            //checks if this winning bid made by parameter person
                return true;
        }
        return false;
    }

    /**
     * Constructs string representation of object
     * @return string representation of this object
     */
    public String toString()
    {
        String details = "Auction";
        for (Integer key : bids.keySet())
        {
            details += "\nLot key : " + key + "\n";
            ArrayList<Bid> listBids = bids.get(key);
            for (Bid bid : listBids)
            {
                details += bid;
            }
        }     
        details += "\n" + "Winning bids \n" + detailsWinningBids();
        return details;
    }

    /*
     * Helper method for toString method
     * @return
     */
    private String detailsWinningBids()
    {
        String details = new String();
        for (Bid bid : winningBids)
        {
            details += bid;
        }
        return details;
    }
}