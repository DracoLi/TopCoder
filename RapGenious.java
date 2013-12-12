
public class RapGenious {
	
	public static int solve()
	{
		int longestLength = 0;
		int i = 1;
		int longestInt = i;
		while (i < 1000000) {
			int currentLength = lengthOfChain(i);
			if (currentLength > longestLength) {
				longestInt = i;
				longestLength = currentLength;
			}
			i++;
		}
		
		System.out.println("Longest Length: " + longestLength);
		System.out.println("Longest Int: " + longestInt);
		return longestInt;
	}
	
	public static int lengthOfChain(int i)
	{
		double value = i;
		int length = 0;
		while (value != 1) {
			if (value % 2 == 0) value /= 2;
			else value = value * 3 + 1;
			length++;
		}
		return length;
	}
	
	public static void main(String[] args) {
		solve();
	}
}
