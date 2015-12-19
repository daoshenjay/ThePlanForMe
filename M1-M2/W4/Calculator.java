/**
* @author chaoyuanzhou@foxmail.com
* @version 1.0
*
* ˼·��
* ֱ��ʹ��BigDecimal����Ӽ��˳�
* ��Ȼ��Ҫ����Ļ�����ô��ֱ������һ�����ʽ����ɣ����ʽ���ƣ�
*
* 123 + 4
* 123 - 4
* 123 * 4
* 123 / 4
* 12.3 + 0.7
* 12.3 - 1.3
* 12.3 * 2.7
* 12.3 / 3.7
* 0123 + 4
* 000 + 00
* 0 - -088
* -12.3 * 2.7
* +12.3 / -3.7
* 00123 / 000
*
*��Ҫע�����:
*	1.��������ֱ���ü�����ĳ�������Ϊ������ȡ��
*	2.������������Ϊ��
*	3.����С������15λ��0����ȡ��
*	4.������ȥ��С����ĺ�������ĺ�0���磺12.3 + 0.7 = 13
*
*/
import java.util.*;
import java.math.*;
public class Calculator{
	Calculator(){
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------��ӭʹ��ֻ�мӼ��˳��ļ�����--------------");
		System.out.println("ʹ�÷���������һ�����ʽ�������������������������ÿո����");
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){//EOF��β win��F6����ctrl+z  linux��ʹ��ctrl+d
			String calc=cin.nextLine();
			//System.out.println(calc);
			String[] all=calc.split(" ");

			if(all.length!=3){//������������һ�������
				System.out.println("�����д�������������");
				continue;
			}
			String first=all[0],oper=all[1],second=all[2];
			//��ʹ��BigDecimal����ʲôǰ����ʲô���߰���Ķ�һ����������
			BigDecimal firstNum=new BigDecimal(first);//��ȷ��ʾ
			BigDecimal secondNum=new BigDecimal(second);//��ȷ��ʾ			
			if("/".equals(oper)&&secondNum.equals(BigDecimal.ZERO)){
				System.out.println("����Ƿ�������Ϊ0������������");
				continue;
			}
			else{
				BigDecimal ans=BigDecimal.ZERO;
				switch(oper){//��ǰ�汾����String����
					case "+":
						ans=firstNum.add(secondNum);
						break;
					case "-":
						ans=firstNum.subtract(secondNum);
						break;
					case "*":
						ans=firstNum.multiply(secondNum);
						break;
					case "/"://Ĭ�ϳ���С�����15λ�����㷽������
						ans=firstNum.divide(secondNum,15,RoundingMode.DOWN);
						break;
					default:
				}
				String result=ans.stripTrailingZeros().toPlainString();
				System.out.println(firstNum+" "+oper+" "+secondNum+" = "+result);
			}
		}
	}
	public static void main(String[] args){
		new Calculator();
	}
}
/*

input:

123 + 4
123 - 4
123 * 4
123 / 4
12.3 + 0.7
12.3 - 1.3
12.3 * 2.7
12.3 / 3.7
0123 + 4
000 + 00
0 - -088
-12.3 * 2.7
+12.3 / -3.7
00123 / 000

output:

123 + 4 = 127
123 - 4 = 119
123 * 4 = 492
123 / 4 = 30.75
12.3 + 0.7 = 13
12.3 - 1.3 = 11
12.3 * 2.7 = 33.21
12.3 / 3.7 = 3.324324324324324
123 + 4 = 127
0 + 0 = 0
0 - -88 = 88
-12.3 * 2.7 = -33.21
12.3 / -3.7 = -3.324324324324324
����Ƿ�������Ϊ0������������
*/