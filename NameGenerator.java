/**
 * Lincoln C. Powell III
 * April 27, 2016
 * 
 * NameGenerator.java
 * 
 * This class creates a customer's name using two String arrays representing
 * first and last names.
 */
import java.util.Random;

public class NameGenerator {
    /*
    Declare static integer pointer as a placeholder for a randomly
    generated number.
    */
    static private int pointer;
    
    /*
    Declare and initialize a static String array of first names.
    */
    static String[] firstName = {
        "Leroy", "James", "John", "Robert", "Sean",
        "Nathan", "Andrew", "Jesse", "Ross", "Gregory",
        "Josh", "Jacob", "Jamal", "Malcolm", "Reese",
        "Dewey", "Francis", "Hal", "Jack", "Humphrey",
        "Mario", "Lincoln", "Christopher", "Brandon", "Anthony",
        "Sophie", "Emma", "Patience", "Rose", "Scarlett",
        "Reshelle", "Ann", "Olivia", "Mary", "Emily",
        "Lily", "Chloe", "Ashley", "Jessica", "Isabella",
        "Janet", "Ava", "Megan", "Kaylee", "Jennifer",
        "Sarah", "Victoria", "Natalie", "Lauren", "Camille"
    };
    
    /*
    Declare and initialize a static String array of last names.
    */
    static String[] lastName = {
        "Smith", "Johnson", "Williams", "Jones", "Brown",
        "Davis", "Miller", "Wilson", "Moore", "Taylor",
        "Anderson", "Thomas", "Jackson", "White", "Harris",
        "Martin", "Thompson", "Garcia", "Martinez", "Robinson",
        "Clark", "Rodriguez", "Lewis", "Lee", "Walker",
        "Hall", "Allen", "Young", "Hernandez", "Powell",
        "King", "Wright", "Lopez", "Hill", "Scott", "Green",
        "Adams", "Baker", "Shelton", "Gonzalez", "Nelson",
        "Mitchell", "Perez", "Roberts", "Turner", "Campbell",
        "Parker", "Wood", "Jenkins", "Long", "Peterson"
    };
    
    /*
    This method returns a string consisting of the concatenation of two
    strings, one string from the firstName string array and the second string
    from the lastName string array.  The pointer variable is used as an index
    to randomly select a name element within each array.
    */
    static String getRandomName(){
        String name = "";
        Random randomNumber = new Random();
        pointer = randomNumber.nextInt(50);
        name += firstName[pointer] + " ";
        pointer = randomNumber.nextInt(50);
        name += lastName[pointer];
        return name;        
    }//end getRandomName method
}//end class NameGenerator