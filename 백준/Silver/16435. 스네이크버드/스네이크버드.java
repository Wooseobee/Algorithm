import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		
		int n = Integer.parseInt(in[0]);
		int l = Integer.parseInt(in[1]);
		
		in = br.readLine().split(" ");
		
		int len = in.length;
		int[] h = new int[len];
		for (int i = 0; i < len; i++) {
			h[i] = Integer.parseInt(in[i]);
		}
		Arrays.sort(h);
		
		for (int i = 0; i < len; i++) {
			if(l >= h[i]) l++;
		}
		
		System.out.println(l);
		br.close();
	}

}