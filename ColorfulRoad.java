import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ColorfulRoad
{
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public int getMin(String road)
	{
		int min = (int)helper(road, 0);
		if (min == Integer.MAX_VALUE) return -1;
		return min;
	}
	
	public int helper(String s, int x)
	{	
		if (x == s.length() - 1) return 0;
			
		if (map.containsKey(x)) {
			return map.get(x);
		}
		
		char cur = s.charAt(x);
		switch (cur) {
		case 'R':
			cur = 'G';
			break;
		case 'G':
			cur = 'B';
			break;
		case 'B':
			cur = 'R';
			break;
		default:
			break;
		}
		
		int minWeight = Integer.MAX_VALUE;
		for (int i = x + 1; i < s.length(); i++) {
			char target = s.charAt(i);
			if (target == cur) {
				int weight = helper(s, i);
				if (weight == Integer.MAX_VALUE) continue;
				weight += (int)Math.pow(i - x, 2);
				minWeight = Math.min(minWeight, weight);
			}
		}
		
		map.put(x, minWeight);
		
		return minWeight;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		ColorfulRoad obj;
		int answer;
		obj = new ColorfulRoad();
		long startTime = System.currentTimeMillis();
		answer = obj.getMin(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		all_right = true;
		
		String p0;
		int p1;
		
		// ----- test 0 -----
		p0 = "RGGGB";
		p1 = 8;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "RGBRGBRGB";
		p1 = 8;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "RBBGGGRR";
		p1 = -1;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "RBRRBGGGBBBBR";
		p1 = 50;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "RG";
		p1 = 1;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "RBRGBGBGGBGRGGG";
		p1 = 52;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
