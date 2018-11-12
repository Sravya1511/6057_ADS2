import java.util.Scanner;
class Solution{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		String[] array = new String[n];
		for(int i = 0; i<n; i++) {
			array[i] = input.nextLine();
		}
		Quick3string q3s = new Quick3string();
		q3s.sort(array);
	}
}
