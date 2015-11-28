/**
* @author chaoyuanzhou@foxmail.com
* @version 1.0
*
* SAX���裨�ο�����һ�д��롷����
* 1.����һ��getData������xml��ȡ���������ص�һ��String
* 2.����ȡ�������ַ�������parseXMLWithSAX�����������������С���裺
*	a.SAXParserFactory��ȡһ��ʵ������ͨ�����ʵ���õ�һ��SAXParser
*	b.ͨ��SAXParser����getXMLReader()��ȡһ��XMLReader
*	c.����XMLReader��ContentHandler(�Լ����岢�̳�DefaultHandler)������parse����
*/
import java.io.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
class ReadDataFromXMLFile
{
	//��ȡxmlΪһ��String
	public static String getData(String fileName){

		File file=new File(fileName);
		BufferedReader reader=null;
		try{
			String line;
			StringBuilder response=new StringBuilder();
			reader=new BufferedReader(new FileReader(file));
			while((line=reader.readLine())!=null){
				response.append(line);
			}
			reader.close();
			return response.toString();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try{
					reader.close();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
		return null;
	}

	public static void parseXMLWithSAX(String content){
		try{
			//�ܹ����úͻ�ȡ���� SAX �Ľ������Խ��� XML �ĵ��Ĺ���,�þ�̬����newInstance��ȡʵ��
			SAXParserFactory factory=SAXParserFactory.newInstance();
			//ʹ�õ�ǰ���õĹ����������� SAXParser ��һ����ʵ����
			SAXParser saxparser=factory.newSAXParser();
			//���ط�װ��XMLReader�� 
			XMLReader xmlReader=saxparser.getXMLReader();
			ContentHandler handler=new ContentHandler();
			xmlReader.setContentHandler(handler);
			//ִ�н���
			xmlReader.parse(new InputSource(new StringReader(content)));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		String response=getData("data.xml");
//		System.out.println(response);
		parseXMLWithSAX(response);
	}
}

class ContentHandler extends DefaultHandler
{
	private String nodeName;
	private StringBuilder id;
	private StringBuilder name;
	private StringBuilder ide;
	private StringBuilder descript;

	@Override
	public void startDocument() throws SAXException{
		id=new StringBuilder();
		name=new StringBuilder();
		ide=new StringBuilder();
		descript=new StringBuilder();
	}
	
	/**
	* @param uri - ���ƿռ� URI�����Ԫ��û���κ����ƿռ� URI������û������ִ�����ƿռ䴦����Ϊ���ַ����� 
    * @param localName - �������ƣ�����ǰ׺�������û������ִ�����ƿռ䴦����Ϊ���ַ����� 
    * @param qName - �޶������ƣ�����ǰ׺��������޶������Ʋ����ã���Ϊ���ַ����� 
    * @param attributes - ���ӵ�Ԫ�ص����ԡ����û�����ԣ��������ǿյ� Attributes ���� 
	* ��ʵ�������������û�õ�
	*/
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
//		System.out.println(localName+"  zhouchaoyuan  "+qName);
//		nodeName=localName;
		nodeName=qName;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException{
//		System.out.println("zhouchaoyuan");
		switch(nodeName){
			case "id":
				id.append(ch,start,length);
				break;
			case "name":
				name.append(ch,start,length);
				break;
			case "ide":
				ide.append(ch,start,length);
				break;
			case "descript":
				descript.append(ch,start,length);
				break;
			default:
				break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException{
//		System.out.println(qName);
		if("Language".equals(qName)){
			//���ÿһ���μ�Element
			System.out.println(id.toString());
			System.out.println(name.toString());
			System.out.println(ide.toString());
			System.out.println(descript.toString().trim());
			id.setLength(0);
			name.setLength(0);
			ide.setLength(0);
			descript.setLength(0);
		}
	}
	
	@Override 
	public void endDocument() throws SAXException{}
}