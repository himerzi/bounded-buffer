/*
  *  COMP2007 Demo Software (2010)
 */


/**
 * Represents a computer room that contains a specified number of computers.
 * Students need to wait if a computer is not currently available.
 * @author K. Bryson
 */
public class ComputerRoom {
	private int number_computers, availability;

    /*
     * Constructor the computer room.
     * @parameter number_computers Number of computers in computer room.
     */
    public ComputerRoom(int number_computers) {
    	this.number_computers = availability = number_computers;
    }

    /*
     * Allows a 'student' thread to enter the computer room.
     * This will 'block' the thread if there are currently
     * no computers available in the room. The method returns
     * when the student has gained access to a computer.
     */
    public synchronized void enter() throws InterruptedException {
    	while(availability==0) this.wait();
    	availability--;
    	notify();
    }

    /*
     * Allows a 'student' thread to exit the computer room.
     * Thus the computer they were using is now available for
     * another student to use.
     */
    public synchronized void exit() throws InterruptedException {
    	while(availability == number_computers) this.wait();
    	availability++;
    	notify();
    }
}
