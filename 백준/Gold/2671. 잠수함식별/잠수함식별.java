import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        s = s.replaceAll("(100+1+|01)+$", "*");

        if (s.equals("*")) {
            System.out.println("SUBMARINE");
        } else {
            System.out.println("NOISE");
        }

        br.close();
    }
}