package utilitites;

import java.util.Arrays;
import java.util.List;

public class Calculate_square {

	private static void square(List<Integer> nums) {

		for (int i = 0; i < nums.size(); i++) {
			int n = nums.get(i);
			nums.set(i, n * n);
		}

	}

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(2, 4, 6, 8);
		System.out.println("Before square - " + nums);
		square(nums);
		System.out.println("After square - " + nums);
	}

}
