/**
 * An unchecked exception that is thrown when there is an invalid Pet
 * A pet is invalid if it is neither a Dog or a Cat
 */
public class InvalidPetException extends RuntimeException {

    /**
     * Creates an InvalidPetException with the default message
     */
    public InvalidPetException() {
        super("Your pet is invalid!");
    }

    /**
     * Creates an InvalidPetException with a specified error message
     * 
     * @param s a string that represents the error message
     */
    public InvalidPetException(String s) {
        super(s);
    }
}
