/**
 * Lincoln C. Powell III
 * April 27, 2016
 * 
 * LotteryMachine.java
 * 
 * This class simulates a lottery machine that is capable of producing Pick 3,
 * Pick 4, or Pick 5 tickets.
 */
import java.util.Random;

public class LotteryMachine {
    /*
    Create a Random class object.
    */
    Random randomNumber = new Random();
    
    /*
    Declare two integer variables:
    1. customerChoice will hold the random value 1 - 3 to mimic the customer
    deciding which ticket to purchase.
    2. pointer will hold a random integer number from the randomNumber Random
    object; pointer is very crucial variable in latter parts of this class
    as a placeholder for the random number.
    */
    private int customerChoice, pointer;
    
    /*
    Declare and initialize variables holding the current total amount of
    tickets per type (e.g. Pick 3, Pick 4, and Pick 5).
    */
    private int pick3_Total = 50;
    private int pick4_Total = 40;
    private int pick5_Total = 60;
    
    /*
    Declare and initialize Ticket arrays to hold tickets.
    */
    private Ticket[] pick3 = new Ticket[50];
    private Ticket[] pick4 = new Ticket[40];
    private Ticket[] pick5 = new Ticket[60];
    
    /*
    Declare integer variables for storing the winner ticket number for each
    ticket type.
    */
    private int pick3_Winner;
    private int pick4_Winner;
    private int pick5_Winner;
    
    /*
    No-args constructor that initializes each type Ticket array, picks an
    index value within each array and initializes the respective winner
    variable (e.g. pick3_Winner, for example) with the winning ticket number.
    */
    LotteryMachine(){
        pick3 = loadTickets(pick3, 1000, "Pick 3");
        pointer = randomNumber.nextInt(50);
        pick3_Winner = pick3[pointer].getNumber();
        
        pick4 = loadTickets(pick4, 10000, "Pick 4");
        pointer = randomNumber.nextInt(40);
        pick4_Winner = pick4[pointer].getNumber();
        
        pick5 = loadTickets(pick5, 100000, "Pick 5");
        pointer = randomNumber.nextInt(60);
        pick5_Winner = pick5[pointer].getNumber();
    }//end no-args constructor
    
    /*
    Accessor methods for private fields.
    */
    int getPick3_Total()    {return pick3_Total;}
    int getPick4_Total()    {return pick4_Total;}
    int getPick5_Total()    {return pick5_Total;}
    int getPick3_Winner()   {return pick3_Winner;}
    int getPick4_Winner()   {return pick4_Winner;}
    int getPick5_Winner()   {return pick5_Winner;}
    
    /*
    This method takes an array, its size, and an integer representing the
    index number to skip as passed parameters and copies the passed array into
    a new array.  The new array is one size smaller than the passed array.  
    Additionally, when the for loop eachs the index number to skip, the element
    in the passed array is not copied into the new array. Finally, the new
    array is returned.
    
    This method is important to simulate within the lottery machine that
    tickets are being withdrawn, thus emptying type Ticket array by the element
    chosen by the customer.
    */
    Ticket[] shrinkArray(Ticket[] oldArray, int size, int skipElement){
        Ticket[] newArray = new Ticket[size - 1];
        for (int i = 0, j = 0; i < newArray.length; i++, j++){
            if (i == skipElement){
                j++;
            }//end if
            newArray[i] = oldArray[j];
        }//end for
        return newArray;
    }//end shrinkArray method
    
    /*
    This method takes an array, an integer value representing the upper limit
    to the generated number's range, and a String representing the Ticket's
    type (e.g. Pick 3, Pick 4, or Pick 5) as passed parameters and loads each 
    element of the passed array with a Ticket object, passing the Ticket type
    and a random number from 0 to the upper limit cap representing the ticket
    number.
    
    This method scans the array each iteration within the inner for loop to
    find instances where ticket number duplication exists. If duplication
    exists, the ticket number at the current iteration, i, is changed to a new
    number.
    */
    Ticket[] loadTickets(Ticket[] array, int cap, String type){
        for (int i = 0; i < array.length; i++){
            array[i] = new Ticket(type, randomNumber.nextInt(cap));
            for (int j = 0; j < array.length; j++){
                if (i != j && array[i] == array[j]){
                    array[i].setNumber(randomNumber.nextInt(cap));
                }//end if
            }//end for
        }//end for
        return array;
    }//end loadTickets method
    
