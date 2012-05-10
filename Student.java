/*
 *  COMP2007 Demo Software (2010)
 */


/**
 * Student that models a student that enters
 * the computer room, works for 10 seconds, then exits.
 * @author K. Bryson
 */
public class Student extends Thread {

    private String name;
    private ComputerRoom room;
    
    public Student(String name, ComputerRoom room) {
        this.name = name;
        this.room = room;
    }

    public void run() {
        try {

            System.out.println(name + " has exited buffer.");
            room.enter();
            System.out.println(name + " has entered and is WORKING.");

            // The 10 seconds sleep "models" working
            // at a computer for some time.
            sleep(5000);

            System.out.println(name + " is EXITING.");
            room.exit();
            
        } catch (InterruptedException ex) {
            System.out.println(name + " was interrupted.");
        }

    }

}
