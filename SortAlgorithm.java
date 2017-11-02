import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

/**
 * 常用排序算法
 * 	希尔排序相当于直接插入排序的升级，它们同属于插入排序类；
 *  堆排序相当于简单选择排序的升级，它们同属于选择排序类；
 *	快速排序相当于冒泡排序的升级，它们同属于交换排序类。
 * */
public class SortAlgorithm {
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	Random r = new Random();
    	int n = sc.nextInt();
    	int[] a = new int[n];
    	for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(100);
		}
    	System.out.println("排序前：");
    	for (int i : a) {
			System.out.print(i+" ");
		}
    	System.out.println();
    	//bubbleSort(a);
    	//selectSort(a);
    	//insertSort(a);
    	//quickSort(a, 0, n-1);
    	//shellSort(a);
    	heapSort(a);
    	//System.out.println(bucketSort(a));
    	System.out.println("排序后：");
    	for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.println();
    }
    

    /*
     *
     * 快速排序：
     *	递归思想
     *	快速排序在数据随机分布时，速度最快。
     *  平均时间复杂度为O(nlogn)，最坏时间复杂度为O(n2)
     *  
     */
    public static void quickSort(int[] a, int l, int r){
    	
    	if(l>r)
    		return;
    	int p = partition(a,l,r);
    	quickSort(a,l,p-1);
    	quickSort(a,p+1,r);
    }
	private static int partition(int[] a, int l, int r) {

		int temp;
		int key = a[l];
		while(l<r){
			while(l<r&&a[r]>=key)
				r--;
			temp = a[r];
			a[r] = a[l];
			a[l] = temp;
			while(l<r&&a[l]<=key)
				l++;
			temp = a[r];
			a[r] = a[l];
			a[l] = temp;
		}
		return l;
	}
	
	
	/*
	 * 选择排序
	 *	平均和最坏时间负责度均为O(n2)
	 *	非稳定排序
	 */
	public static void selectSort(int[] a){
		
		for (int i = 0; i < a.length-1; i++) {
			int x = i;
			for (int j = i; j < a.length; j++) {
				if(a[j] < a[x]){
					x = j;
				}
			}
			int temp = a[i];
			a[i] = a[x];
			a[x] = temp;
		}
	
	}
	/*
	 * 冒泡排序
	 *	平均和最坏时间复杂度均为O(n2)
	 *  稳定排序
	 *
	 */
	public static void bubbleSort(int[] a){
		
		for (int i = a.length-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	

	/*
	 * 插入排序：
	 * 	插入排序在数据基本有序和数据量比较小的情况下，效率很高！
	 *  平均时间复杂度为O(n2)，最坏时间复杂度为O(n2)
	 *  插入排序在比较时，相等时不交换位置，所以是稳定排序。
	 * */
	public static void insertSort(int[] a){
		
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j > 0; j--) {
				if(a[j]>a[j-1])
					break;
				else{
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp; 
				}
			}
		}
	}

	/*
	 * 希尔排序：
	 * 		希尔排序是时间复杂度突破O（n*n）的第一批算法。
	 * 		数据量较少时，用插入排序效率很高，受此启发，希尔排序先把数据分组，在子序列内分别
	 *   进行插入排序，当整个序列都基本有序时，再对全体记录进行一次直接插入排序。
	 *   	为了使数据基本有序，需要采取跳跃分割的策略：将相距某个“增量”的记录组成一个子序列
	 *   这样才能保证在子序列内分别进行插入排序后得到的结果是基本有序而不是局部有序。
	 		由于多次插入排序，所以希尔排序是不稳定的。
	 * */
	public static void shellSort(int[] a){
		for (int gap = a.length/2; gap > 0 ; gap/=2) {
			for (int i = gap; i < a.length ; i++) {
				for (int j = i - gap; j >= 0 && a[j]>a[j+gap] ; j-=gap) {
					int temp = a[j];
					a[j] = a[j+gap];
					a[j+gap] = temp;
				}
			}
		}
	}

	/*
	 * 堆排序(数组第一位不参与排序)
	 * 	平均时间复杂度O(nlogn)，最坏时间复杂度O(nlogn)
	 *	由于记录的笔比较与交换是跳跃式进行的，因此堆排序也是一种不稳定的排序方法！	
	 */
	public static void heapSort(int[] a){
		int k, temp,s;
		for (int i = (a.length-1)/2; i >0; i--) {
			s = i;
			for (int j = s*2; j < a.length; j *= 2) {
				if(j<a.length-1 && a[j] < a[j+1])
					k = j+1;
				else
					k = j;
				if (a[s] < a[k]) {
					temp = a[s];
					a[s] = a[k];
					a[k] = temp;
				}
				s = k;
			}
			
		}
	}

	/*
	 * 桶排序：
	 *	1、桶排序是稳定的；
	 *	2、桶排序是常见排序里最快的一种，比快排还要快（大多情况下）
	 *	3、桶排序非常快，但是同时也非常熬时间，基本上是最耗空间的一种排序算法
	 *	参考：http://blog.csdn.net/lg1259156776/article/details/48803043
	 *		 http://www.cnblogs.com/zer0Black/p/6169858.html#3
	 *  桶排序要求数据的分布必须均匀，否则可能导致数据都集中到一个桶中，导致桶排序失败。
	 */
	public static String bucketSort(int[] arr){

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max,arr[i]);
			min = Math.min(min,arr[i]);
		}

		int bucketNum = (max-min)/arr.length+1;//桶数
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < arr.length; i++) {
			int num = (arr[i]-min)/(arr.length);
			bucketArr.get(num).add(arr[i]);
		}

		for (int i = 0; i < bucketArr.size(); i++) {
			Collections.sort(bucketArr.get(i));
		}
		return bucketArr.toString();

	}

	/*
	 * 基数排序
	*/
	public static void radixSort(int[] a){

	}
	
}