package com.woniu.chapter999;


public class Solution {
	 public int singleNumber(int[] a) {
	        int sinNum=0;
	        for(int i=0;i<a.length;i++){
//	        	int count=0;
//	            for(int j=0;j<a.length;j++) {
//	            	if(a[i]==a[j]&&i!=j) {
//	            		count++;
//	            	}
//	            }
//	            if(count==0) {
//            		sinNum=a[i];
//            		break;
//            	}
	        	sinNum=a[i]^sinNum;
	        }
	        return sinNum;
	    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] a= {7,4,5,9,6,3,4,6,7,9,3};
		int num=sol.singleNumber(a);
		System.out.println(num);
	}

}
