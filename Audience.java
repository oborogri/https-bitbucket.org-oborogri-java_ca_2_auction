import java.util.HashSet;
/**
 * Class to manage an audience
 * Has set of people and methods to register and authenticate new members
 * 
 * @author jf
 * @version 14.3.2015
 *
 */
public class Audience
{
    // a set of people, the members of the audience
    // a set has been chosen to ensure duplicate registration does not occur
    HashSet<Person> members;

    /**
     * Constructs an Audience object
     * Initializes the members field
     */
    public Audience()
    {
        members = new HashSet<>();
    }

    /**
     * Registers a person as a member of the audience
     * @param person an instance of Person register as member of members
     * @return returns true if the person successfully added to set else false
     */
    public boolean register(Person person)
    { 
        //add the parameter person to the set of members returning true if addition successful 
        //if person already registered prints a warning message
        if(isRegistered(person)) {
            System.out.println("This person is already registered");
        }
        return members.add(person);
    }

    /**
     * Authenticates a person is a member of the audience
     * @param person The person being authenticated
     * @return Returns true if the person is a member of the audiemembersnce otherwise returns false.
     */
    public boolean isRegistered(Person person)
    {
        // return true of the set of members contains the parameter person otherwise return false
        return members.contains(person);       
    }

    /**
     * Authenticates person is member of audience 
     * Information provided is email and pin
     * @param email The email address of person being authenticated
     * @param pin The pin number of person being authenticated
     * @return Returns true if the person is a member of the audience otherwise returns false.
     */
    public Person isRegistered(String email, int pin)
    {
        for (Person person : members)
        {
            //check if the person represented by email and pin is present in the set of members
            if (person.email == email && person.getPin() == pin)
                return person;
        }
        return null;
    }
}