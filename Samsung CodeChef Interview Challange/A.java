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
import java.util.TreeSet;

class A {
	public static void main(String[] args) {		
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		TaskA solver = new TaskA();
		solver.solve(in, out);
		out.close();
	}	

	static class TaskA {
		public class Node {
			public int x;
			public int y;
			public int pos;
		}
		
		public void solve(InputReader in, PrintWriter out) {
			int t = in.nextInt();
			int[] used = new int[1000000];
			TreeSet<Integer> set;
			while (t > 0) {
				--t;
				int n = in.nextInt();
				int k = in.nextInt();
				int[] a = new int[n];
				int[][] vv = new int[n][n];
				
				
				for (int i = 0; i < n; ++i)
					a[i] = in.nextInt();
				int tr = 0;
				for (int i = 0; i < n; ++i)
					for (int j = i; j < n; ++j) {
						tr++;
						set = new TreeSet<>();
						for (int c = i; c <= j; ++c) {
							if (used[a[c]] != tr) {
								set.add(a[c]);
								used[a[c]] = tr;
							} else {
								set.remove(a[c]);
								used[a[c]] = 0;
							}
						}
						if (set.size() > 0)
							vv[i][j] = set.last();
						//out.println(i + " " + j + " " + vv[i][j]);
					}
				int[][] d = new int[n][k+1];
				for (int i = 0; i < n; ++i)
				for (int j = 0; j <= k; ++j)
					d[i][j] = -1;
				for (int i = 0; i < n; ++i) {
					d[i][0] = vv[0][i];
					//out.print(d[i][0] + " ");
				}
				for (int i = 1; i < n; ++i) 
				for (int j = 1; j <= k; ++j) {
					int ind = i;
					while (ind > 0 && d[ind-1][j-1] != -1) {
						//d[i][j] = Math.max(d[i][j], d[ind-1][j-1] + vv[ind][i]);
						if (d[i][j] < d[ind-1][j-1] + vv[ind][i])
							d[i][j] = d[ind-1][j-1] + vv[ind][i];
						ind--;
					}
				}
				for (int cc = 0; cc < k; ++cc) {
					out.print(d[n-1][cc] + " ");
				}
				out.println();
			}
			
		
		}

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}
		public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
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
	}
}