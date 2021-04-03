package com.woniu.chapter11_String;

public class Count {
	int counts=0;
	public int  counter(String words,String word) {
		String []strs = new String[words.length()];
		for(int i=0;i<words.length();i++) {
			strs[i] = words.substring(i, i+1);
		}
		for (int i = 0; i < strs.length; i++) {
			if(strs[i].equals(word)) {
				counts++;
			}
		}
		return counts;
	}

}
