package vtp5.test;

import java.util.Random;
import java.util.Scanner;

public class Test extends Importer {

	public static void test() {

		int score = 0;
		
		while (true) {

			
			Random rand = new Random();
			int r = rand.nextInt((/* max - min */(i / 2) - 0) + 1) + 0;
			// r --;

			System.out.println(q.get(r));

			Scanner s = new Scanner(System.in);

			String ans = s.nextLine();

			
			if(ans.equals("attila")){
				System.out.println("Hack mode engaged");
				score = score+1000;
				System.out.println("           score: "+score);
			}
			else if (ans.contains(a.get(r)) /* ans.equalsIgnoreCase(a.get(0)) */) {
				System.out.println("correct");
				score++;
				System.out.println("           score: "+score);
			}

			else {
				System.out.println("wrong. Correct is: " + a.get(r));
				System.out.println("           score: "+score);
			}
		}
	}

}
