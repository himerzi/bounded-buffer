
public class Buffer {
	int size;
	int in,out = 0;
	volatile int elements = 0;
	Student[] buf;
	public Buffer(int size){
		this.size = size;
		buf = new Student[size];
	}
	synchronized void put(Student s, int id) throws InterruptedException{
		while(elements == size) wait();
		System.out.println("Placing student "+ id + " in waiting room.");
		buf[in] = s;
		elements++;
		in++;
		notify();
		in = (in)%(size);
	}
	synchronized Student get() throws InterruptedException{
		while(elements == 0) wait();
		Student gone = buf[out];
		buf[out] = null;
		elements--;
		notify();
		out++;
		out = out%size;
		return gone;
	}
}
