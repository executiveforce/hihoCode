public class maxCommonChar {
	
	public static void main(String[] args) {
		char[] a = {'a','d','f','c','s','a','f','g','h'};
		char[] b= {'a','c','s','f','h'};
		maxCommonChar(a, b);
	}
	
	public static void maxCommon(char [] a, char [] b){  
        int m = a.length;  
        int n = b.length;  
        int [][] len = new int[m + 1][n + 1];//保存动态规划过程中的公共子串长度  
        int [][] flags = new int[m + 1][n + 1];//保存动态规划过程中的标志位  
        for(int i = 0; i <= m - 1; i++){//实现动态规划函数  
            for(int j = 0; j <= n - 1; j++){  
                if(a[i] == b[j]){//规划函数len[i + 1][j + 1] = len[i][j] + 1, a[i] == b[j]  
                    len[i + 1][j + 1] = len[i][j] + 1;  
                    flags[i + 1][j + 1] = 1; //设置标志位  
                }else if(len[i + 1][j] >= len[i][j + 1]){  
                    len[i + 1][j + 1] = len[i + 1][j];  
                    flags[i + 1][j + 1] = 2;  
                }else{  
                    len[i + 1][j + 1] = len[i][j + 1];  
                    flags[i + 1][j + 1] = 3;  
                }  
            }  
        }  
        int k = len[m][n]; //最长公共子串长度  
        char [] commonChars = new char[k];//保存最长公共子串  
        int i = m, j = n;  
        for(;i > 0 && j > 0;){  
            if(flags[i][j] == 1){//只有标志位为1相应位置上的字符才为公共字符  
                commonChars[k - 1] = a[i - 1];  
                k--;  
                i--;  
                j--;  
            }else if(flags[i][j] == 2){  
                j--;  
            }else{  
                i--;  
            }  
        }  
        System.out.println("最长公共子序列长度为：" + len[m][n]);  
        System.out.print("最长公共子序列为：");  
        for(int l = 0; l <= len[m][n] - 1; l++){  
            System.out.print(commonChars[l] + " ");  
        }  
    }
}