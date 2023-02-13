// Given a string str and an integer K, the task is to reduce the string by applying the 
// following operation any number of times until it is no longer possible:
// Choose a group of K consecutive identical characters and remove them from the string.

// Input: K = 2, str = “geeksforgeeks” 
// Output: gksforgks 
// Explanation: After removal of both occurrences of the substring “ee”, the string reduces to “gksforgks”.

// Input: K = 3, str = “qddxxxd” 
// Output: q 
// Explanation: 
// Removal of “xxx” modifies the string to “qddd”. 
// Again, removal of “ddd”modifies the string to “q”. 

import java.util.*;

class RestrictiveCandyCrush {

	public static String reduced_String(int k, String s) {

		if (k == 1) {
			return "";
		}

		Stack<Pair> st = new Stack<Pair>();

		int l = s.length();
		int ctr = 0;

		for (int i = 0; i < l; i++) {

			if (st.size() == 0) {
				st.push(new Pair(s.charAt(i), 1));
				continue;
			}

			if (st.peek().c == s.charAt(i)) {
				Pair p = st.peek();
				st.pop();
				p.ctr += 1;
				if (p.ctr == k) {
					continue;
				}
				else {
					st.push(p);
				}
			}
			else {
				st.push(new Pair(s.charAt(i), 1));
			}
		}

		StringBuilder output = new StringBuilder();

		while (st.size() > 0) {
			char c = st.peek().c;
			int cnt = st.peek().ctr;
			while (cnt-- > 0)
				output.append(String.valueOf(c));
			st.pop();
		}
		output.reverse();
		return output.toString();
	}

	public static void main(String[] args) {
		int k = 2;
		String st = "geeksforgeeks";
		String ans = reduced_String(k, st);
		System.out.println(ans);
	}

	static class Pair {
		char c;
		int ctr;
		Pair(char c, int ctr) {
			this.c = c;
			this.ctr = ctr;
		}
	}
}
