package cn.itcast.test;

public class T implements Runnable{
	private int i=1000;
	private Object obj = new Object();

	@Override
	public void run() {
		while (true){
			synchronized (obj){
				try {
					//Thread.sleep(10l);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"---"+i--);
				if(i<0)
					break;
			}

		}
	}
}
