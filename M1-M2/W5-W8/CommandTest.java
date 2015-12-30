//����ִ�������CPU
class CPU{
	public void execute(){//ִ������
		System.out.println("CPU���յ�ָ�����ִ��...");
	}
}
//�����������������CPU
class Computer{
	private CPU cpu;//�趨��������cpu
	Computer(CPU cpu){
		this.cpu=cpu;
	}
	public void transmit(){//��������
		cpu.execute();
	}
}

interface Command{
	void execute();
}
//ʵ�ֽӿڵľ�������
class ConcreteCommand implements Command{
	private Computer computer;//�趨�������ǵ���
    ConcreteCommand(Computer com){
        computer=com;
    }
    public void execute(){//���뷢������
        computer.transmit();
    }
}
//����Գ
class Coder{
	private ConcreteCommand con;
	Coder(ConcreteCommand con){
		this.con=con;
	}
	public void send(){//���뷢������
		con.execute();
	}
}

public class CommandTest{
	public static void main(String[] args){
		Coder coder=new Coder(new ConcreteCommand(
			new Computer(new CPU())));
		coder.send();//����
	}
}