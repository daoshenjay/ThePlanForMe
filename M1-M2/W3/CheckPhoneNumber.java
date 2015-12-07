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
*	e���������154��ͷ�ģ���Ϊ154г����Ҫ������ �r(�s�n�t)�q �� http://www.chahaoba.com/154
* 3���ֻ�����̶�11λ��ԭ�����£�
*	a��ǰ3λ������ʶ���
*	b���м�4λ�ǵ������
*	c�����4λ���û����룬ÿ��һ���û�
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
		return PhoneNumber.matches("^(((13|18)[0-9])|(15[0-35-9]))\\d{8}$");
	}
	public static void main(String[] args){
		System.out.println(check("01234567890"));//false
		System.out.println(check("234322333"));//false
		System.out.println(check("172637816246753"));//false
		System.out.println(check("1577327x310"));//false
		System.out.println(check("10000000000"));//false
		System.out.println(check("14773270310"));//false
		System.out.println(check("15473270310"));//false
		System.out.println(check("15773270310"));//true
	}
}