/**
* @author chaoyuanzhou@foxmail.com
* @version 1.0
* ʹ�ÿ�Դ���XOM������(www.xom.nu)
*
* XOM���裨�ο���java���˼�롷����
* 1.���ļ�·����װ��һ��Reader��Ȼ��ͨ��Buider����Document
* 2.Document��ȡ��Ԫ�أ�Ȼ�������Ԫ��
*
*ps��ʹ��ʱ����jar�� xom-1.2.10.jar�����ٷ��㣬���·�ʽ�ʺ���֪XML�ṹ��XML�ĵ�
*/
import nu.xom.*;
import java.io.*;
import java.util.*;
public class ReadXMLFile extends ArrayList<Language>
{
	ReadXMLFile(String fileName)throws Exception{
		//ʹ���ַ��������ֽڣ�������Document�����ļ���ȡʹ����������ʹ��URL
		Document doc=new Builder().build(new BufferedReader(new FileReader(fileName)));
		Elements elements=doc.getRootElement().getChildElements();
		for(int i=0;i<elements.size();i++){
			add(new Language(elements.get(i)));
		}
	}
	public static void main(String[] args)throws Exception{
		System.out.println(new ReadXMLFile("data.xml"));
	}
}
//Element ��
class Language
{
	private String id,ide,name,descript;
	public Language(Element language){
		id=language.getFirstChildElement("id").getValue();
		name=language.getFirstChildElement("name").getValue();
		ide=language.getFirstChildElement("ide").getValue();
		descript=language.getFirstChildElement("descript").getValue();
	}
	public String toString(){
		return "���:"+id+"; ����:"+name+"; ʹ�õ�ide:"+ide+"; ����:"+descript+"\n";
	}
}