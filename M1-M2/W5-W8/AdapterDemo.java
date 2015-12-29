import java.util.*;
class ReversibleArrayList<T> extends ArrayList<T>{
	ReversibleArrayList(Collection<T> c){super(c);}
	public Iterable<T> reversed(){//������ʹ��
		return new Iterable<T>(){//ʵ��Iterable��������
			public Iterator<T> iterator(){//����ʵ�ֵķ���
				return new Iterator<T>(){//ʵ��Iterator��������
					int index=size()-1;
					public boolean hasNext(){return index>-1;}
					public T next(){return get(index--);}
					public void remove(){//foreachʱ�����Ƴ�
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}
public class AdapterDemo{
	public static void main(String[] args){
		ReversibleArrayList<String>list=
			new ReversibleArrayList<String>(
				Arrays.asList("this is a question".split(" ")));
		for(String str:list){
			System.out.print(str+" ");
		}
		System.out.println("");
		for(String str:list.reversed()){
			System.out.print(str+" ");
		}
	}
}