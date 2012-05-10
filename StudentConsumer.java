
public class StudentConsumer extends Thread {
	Student[] studs;
	Buffer buf;
	public StudentConsumer(Buffer buf){
		this.buf = buf;
	}
	public void run(){
		while(true){
			try {
				Student s = buf.get();
				s.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
