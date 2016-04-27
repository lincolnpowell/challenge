/**
 * Lincoln C. Powell III
 * April 27, 2016
 * 
 * Customer.java
 * 
 * This class simulates a customer, holding various data such as their
 * name, ticket demand, line number, and purchased tickets.
 */
import java.util.Random;

public class Customer {
    /*
    Create a Random class object.
    */
    Random randomNumber = new Random();
    
    /*
    Declare variables to hold information pertaining to the customer.
    */
    private String name;
    private int demand, customerNumber;
    
    /*
    Declare Ticket array to hold purchased tickets.
    */
    Ticket[] tickets;
    
    /*
    No-args constructor that initializes name field with randomly
    generated name, demand field with random number 1 - 5 representing
    how many tickets the customer wants to buy, and Ticket array with demand
    value as size of the array.
    */
    Customer(){
        name = NameGenerator.getRandomName();
        demand = randomNumber.nextInt(5) + 1;
        tickets = new Ticket[demand];
    }//end no-args constructor
    
    /*
    Accessor/mutator methods.
    */
    String getName()                    {return name;}
    int getDemand()                     {return demand;}
    int getCustomerNumber()             {return customerNumber;}
    void setCustomerNumber(int number)  {customerNumber = number;}
}//end class Customer