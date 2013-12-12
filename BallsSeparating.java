import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BallsSeparating
{
	static final int INF = 1000000000;
	
	public int minOperations(int[] red, int[] green, int[] blue)
	{
		int res = INF;
		int N = red.length;
		for (int r = 0; r < N; r++) {
			for (int g = 0; g < N; g++) {
				if (g != r) for(int b = 0; b < N; b++) {
					if (b != r && b != g) {
						int moves = 0;
						for (int i = 0; i < N; i++) {
							if (r == i) {
								moves += green[i] + blue[i];
							}else if (g == i) {
								moves += red[i] + blue[i];
							}else if (b == i) {
								moves += green[i] + red[i];
							}else {
		                        moves += green[i] + red[i] + blue[i];
		                        moves -= Math.max(Math.max(green[i], red[i]), blue[i]);
		                    }
						}
						res = Math.min(moves, res);
					}
				}
			}
		}
		return res == INF ? -1 : res;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		BallsSeparating obj;
		int answer;
		obj = new BallsSeparating();
		long startTime = System.currentTimeMillis();
		answer = obj.minOperations(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p3);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p3;
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
		
		int[] p0;
		int[] p1;
		int[] p2;
		int p3;
		
		// ----- test 0 -----
		p0 = new int[]{1,1,1};
		p1 = new int[]{1,1,1};
		p2 = new int[]{1,1,1};
		p3 = 6;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{5};
		p1 = new int[]{6};
		p2 = new int[]{8};
		p3 = -1;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{4,6,5,7};
		p1 = new int[]{7,4,6,3};
		p2 = new int[]{6,5,3,8};
		p3 = 37;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{7,12,9,9,7};
		p1 = new int[]{7,10,8,8,9};
		p2 = new int[]{8,9,5,6,13};
		p3 = 77;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{842398,491273,958925,849859,771363,67803,184892,391907,256150,75799};
		p1 = new int[]{268944,342402,894352,228640,903885,908656,414271,292588,852057,889141};
		p2 = new int[]{662939,340220,600081,390298,376707,372199,435097,40266,145590,505103};
		p3 = 7230607;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
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
