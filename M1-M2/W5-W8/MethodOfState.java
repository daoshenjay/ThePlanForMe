enum State{
	ONLINE,OFFLINE,INVISIBLE;
}
class Context{  
    private State state;
	public Context(){
		state=State.OFFLINE;  
    }
	public Context(State state){
		this.state=state;  
    }
	public void setState(State state){
		this.state=state;
	}
	public void method(){
		switch(state){
			case ONLINE:
				System.out.println("����qq����������״̬");
				break;
			case OFFLINE:
				System.out.println("����qq����������״̬");
				break;
			case INVISIBLE:
				System.out.println("����qq����������״̬");
				break;
			default:
				System.out.println("��ϲ������qq�Ѿ�����");
		}
	}
}  
public class MethodOfState{
	public static void main(String[] args){
		Context context=new Context();//Ĭ��״̬������
		context.method();
		context.setState(State.ONLINE);//��Ϊ����
		context.method();
		context.setState(State.INVISIBLE);//��Ϊ����
		context.method();
	}
}