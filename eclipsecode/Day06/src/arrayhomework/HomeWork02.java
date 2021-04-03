package arrayhomework;

import java.util.Arrays;

public class HomeWork02 {
	public static void main(String[] args) {
		int []score = {72,89,65,58,87,91,53,82,71,93,76,68};
		int []count = {0,0,0,0,0};
		for(int i = 0;i<score.length;i++){
			if(score[i]<60) {
				count[0]++;
			}else if(score[i]>=60 && score[i]<70) {
				count[1]++;
			}else if(score[i]>=70 && score[i]<80) {
				count[2]++;
			}else if(score[i]>=80 && score[i]<90) {
				count[3]++;
			}else if(score[i]>=90) {
				count[4]++;
			}
		}
		System.out.println(Arrays.toString(count));
	}

}