    /*
    This method simualates the purchasing of a ticket from the lottery machine.
    
    This method takes a String representing the customer's name and their
    demand, representing how many tickets the customer wants to buy, as passed
    parameters.
    
    A new Ticket array is created, setting each element's Ticket object ticket
    number to -1 to represent a non-existing ticket.
    
    Then, while the customer's demand is not 0, a variable customerChoice, 
    simulates the customer's selection of ticket type to buy.
    
    If the ticket type has remaining tickets, the lottery machine will give the
    customer a ticket and then simulate the withdrawal of a ticket from the
    machine of the respective Ticket array.
    
    If the ticket type does not have any remaining tickets, the while loop will
    continue to iterate, trying to purchase tickets until the customer's demand
    value level reaches 0.  Additionally, details will be included in the
    report that the customer attempted to purchase sold out ticket types.
    
    If the sum of all Ticket type arrays equal zero, the current Ticket
    array will be returned; likewise, if the demand equals 0, the Ticket array
    is returned.
    */
    Ticket[] purchaseTickets(String name, int demand){
        Ticket[] array = new Ticket[demand];
        for (int i = 0; i < array.length; i++){
            array[i] = new Ticket();
            array[i].setNumber(-1);
        }//end for
        int i = 0;
        do{
            customerChoice = randomNumber.nextInt(3) + 1;
            switch(customerChoice){
                case 1:
                    if (pick3_Total > 0){
                        BuildProgram.jta.append(name + " purchases a Pick 3 ticket!");
                        BuildProgram.jta.append(" The lottery machince currently has " + (pick3_Total - 1) + " Pick 3 tickets left!\n");
                        pointer = randomNumber.nextInt(pick3_Total);
                        array[i].setNumber(pick3[pointer].getNumber());
                        array[i].setType("Pick 3");
                        pick3 = shrinkArray(pick3, pick3.length, pointer);
                        pick3_Total--;
                        demand--;
                        i++;
                        break;
                    }//end if
                    else{
                        BuildProgram.jta.append(name + " tries to purchase Pick 3 tickets but they are sold out!\n");
                        break;
                    }//end else
                case 2:
                    if (pick4_Total > 0){
                        BuildProgram.jta.append(name + " purchases a Pick 4 ticket!");
                        BuildProgram.jta.append(" The lottery machince currently has " + (pick4_Total - 1) + " Pick 4 tickets left!\n");
                        pointer = randomNumber.nextInt(pick4_Total);
                        array[i].setNumber(pick4[pointer].getNumber());
                        array[i].setType("Pick 4");
                        pick4 = shrinkArray(pick4, pick4.length, pointer);
                        pick4_Total--;
                        demand--;
                        i++;
                        break;
                    }//end if
                    else{
                        BuildProgram.jta.append(name + " tries to purchase Pick 4 tickets but they are sold out!\n");
                        break;
                    }//end else
                case 3:
                    if (pick5_Total > 0){
                        BuildProgram.jta.append(name + " purchases a Pick 5 ticket!");
                        BuildProgram.jta.append(" The lottery machince currently has " + (pick5_Total - 1) + " Pick 5 tickets left!\n");
                        pointer = randomNumber.nextInt(pick5_Total);
                        array[i].setNumber(pick5[pointer].getNumber());
                        array[i].setType("Pick 5");
                        pick5 = shrinkArray(pick5, pick5.length, pointer);
                        pick5_Total--;
                        demand--;
                        i++;
                        break;
                    }//end if
                    else{
                        BuildProgram.jta.append(name + " tries to purchase Pick 5 tickets but they are sold out!\n");
                        break;
                    }//end else
            }//end switch on customerChoice
            if (pick3_Total + pick4_Total + pick5_Total == 0)
                return array;
        } while (demand != 0);
        return array;
    }//end purchaseTickets method
    
    /*
    String method representing the LotteryMachine object's Ticket array states
    for each type.
    */
    @Override
    public String toString(){
        String string = "";
        string += "Pick 3: ";
        for (int i = 0; i < pick3.length; i++){
            string += "[" + (i + 1) + "] " + pick3[i].getNumber() + " ";
        }//end for
        string += "\nPick 4: ";
        for (int i = 0; i < pick4.length; i++){
            string += "[" + (i + 1) + "] " + pick4[i].getNumber() + " ";
        }//end for
        string += "\nPick 5: ";
        for (int i = 0; i < pick5.length; i++){
            string += "[" + (i + 1) + "] " + pick5[i].getNumber() + " ";
        }//end for
        string += "\n";
        return string;
    }//end toString method
}//end class LotteryMachine