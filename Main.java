/*
 *  COMP2007 Demo Software (2010)
 */



/**
 * Problem 1 - students waiting for computers.
 * @author K. Bryson
 */
public class Main {

    private static final int NUMBER_STUDENTS = 7;
    private static final int WAITING_CAP = 2;
    private static final int NUMBER_COMPUTERS = 3;

    public static void main(String[] args) {

        // Create a computer room with the specified number of computers.
        ComputerRoom room = new ComputerRoom(NUMBER_COMPUTERS);
        Buffer buffer = new Buffer(WAITING_CAP);
        Student[] student = new Student[NUMBER_STUDENTS];
        StudentProducer producer;
        StudentConsumer consumer;

        // Create the specified number of Students (each a thread).
        for (int i = 0; i < NUMBER_STUDENTS; i++) {
            student[i] = new Student("Student " + i, room);
        }

        producer = new StudentProducer(student, buffer);
        consumer = new StudentConsumer(buffer);
        producer.start();
        consumer.start();
       
    }

}
