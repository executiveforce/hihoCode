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
    	System.out.println("����ǰ��");
    	for (int i : a) {
			System.out.print(i+" ");
		}
    	System.out.println();
    	//bubbleSort(a);
    	//selectSort(a);
    	//insertSort(a);
    	quickSort(a, 0, n-1);
    	System.out.println("�����");
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
	 * ��������
	 * 	�������������ݻ���������������Ƚ�С������£�Ч�ʺܸߣ�
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
	 * ϣ������
	 * 		ϣ��������ʱ�临�Ӷ�ͻ��O��n*n���ĵ�һ���㷨��
	 * 		����������ʱ���ò�������Ч�ʺܸߣ��ܴ�������ϣ�������Ȱ����ݷ��飬���������ڷֱ�
	 *   ���в������򣬵��������ж���������ʱ���ٶ�ȫ���¼����һ��ֱ�Ӳ�������
	 *   	Ϊ��ʹ���ݻ���������Ҫ��ȡ��Ծ�ָ�Ĳ��ԣ������ĳ�����������ļ�¼���һ��������
	 *   �������ܱ�֤���������ڷֱ���в��������õ��Ľ���ǻ�����������Ǿֲ�����
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