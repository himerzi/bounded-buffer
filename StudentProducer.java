
public class StudentProducer extends Thread {
	Student[] studs;
	Buffer buf;
	public StudentProducer(Student[] studs, Buffer buf){
		this.studs = studs;
		this.buf = buf;
	}
	public void run(){
        // place stuff in buffer
        for (int i = 0; i < studs.length; i++) {
        	try {
				buf.put(studs[i], i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
}
