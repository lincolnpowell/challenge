How to run BuildProgram.java:

1. Use program such as Netbeans IDE or TextPad, or
2. Run Command Prompt or search cmd (or cmd.exe) and use the following instructions:

1. Save all .java files onto desktop
2. Type in "dir" without quotes to display the directory contents; you should see all five .java files among the files, if you do not see all .java files (e.g. BuildProgram.java, NameGenerator.java, LotteryMachine.java, Customer.java, and Ticket.java), please ensure all five files are saved in the same directory (use Desktop for convenience)
3. Type in "set path=%path%;C:\Program Files\Java\jdk1.8.0_65\bin" without quotes; use the JDK folder for the version installed on your system
4. Type in "javac BuildProgram.java" without quotes; you should see nothing but the next system prompt waiting for input
5. Type in "java BuildProgram" without quotes


How to test and verify results:

Once the program executes, a GUI window will popup displaying the result.

The top of the report will display line-by-line synopsis details of customers purchasing tickets.  This information also displays if customers attempted to purchase sold out ticket types and what type of tickets did each customer purchase.

To determine how many customers purchased tickets, you can locate the last customer in the synopsis OR read line displaying 
"XX customers purchased tickets and are anxiously waiting for their ticket numbers to be called!"

The next section displays which numbers were selected during the drawing.

The following section displays which customers won the drawing for each ticket type.
