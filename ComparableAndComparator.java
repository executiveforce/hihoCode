/*
 *Comparable是在集合内部定义的方法实现的排序；
 *Comparator是在集合外部实现的排序
 *
 *	自定义类要在加入list容器中才能够排序，可以实现Comparable接口，在用Collections类的sort方法排序时，
 *如果不指定Comparator，那么就以自然顺序排序，这里的自然排序就是实现Comparable接口设定的排序方式。
 *
 * comparator是一个专用的比较器，当这个对象不支持自比较或者自比较函数不能满足你的要求时，可以写一个
 *比较器来完成两个对象的比较。
 *
 * 比如：你想对整数采用绝对值大小来排序，Integer是不符合要求的，所以只能使用一个实现了Comparator接口
 *的对象来控制它的排序。
*/

import java.util.*;


public class ComparableAndComparator {
	public static void main(String[] args) {

		Dog dog1 = new Dog(10);
		Dog dog2 = new Dog(1);
		Dog[] dogs = {dog1,dog2};
		Arrays.sort(dogs, new DogComparator());
		for (int i = 0; i < dogs.length; i++) {
			System.out.print(dogs[i].toString()+" ");
		}
		
	}
	
	
}

class Dog{
	int size;
	public Dog(int s){
		size = s;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(size);
	}
}

class DogComparator implements Comparator<Dog>{

	@Override
	public int compare(Dog o1, Dog o2) {
		// 从小到大排序
		return o1.size - o2.size;
	}
	
}