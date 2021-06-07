package me.wassif.concurrency;

class PrintData implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Printing record" + i);
		}
	}
}

class ReadInventoryThread extends Thread {
	@Override
	public void run() {
		System.out.println("Printing inventory...");
	}
}

public class CreatingThreads {
	public static void main(String[] args) {
//		System.out.println("begin");
//		(new ReadInventoryThread()).start();
//		(new Thread(new PrintData())).start();
//		(new ReadInventoryThread()).start();
//		System.out.println("end");
		//
		new PrintData().run();
		(new Thread(new PrintData())).run();
		(new ReadInventoryThread()).run();
	}
}
