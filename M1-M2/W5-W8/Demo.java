import java.util.*;
class Person{
	private int age;
	private String name;
	public int getAge(){
		return age;
	}
	public String getName(){
		return name;
	}
	Person(int age,String name){
		this.age=age;
		this.name=name;
	}
	public String toString(){
		return "������"+name+",���䣺"+age;
	}
}
public class Demo{
	public static void main(String[] args){
		Person[] persons={new Person(23,"zhouchaoyuan"),new Person(22,"acgege"),
			new Person(22,"acjiji"),new Person(21,"chaoyuanzhou")};

		Arrays.sort(persons,new Comparator<Person>(){//����һ������

			public int compare(Person o1,Person o2){
				if(o1.getAge()==o2.getAge()){
					return o1.getName().compareToIgnoreCase(o1.getName());
				}
				return o1.getAge()-o2.getAge();//���䲻����long�������������
			}
		});

		for(Person person:persons){
			System.out.println(person);
		}
	}
}
/**
output:
������chaoyuanzhou,���䣺21
������acgege,���䣺22
������acjiji,���䣺22
������zhouchaoyuan,���䣺23
*/