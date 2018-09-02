import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Collections;
import java.util.stream.*;
import java.util.Arrays;

public class B {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		TaskB solver = new TaskB();	
		solver.solve(in, out);
		out.close();
	}

	static class TaskB {
		public int sum = 0, dd;
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] data  = in.nextArray(m);
			
			for (int d = m; d >= 1; --d) {
				sum = 0;
				dd = d;
				// v = new Object() {int d, sum=0;};
				// v.d = d;

				Arrays.stream(data).forEach(x-> sum+=x/dd);
				if (sum>=n) {
					out.print(d);
					return;
				}
			}
			out.print(0);
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public InputReader(InputStream in) {
			reader = new BufferedReader(new InputStreamReader(in));
			tokenizer = null;
		}	
		public String next() {
			while(tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public int[] nextArray(int len) {
			int[] newdata = new int[100];
			for (int i = 0; i < len; ++i)
				newdata[nextInt()-1]++;
			return newdata;
		}
	}
} 