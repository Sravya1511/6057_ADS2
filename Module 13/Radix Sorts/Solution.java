import java.util.Scanner;
import java.util.Arrays;
/**
 * class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
	}
	/**
	 * reads input.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		String[] array = new String[n];
		for (int i = 0; i < n; i++) {
			array[i] = input.nextLine();
		}
		Quick3string q3s = new Quick3string();
		q3s.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
