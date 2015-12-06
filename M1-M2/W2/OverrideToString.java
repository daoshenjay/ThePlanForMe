/**
* @author chaoyuanzhou@foxmail.com
* @version 1.0
*
*/
import java.lang.reflect.*;
public class OverrideToString
{
	int count;
	String firstString;
	String secondString;
	OverrideToString(int c,String f,String s){
		count=c;
		firstString=f;
		secondString=s;
	}
	public String toString(){
		return toStringUtil.toString(this);
		//jar��commons-lang.jar�ṩToStringBuilder.reflectionToStringֱ��ת��
		//return ToStringBuilder.reflectionToString(this);
	}
	public static void main(String[] args) 
	{
		OverrideToString orts=new OverrideToString(23,"zhouchaoyuan","peter");
		System.out.println(orts);
	}
}

/**
* ��д�����࣬������д��ͨ��toString��������һ������
* ���԰���������ó�public����һ���ļ��в����ڹ��ܰ�������ʹ��
*/
class toStringUtil
{
	public static String toString(Object obj){
		Class c=obj.getClass();
		// ����һ�������� Field��������һ�����ͣ����ַ�����
		Field[] fields=c.getDeclaredFields();
		//ʹ��Stringbuilder��Ϊ�м����������ò��ɱ��String
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		for(Field field:fields){
			//���ش� Field �����ʾ���ֶε����ơ�
			sb.append(field.getName()+":");
			try{
				// ����ָ�������ϴ� Field ��ʾ���ֶε�ֵ,��׽���field��private���쳣
				sb.append(field.get(obj));
			}catch(IllegalAccessException e){
				e.printStackTrace();
			}
			sb.append(",");
		}
		sb=sb.deleteCharAt(sb.length()-1);
		sb.append("}");
		return sb.toString();
	}
}