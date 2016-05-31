/**
 * Class to manage bids
 * A bid comprises:
 * an item or lot being bid for
 * a bidder
 * an amount being bid or offered for the lot
 * 
 * @author jf
 * @version 07.3.2016
 *
 */
public class Bid
{
    Lot lot;
    Person bidder;
    final int amountBid;

    /**
     * 
     * @param lot the subject of the bid
     * @param bidder person bidding
     * @param amountBid amount bid for lot
     */
    public Bid(Lot lot, Person bidder, int amountBid)
    {
        this.lot = lot;
        this.bidder = bidder;
        this.amountBid = amountBid;     
    }

    /**
     * Accessor for amountBid field
     * @return The amount of this bid
     */
    public int getAmountBid()
    {
        return amountBid;
    }

    /**
     * Constructs a string representation of this object
     * @return string representation of this object
     */    
    public String toString()
    {
        return "Bid: bidder is " + bidder.email + " : amount bid is " + amountBid + ": Lot description " + lot.description + "\n";
    }
}