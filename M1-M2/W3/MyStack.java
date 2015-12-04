/**
* @author chaoyuanzhou@foxmail.com
* @version 1.0
* ʵ�ֵ�ջ��ʵ��һ������ģ��ĳ�����
*/
public class MyStack<E>
{
	//�ڵ���,staticʹ�ô���Ķ���������Χ��Ķ�����ڣ�Ȼ�������ﲢû��ʲô����
	private static class MyNode<U>
	{
		U item;
		int number;
		MyNode<U> next;//ָ����һ���ڵ�,�ڵ�����ΪMyNode<U>��û��ʱΪnull
		MyNode(){
			item=null;
			next=null;
			number=0;
		}
		MyNode(U item,MyNode<U>next){
			this.item=item;
			this.next=next;
			this.number=next.number+1;
		}
		boolean end(){
			return item==null&&next==null;//���һ���ڵ㣬��ǰ��Ϣ��дһ���ڵ㶼��null
		}
	}
	private MyNode<E> top=new MyNode<E>();//��ʼ����ջ
	
	//���Զ�ջ�Ƿ�Ϊ��
	boolean empty(){
		return top.end();
	}

	//�鿴��ջ�����Ķ��󣬵����Ӷ�ջ���Ƴ���
	E peek(){
		return top.item;
	}

	//�Ƴ���ջ�����Ķ��󣬲���Ϊ�˺�����ֵ���ظö���
	E pop(){
		E result=top.item;
		if(!top.end())
			top=top.next;
		return result;
	}

	//����ѹ���ջ������
	E push(E item){
		//ǰ���ǣ���ͷ������ڵ�
		top=new MyNode<E>(item,top);
		return item;
	}

	//���ض����ڶ�ջ�е�λ�ã���1Ϊ����
	int search(Object o){
		if(top.end())return -1;
		if(o.getClass()!=top.item.getClass())return -1;
		MyNode<E> now=top;
		while(!now.end()){
//			System.out.println("acjiji: "+now.number);
			if(o.equals(now.item))
				return top.number-now.number+1;
			now=now.next;
		}
		return -1;
	}

	public static void main(String[] args){
		MyStack<String> ms=new MyStack<String>();
		for(String s:"zhouchaoyuan is name My ".split(" ")){
			ms.push(s);
		}
		
		System.out.println("name is in position: "+ms.search("name"));

		while(!ms.empty()){
			String nowString=ms.pop();
			System.out.print(nowString+" ");
		}
		System.out.println();

		MyStack<Integer> mi=new MyStack<Integer>();
		int[] in={1,2,3,4};
		for(Integer s:in){
			mi.push(s);
		}

		System.out.println("Integer 2 is in position: "+mi.search(2));
		System.out.println("peek item is:"+mi.peek());

		while(!mi.empty()){
			Integer nowString=mi.pop();
			System.out.println(nowString);
		}
	}
}