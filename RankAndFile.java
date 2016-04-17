package googlecodejam;

/*
Problem

When Sergeant Argus's army assembles for drilling, they stand in the shape of an N by N square grid, with exactly one soldier in each cell. Each soldier has a certain height.

Argus believes that it is important to keep an eye on all of his soldiers at all times. Since he likes to look at the grid from the upper left, he requires that:

Within every row of the grid, the soldiers' heights must be in strictly increasing order, from left to right.
Within every column of the grid, the soldiers' heights must be in strictly increasing order, from top to bottom.
Although no two soldiers in the same row or column may have the same height, it is possible for multiple soldiers in the grid to have the same height.

Since soldiers sometimes train separately with their row or their column, Argus has asked you to make a report consisting of 2*N lists of the soldiers' heights: one representing each row (in left-to-right order) and column (in top-to-bottom order). As you surveyed the soldiers, you only had small pieces of paper to write on, so you wrote each list on a separate piece of paper. However, on your way back to your office, you were startled by a loud bugle blast and you dropped all of the pieces of paper, and the wind blew one away before you could recover it! The other pieces of paper are now in no particular order, and you can't even remember which lists represent rows and which represent columns, since you didn't write that down.

You know that Argus will make you do hundreds of push-ups if you give him an incomplete report. Can you figure out what the missing list is?

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with an integer N, followed by 2*N-1 lines of N integers each, representing the lists you have, as described in the statement. It is guaranteed that these lists represent all but one of the rows and columns from a valid grid, as described in the statement.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is a list of N integers in strictly increasing order, representing the missing list.

Limits

1 ≤ T ≤ 50.
1 ≤ all heights ≤ 2500.
The integers on each line will be in strictly increasing order.
It is guaranteed that a unique valid answer exists.
Small dataset

2 ≤ N ≤ 10.
Large dataset

2 ≤ N ≤ 50.
Sample


Input 
 	
Output 
 
1
3
1 2 3
2 3 5
3 5 6
2 3 4
1 2 3

Case #1: 3 4 6

In the sample case, the arrangement must be either this:

1 2 3
2 3 4
3 5 6
or this:

1 2 3
2 3 5
3 4 6
In either case, the missing list is 3 4 6.
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RankAndFile {
	private static String getRankFile(String[] input) {
		int[] intInput = new int[input.length];
		for (int i=0; i<input.length; i++) {
			intInput[i] = Integer.parseInt(input[i]);
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<intInput.length; i++) {
			if (map.get(intInput[i])==null) {
				map.put(intInput[i], 1);
			} else {
				map.put(intInput[i], map.get(intInput[i])+1);
			}
		}
		List<Integer> res = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if (value%2!=0) {
				res.add(entry.getKey());
			}
		}
		Collections.sort(res);
		StringBuilder finalResult = new StringBuilder();
		for (Integer e:res) {
			finalResult.append(e);
			finalResult.append(" ");
		}
		return finalResult.toString();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("B-large.in"));
		int numberOfCases = sc.nextInt();
		String[] result = new String[numberOfCases];
		//sc.nextLine();
		for (int i=0; i<numberOfCases; i++) {
			int numberOfLines = sc.nextInt();
			sc.nextLine();
			String tempIn = "";
			for (int j=0; j<(numberOfLines*2-1); j++) {
				String temp = sc.nextLine();
				tempIn += temp +" ";
			}
			String[] input = tempIn.split("\\s+");
			result[i] = getRankFile(input);
		}
		for (int i=0; i<numberOfCases; i++) {
			int caseNumber = i+1; 
			System.out.format("Case #%d: %s\n", caseNumber, result[i]);
		}
	}
}
