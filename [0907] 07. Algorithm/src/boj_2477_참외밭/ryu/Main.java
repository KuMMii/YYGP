package boj_2477_참외밭.ryu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
	static class Line {
		int dir, len;

		public Line(int dir, int len) {
			super();
			this.dir = dir;
			this.len = len;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		int height = 0;
		int width = 0;
		Line[] lines = new Line[6];
		
		for (int i=0; i<6; i++) {
			Line line = new Line(sc.nextInt(), sc.nextInt());
			lines[i] = line; 
			
			if (line.dir==3 || line.dir==4) {
				if (line.len > height) height = line.len;
			} else {
				if (line.len > width) width = line.len;
			}
		}
		
		int big, small;
		// big
		big = height * width;
		// small
		Pattern pattern = Pattern.compile("3131|4242|1414|2323");
		String dirs = Arrays.stream(lines).map(line->String.valueOf(line.dir)).collect(Collectors.joining());
		Matcher matcher = pattern.matcher(dirs+dirs);
		int start, end;
		matcher.find();
		start = (matcher.start()+1) % 6;
		end = (matcher.end()-2) % 6;
		small = lines[start].len * lines[end].len;
		
		System.out.println((big-small)*K);
		
		sc.close();
	}

}