import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class Egalitarianism
{
	public int maxDifference(String[] isFriend, int d)
	{
		int c = -1;
		for (int i = 0; i < isFriend.length; i++) {
			int max = maxDepth(isFriend, d, i);
			if (max >= 0) {
				c = Math.max(c, max);	
			}
		}
		
		return c;
	}
	
	private int maxDepth(String[] isFriend, int d, int start) {
		int h = isFriend.length;
		int w = isFriend[0].length();
		boolean[] f = new boolean[h];
		
		Queue<LinkedList<Integer>> q = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> root = new LinkedList<Integer>();
		root.add(start);
		q.add(root);
		f[start] = true;
		int c = 0;
		while (!q.isEmpty()) {
			LinkedList<Integer> vals = q.poll();
			c++;
			LinkedList<Integer> next = new LinkedList<Integer>();
			for (Integer s : vals) {
				for (int i = 0; i < h; i++) {
					if (isFriend[s].charAt(i) == 'Y' && !f[i]) {
						f[i] = true;
						next.add(i);
					}
				}
			}
			if (!next.isEmpty()) q.add(next);
		}
		
		for (int i = 0; i < h; i++) {
			if (!f[i]) return -1;
		}
		
		return (c - 1) * d;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		Egalitarianism obj;
		int answer;
		obj = new Egalitarianism();
		long startTime = System.currentTimeMillis();
		answer = obj.maxDifference(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
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
		
		String[] p0;
		int p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new String[]{"NYN","YNY","NYN"};
		p1 = 10;
		p2 = 20;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"NN","NN"};
		p1 = 1;
		p2 = -1;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"NNYNNN","NNYNNN","YYNYNN","NNYNYY","NNNYNN","NNNYNN"};
		p1 = 1000;
		p2 = 3000;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"NNYN","NNNY","YNNN","NYNN"};
		p1 = 584;
		p2 = -1;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"NYNYYYN","YNNYYYN","NNNNYNN","YYNNYYN","YYYYNNN","YYNYNNY","NNNNNYN"};
		p1 = 5;
		p2 = 20;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new String[]{"NYYNNNNYYYYNNNN","YNNNYNNNNNNYYNN","YNNYNYNNNNYNNNN","NNYNNYNNNNNNNNN","NYNNNNYNNYNNNNN","NNYYNNYNNYNNNYN","NNNNYYNNYNNNNNN","YNNNNNNNNNYNNNN","YNNNNNYNNNNNYNN","YNNNYYNNNNNNNNY","YNYNNNNYNNNNNNN","NYNNNNNNNNNNNNY","NYNNNNNNYNNNNYN","NNNNNYNNNNNNYNN","NNNNNNNNNYNYNNN"};
		p1 = 747;
		p2 = 2988;
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = new String[]{"NY","YN"};
		p1 = 0;
		p2 = 0;
		all_right = KawigiEdit_RunTest(6, p0, p1, true, p2) && all_right;
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
