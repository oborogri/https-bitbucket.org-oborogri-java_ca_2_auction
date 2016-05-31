/**
 * Class contains personal details of person
 * 
 * @author jf
 * @version 07.3.2016
 *
 */
public class Person
{
    private final String firstName;
    private final String lastName;
    String email;

    private int pin;
    /**
     * Construct Person object
     * @param firstName
     * @param lastName
     * @param email
     * @param pin
     */
    public Person(String firstName, String lastName, String email, int pin)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        if (Util.validEmail(email)) {   
            this.email = email;
        }

        if (Util.validPin(pin)) {
            this.pin = pin;
        }
        else {
            this.pin = Util.generatePin();
            System.out.println("You have submitted an invalid pin");
            System.out.println("Here is a temporary pin: " + this.pin);
            System.out.println("Please change as soon as possible");
        }
    }

    /**
     * Accessor for pin number
     * @return The pin number
     */
    public int getPin()
    {
        return pin;
    }

    /**
     * Generates a String representation of Person object
     * @return The string representation of Person object
     */
    public String toString()
    {
        return "Full name: " + firstName + " " + lastName + " : Email : " + email;
    }
}
