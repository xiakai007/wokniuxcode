package arrayhomework;
//统计出现次数最多的水果名及它出现的次数
public class HomeWork10 {
	public static void main(String[] args) {
		String []fruits = {"香蕉","桃子","苹果","火龙果","苹果","香蕉","苹果","桃子","菠萝","梨","苹果","桃子","苹果"};
		int max = 0;
		String fruitName = null;
		for(int i = 0;i<fruits.length;i++) {
			int count = 0;
			for(int j = 0;j<fruits.length;j++) {
				if(fruits[i].equals(fruits[j])) {
					count++;
				}
			}
			System.out.println(fruits[i]+count);
			if(count >=max) {
				max = count;
				fruitName = fruits[i];
			}
		}
		System.out.println("出现次数最多的水果："+fruitName+",共出现了"+max+"次");
	}
	private static void demo(String[] fruits) {
		int appleCount = 0;
		String fruitName = "苹果";
		for(int i = 0;i<fruits.length;i++) {
			if(fruitName.equals(fruits[i])) {
				appleCount++;
			}
		}
		System.out.println(appleCount);
	}
	

}
