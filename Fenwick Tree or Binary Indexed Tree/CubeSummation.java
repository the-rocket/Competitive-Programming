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

class CubeSummation {
	public static void main(String[] args) {
			InputReader in = new InputReader(System.in);
			PrintWriter out = new PrintWriter(System.out);

			Task solver = new Task();
			solver.solve(in, out);
			out.close();
	}	

	static class Task {

		public int n;
		public int fenwick[][][];
		public void solve(InputReader in, PrintWriter out) {
			int t = in.nextInt();
			while (t > 0) {
				t--;
				n = in.nextInt()+1;
				int m = in.nextInt();
				fenwick = new int[n][n][n];
				while (m > 0) {
					m--;
					if (in.nextQuery() == 1) {
						update(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
					} else {
						out.println(getSum(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
					}
				}
			}
		}
		public void update(int x, int y, int z, int val) {
			int old = getSum(x, y, z, x, y, z);
			for (; x < n; x|=(x+1))
				for (int j = y; j < n; j|=(j+1))
					for (int k = z; k < n; k|=(k+1))
						fenwick[x][j][k] += val-old;
		}
		public int query(int x, int y, int z) {
			int sum = 0;
			for (; x > 0; x = (x & (x+1)) - 1)
				for (int j = y; j > 0; j = (j & (j+1)) - 1)
					for (int k = z; k > 0; k = (k & (k+1)) - 1)
						sum += fenwick[x][j][k];
			return sum;
		}
		public int getSum(int x, int y, int z, int x1, int y1, int z1) {
			return query(x1, y1, z1) - query(x1, y1, z-1) - query(x1, y-1, z1) - query(x-1, y1, z1) 
			+ query(x-1, y-1, z1) + query(x-1, y1, z-1) + query(x1, y-1, z-1) - query(x-1,y-1,z-1);
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
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens()) {
					tokenizer = new StringTokenizer(reader.readLine());
				}
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		public int nextQuery() {
			switch(next()) {
				case "UPDATE": return 1;
				default: return 2;
			}
		}
	}
}