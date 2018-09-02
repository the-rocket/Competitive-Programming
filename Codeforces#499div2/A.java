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

class A {
	public static void main(String[] args) {		
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		TaskA solver = new TaskA();
		solver.solve(in, out);
		out.close();
	}	

	static class TaskA {
		public int k;
		public int prev = -1;
		public int weight = 0;
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			k = in.nextInt();
			
			Stream<Character> stream = in.next().chars().mapToObj(i -> (char) i);
			stream.sorted().forEach(l-> {
				if(k>0 && (char)(l)-97>prev) { 
					k--; 
					prev = (char)(l)-96;
					weight += (char)(l)-96;
				}
			});
			out.print(k != 0 ? -1:weight);
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