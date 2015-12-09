public class Singleton
{
	//˽�й�����
	private Singleton(){};
	//˽����
	private static Singleton instance=new Singleton();	
	//�����෽��
	public static Singleton getInstance(){
		return instance;
	}
	public void print(){
		System.out.println("I am SingleTon!");
	}
	public static void main(String[] args){
		Singleton st=getInstance();
		st.print();
	}
}
/*
enum SingleTon{
	INSTANCE;
}
*/