import java.util.ArrayList;
/**
 * Class that contains and manages catalogue of auction lots
 * 
 * @author jf
 * @version 07.3.2016
 *
 */
public class Catalogue
{
    ArrayList<Lot> lots;

    /**
     * Constructs a catalogue object
     * Initializes the Lot list field
     */
    public Catalogue()
    {
        lots = new ArrayList<Lot>();
    }

    /**
     * Adds a Lot object to list of lots field
     * @param lot The Lot object being added
     */
    public void addLot(Lot lot)
    {
        lots.add(lot);
    }

    /**
     * Constructs a string representation of this object
     * @return string representation of this object
     */
    public String toString()
    { 
        String details = "";
        for (Lot lot : lots)
        {
            details += lot + "\n";
        }
        return details;
    } 
}