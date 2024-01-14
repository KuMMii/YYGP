package boj_2941_크로아티아알파벳.ryu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Pattern pattern = Pattern.compile("c=|c-|dz=|d-|lj|nj|s=|z=");
		Matcher matcher = pattern.matcher(bf.readLine());
		System.out.println(matcher.replaceAll("A").length());
	}
}
