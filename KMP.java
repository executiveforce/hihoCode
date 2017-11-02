/**
*KMP算法：
*
*如果str1的长度为n,str2的长度为m，用暴力法的复杂度为O(n*m);
*
*最长前缀和最长后缀：
*	next数组
*/

public class KMP{
	public int[] next;
	
	private static int[] initialNext(char[] c){

	}
	private static int getNext(int x){

	}

	public static int findMaxSubSequence(char[] str1, char[] str2){
		int n = str1.length;
		int m = str2.length;
		for (int i = 0, j = 0; i < n j < m,;) {
			if(str1[i] == str2[j]){
				++i;
				++j;
			}else{
				int flag = getNext(j);
				j = m - flag;
			}
		}
		if(j == m - 1)
			return i-j;
		else
			return -1;
	}
}