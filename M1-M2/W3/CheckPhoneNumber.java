/**
* @author chaoyuanzhou@foxmail.com
* @version 1.0
*
* �����ϵã�
* �ֻ��ű������
* 1��ֻ����1��ͷ��ԭ�����£�
*	a��0����Ϊ��;���뿪ͷ��
*	b��2~8����ͨ�Ĺ̶��绰
*	c��9��ͷ������ҵ����̨���߿ͻ�����ʹ�õģ���95533
* 2���ڶ�λֻ����3��5��8��ԭ�����£�
*	a�������0��1�Ļ����ײ����10086��110
*	b�������2��4�Ļ����ײ����120��145������ר���ŶΣ�
*	c��6,7�ǻṹ�ɻ�����������룬��165��17911
*	d��19��ͷ�����п������ط��Ż��߹������
* 3���ֻ�����̶�11λ��ԭ�����£�
*	a��ǰ3λ������ʶ���
*	b���м�4λ�ǵ������
*	c�����4λ���û����룬ÿ��һ���û�
* 4���������154��ͷ�ģ�ԭ�����£�
*	a����Ϊ154г����Ҫ������ �r(�s�n�t)�q �� http://www.chahaoba.com/154
* 5����Ȼ�ֻ���ֻ�ܰ�������
*/
public class CheckPhoneNumber
{
	/**
	* @param PhoneNumber Ҫ�ж��Ƿ�Ϸ����ֻ���
	* @return ����PhoneNumber�Ƿ�Ϸ���true�Ϸ���false���Ϸ�
	*/
	public static boolean check(String PhoneNumber){
		/**
		* ������ʽ���ӿ�ͷ����βƥ��һ������
		* ����ǰ��λ��13����18��ͷ�ĵ���λ������������
		*             15��ͷ�ĵ���λ���˲�����4֮��������������
		* ���ں��λ��ֻҪ�Ǹպ�8λ���־���
		*/
		//����д���ж��֣���������^(((13|18)[0-9])|(15[0-35-9]))\\d{8}$
		return PhoneNumber.matches("^((1[38]\\d)|(15[^4|\\D]))\\d{8}$");
	}
	public static void main(String[] args){

		//��1��ͷ
		System.out.println(check("05773270310"));//false
		System.out.println(check("25773270310"));//false
		System.out.println(check("35773270310"));//false
		System.out.println(check("45773270310"));//false
		System.out.println(check("55773270310"));//false
		System.out.println(check("65773270310"));//false
		System.out.println(check("75773270310"));//false
		System.out.println(check("85773270310"));//false
		System.out.println(check("95773270310"));//false

		//��3��5��8Ϊ�ڶ�λ��
		System.out.println(check("10773270310"));//false
		System.out.println(check("11773270310"));//false
		System.out.println(check("12773270310"));//false
		System.out.println(check("14773270310"));//false
		System.out.println(check("16773270310"));//false
		System.out.println(check("17773270310"));//false
		System.out.println(check("19773270310"));//false

		//154��ͷ��
		System.out.println(check("15473270310"));//false

		//���Ȳ���11λ����������ֵ�
		System.out.println(check("135322333"));      //false
		System.out.println(check("152637816246753"));//false
		System.out.println(check("1577327x310"));    //false
		System.out.println(check("1577_270310"));    //false
		
		//��ȷ��
		System.out.println(check("15773270310"));//true
		System.out.println(check("18318850119"));//true
	}
}