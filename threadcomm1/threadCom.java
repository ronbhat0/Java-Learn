package threadcomm1;

import java.util.Scanner;

class th implements Runnable{
	static int flag=0;
	int num;
	th(int num){
		this.num=num;
	}
	
	th(){
		num=100;
	}
	
	@Override
	public void run(){
		for(int i=0;i<=num;i++){
			if(flag==0){
			System.out.println(Thread.currentThread().getId()+" "+i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		flag=1;
	}
}

public class threadCom {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		int num;
		System.out.print("Enter a random number from 1 to 100:");
		num = (new Scanner(System.in)).nextInt();
		Thread t1 = new Thread(new th(num));
		Thread t2 = new Thread(new th());
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
