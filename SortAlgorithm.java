import java.util.Random;
import java.util.Scanner;

/**
 * Partition:
 * 	
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
    	quickSort(a, 0, n-1);
    	System.out.println("排序后：");
    	for (int i : a) {
			System.out.print(i+" ");
		}
    }
    
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
	 * 插入排序：
	 * 	插入排序在数据基本有序和数据量比较小的情况下，效率很高！
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
	 * 希尔排序：
	 * 		希尔排序是时间复杂度突破O（n*n）的第一批算法。
	 * 		数据量较少时，用插入排序效率很高，受此启发，希尔排序先把数据分组，在子序列内分别
	 *   进行插入排序，当整个序列都基本有序时，再对全体记录进行一次直接插入排序。
	 *   	为了使数据基本有序，需要采取跳跃分割的策略：将相距某个“增量”的记录组成一个子序列
	 *   这样才能保证在子序列内分别进行插入排序后得到的结果是基本有序而不是局部有序。
	 * */
	public static void shellSort(int[] a){
		
		int i,j;
		int increment = a.length;
		
		do {
			
			increment = increment/3+1;
			for (i = increment+1; i < a.length; i++) {
				if(a[i] < a[i-increment]){
					if()
				}
					
			}
			
		} while (increment>1);
		
	}
	
}