/**
 * Lincoln C. Powell III
 * April 27, 2016
 * 
 * BuildProgram.java
 * 
 * This program houses the main method for program initialization and method
 * for GUI creation for displaying the report details of the Lottery Machine
 * program.
 */
import java.awt.BorderLayout;
import javax.swing.*;

public class BuildProgram extends JFrame { 
    /*
    Declare and initialize a static JTextArea for displaying details of the
    report for the end user.
    */
    static JTextArea jta = new JTextArea();
    
    /*
    No-args constructor to build GUI.
    */
    public BuildProgram(){
        setTitle("Lottery Machine Simulation Program");
        setSize(1800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);
        validate();
    }//end no-args constructor
    
    /*
    Main method for program initialization.
    */
    public static void main(String[] args){
        //Build GUI.
        BuildProgram display = new BuildProgram();
        
        //Create a LotteryMachine object.
        LotteryMachine lotto = new LotteryMachine();
        
        /*
        Create a Customer array with 150 elements; the lottery machine holds
        150 tickets in total, if each customer purchases only 1 ticket, it
        would take 150 customers to deplete lottery machine.
        */
        Customer[] customers = new Customer[150];
        
        //Create arrays to hold data pertaining to the lotto winners.
        String[] winners = new String[3];
        int[] winnerCustomerNumber = new int[3];

        //Initialize index variable i to 0 for while loop.
        int i = 0;
        
        /*
        While the sum of each Ticket type array of the LotteryMachine object
        is not 0:
        
        - display the current state of the tickets within the lottery machine
        - create a Customer object within Customer array at index i
        - set Customer line number to (i + 1)
        - purchase tickets for Customer object, returning Ticket array from
        LotteryMachine.purchaseTickets(String : name, int : demand) to
        Customer.tickets Ticket array
        - display all customer's purchased tickets; if the number the number
        of the ticket is -1, that ticket does not exist
        */
        while (lotto.getPick3_Total() + lotto.getPick4_Total() + lotto.getPick5_Total() != 0){
            jta.append("The lottery machine currently holds the following tickets ([index] ticket number):\n\n" + lotto.toString() + "\n");
            customers[i] = new Customer();
            customers[i].setCustomerNumber(i + 1);
            jta.append("Customer number " + (i + 1) + ", " + customers[i].getName() + ", wants to purchase tickets " + customers[i].getDemand() + " tickets!\n");
            customers[i].tickets = lotto.purchaseTickets(customers[i].getName(), customers[i].getDemand());
            jta.append("\n" + customers[i].getName() + " purchased the following tickets:\n");
            for (int j = 0; j < customers[i].tickets.length; j++){
                if (customers[i].tickets[j].getNumber() != -1){
                    jta.append(customers[i].tickets[j].getType() + " ticket: " + customers[i].tickets[j].getNumber() + "\n");
                }//end if
            }//end for
            jta.append("\n");
            i++;
        }//end while
        
        /*
        Add in report that the lottery machine is fully depleted, how many
        customers purchased tickets, and which numbers were selected during the
        drawning.
        */
        jta.append("The lottery machine is sold out! It's time for the drawing!\n");
        jta.append(i + " customers purchased tickets and are anxiously waiting for their ticket numbers to be called!\n\n");
        jta.append("The winning Pick 3 lottery ticket is: " + lotto.getPick3_Winner() + "\n");
        jta.append("The winning Pick 4 lottery ticket is: " + lotto.getPick4_Winner() + "\n");
        jta.append("The winning Pick 5 lottery ticket is: " + lotto.getPick5_Winner() + "\n\n");
        
        /*
        For each customer that purchased tickets, for each ticket purchased,
        if the customer's ticket matches the selected winning ticket for each
        type, assign the respective arrays with the customer information for
        display.
        */
        for (int m = 0; m < i; m++){
            for (int n = 0; n < customers[m].tickets.length; n++){
                if (customers[m].tickets[n].getNumber() == lotto.getPick3_Winner() &&
                        customers[m].tickets[n].getType().equals("Pick 3")){
                    winners[0] = customers[m].getName();
                    winnerCustomerNumber[0] = customers[m].getCustomerNumber();
                }//end if
                if (customers[m].tickets[n].getNumber() == lotto.getPick4_Winner() &&
                        customers[m].tickets[n].getType().equals("Pick 4")){
                    winners[1] = customers[m].getName();
                    winnerCustomerNumber[1] = customers[m].getCustomerNumber();
                }//end if
                if (customers[m].tickets[n].getNumber() == lotto.getPick5_Winner() &&
                        customers[m].tickets[n].getType().equals("Pick 5")){
                    winners[2] = customers[m].getName();
                    winnerCustomerNumber[2] = customers[m].getCustomerNumber();
                }//end if
            }//end for
        }//end for
        
        /*
        Display which customers won the drawing for each ticket type.
        */
        jta.append("The winner of the Pick 3 lottery is customer number " + winnerCustomerNumber[0] + ", " + winners[0] + "!\n");
        jta.append("The winner of the Pick 4 lottery is customer number " + winnerCustomerNumber[1] + ", " + winners[1] + "!\n");
        jta.append("The winner of the Pick 5 lottery is customer number " + winnerCustomerNumber[2] + ", " + winners[2] + "!");
    }//end main method
}//end BuildProgram class