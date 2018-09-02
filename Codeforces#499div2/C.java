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

public class C {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out, false);
		TaskC solver = new TaskC();
		solver.solve(in, out);
		out.close();
	}

	static class TaskC {
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int mass = in.nextInt();
			int[] a = new int[n];
			int[] b = new int[n]; 
			for (int i = 0; i < n; ++i) a[i] = in.nextInt();
			for (int i = 0; i < n; ++i) b[i] = in.nextInt();
			double s = mass;
			for (int i = 0; i < n; ++i) {
				if (a[i] == 1 || b[i] == 1)
				{
					out.print(-1);
					return;
				}
				s+=s/(a[i]-1);
				s+=s/(b[i]-1);
			}
			out.print(s-mass);
		}
	}

	static class InputReader {
		BufferedReader reader;
		StringTokenizer tokenizer;
		public InputReader(InputStream in) {
			reader = new BufferedReader(new InputStreamReader(in));
			tokenizer = null;
		}
		public String next() {
			try {
				while(tokenizer == null || !tokenizer.hasMoreTokens()) {
					tokenizer = new StringTokenizer(reader.readLine());
				}
			} 
			catch (IOException e){
				throw new RuntimeException(e);
			}
			return tokenizer.nextToken();
		}
		public Integer nextInt() {
			return Integer.parseInt(next());
		}
	}
}