//ʹ�������ڲ���ĳ��󹤳�ģʽ
interface Service{
    void work();
}
interface ServiceFactory{
    Service getService();
}
class Waiter implements Service{
    private Waiter(){}//private�Ĺ�����
    public void work(){
        System.out.println("�з���Ա���ṩ����");
    }//static��
    public static ServiceFactory factory=new ServiceFactory(){//������
        public Service getService(){
            return new Waiter();
        }
    };
}
class Waitress implements Service{
    private Waitress(){}//private�Ĺ�����
    public void work(){
        System.out.println("Ů����Ա���ṩ����");
    }//static��
    public static ServiceFactory factory=new ServiceFactory(){//������
        public Service getService(){
            return new Waitress();
        }
    };
}   
public class FactoryTest{
    public static void Factory(ServiceFactory SF){
        Service service=SF.getService();//��÷���
        service.work();//���з���
    }
    public static void main(String[] args){
        Factory(Waiter.factory);
        Factory(Waitress.factory);
    }
}