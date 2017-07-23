
/*

Write a function that when given an array of elevations representing peaks
on a 2D mountain range will return the elevation of lakes formed when the
valleys of that range are filled with rain water.

The array of elevations passed into your function will be ordered from left
to right but the order of the returned array of lake elevations is unimportant.

   +--------------------------------------------------------------------------+
14 |                                                                          |
13 |                                                                          |
12 |                                                                          |
11 |                           /\                                             |
10 |                          /  \                                            |
 9 |                         /    \~~~~~~~~~~~~~~~~~~~~~~/\                   |
 8 |              /\~~~~~~~~/      \~ ~ ~ ~ ~ ~ ~ ~ ~ ~ /  \                  |
 7 |             /  \~ ~ ~ /        \~ ~ ~ ~ ~ ~ ~ ~ ~ /    \                 |
 6 |            /    \~ ~ /          \~ ~ ~ /\~ ~ ~ ~ /      \                |
 5 |           /      \~ /            \~ ~ /  \~ ~ ~ /        \~~/\           |
 4 |          /        \/              \~ /    \~ ~ /          \/  \          |
 3 |         /                          \/      \~ /                \         |
 2 |        /                                    \/                  \        |
 1 |       /                                                          \       |
 0 |~~~~~~/                                                            \~~~~~~|
   |~ ~ ~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  ~  ~|
   |  ~  ~  ~  ~   ~   ~   ~   ~   ~   ~   ~   ~   ~   ~   ~   ~   ~   ~  ~  ~|
   |   ~     ~     ~     ~     ~     ~     ~     ~     ~     ~     ~     ~    |
   +--------------------------------------------------------------------------+

 EXAMPLE:
 Function is passed the array [8,11,6,9,5]

 Your function would return the following array representing the elevations of
 the series of lakes formed by filling in the valleys:
 [8,9,5]

 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class AA {
	public static void main(final String[] args) {
		final Scanner scan = new Scanner(System.in);
		System.out.println("enter:");
		final int size = scan.nextInt();
		final int[] myInput = new int[size];
		int count = 0;
		while (count < size) {
			myInput[count] = scan.nextInt();
			count = count + 1;
		}
		final Set<Integer> myOutput = new HashSet<>();
		final int last = 0;
		final boolean isValleyFound = false;
		//		final int i = 0;
		//		final int j = 1;
		// while ((i < myInput.length) && (j < myInput.length)) {
		// if (myInput[i] < myInput[j]) {
		// myOutput.add(myInput[i]);
		// i++;
		// j++;
		// } else {
		// if ((last != 0) && (last < myInput[j])) {
		// myOutput.add(myInput[j]);
		// // i = i + 1;
		// j = j + 1;
		// } else {
		// last = myInput[i];
		// i = j;
		// j++;
		// }
		// }
		//
		// if (i == (myInput.length - 1)) {
		// myOutput.add(last);
		// }
		// }
		for(int i=0; i<myInput.length;i++){
			for (int j = i + 1; j < myInput.length; j++) {
				if((myInput[j]-myInput[i])>0){
					myOutput.add(myInput[i]);
					i = j - 1;
					break;
				}else{
					i = j - 1;
					if(j==(myInput.length-1)) {

						myOutput.add(myInput[j]);
					}
				}
			}
		}


		System.out.println(myOutput);

	}

}
