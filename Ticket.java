/**
 * Lincoln C. Powell III
 * April 27, 2016
 * 
 * Ticket.java
 * 
 * This class simulates a ticket drawn from a lottery machine, holding various
 * data such as its type and number.
 */
public class Ticket {
    /*
    Declare or declare and initialize variables to hold information
    pertaining to the ticket.
    */
    private String type = "";
    private int number;
    
    /*
    No-args constructor; used when initializing fields using standalone
    mutator methods.
    */
    Ticket(){}
    
    /*
    Loaded constructor requiring String type and integer number values as
    arguments; this constructor initializes fields using passed parameters.
    */
    Ticket(String type, int number){
        this.type = type;
        this.number = number;
    }//end loaded constructor(String, int)
    
    /*
    Accessor/mutator methods.
    */
    String getType()    {return type;}
    int getNumber()     {return number;}
    void setNumber(int number)  {this.number = number;}
    void setType(String type)   {this.type = type;}
}//end class Ticket