import java.util.concurrent.*;
class PriorityThreadFactory implements ThreadFactory{//ʵ���̹߳���
	public Thread newThread(Runnable r){//ʵ�ֵķ���
		Thread thread=new Thread(r);
		thread.setPriority(Thread.MIN_PRIORITY);//�ı����ȼ�
		return thread;
	}
}
public class PriorityFromFactory implements Runnable{
	public void run(){
		try{
			while(!Thread.interrupted()){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread());
			}
		}catch(InterruptedException e){
			System.out.println("Interrupted!");
		}
	}
	public static void main(String[] args)throws Exception{
		ExecutorService exe=Executors.newCachedThreadPool(
			new PriorityThreadFactory());//ʹ���Ѿ��е��̹߳���
		for(int i=0;i<10;i++){
			exe.execute(new PriorityFromFactory());
		}
		TimeUnit.SECONDS.sleep(2);
		exe.shutdownNow();
	}
}