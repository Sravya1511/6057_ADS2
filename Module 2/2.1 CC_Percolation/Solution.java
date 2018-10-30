import java.util.Scanner;
class Percolation {
    int size;
    int[][] a;

    Percolation(int lines) {
        this.size = lines;
        a = new int[lines][lines];
    }

    public void add(int x, int y) {
        a[x-1][y-1] = 8;
    }

    public void print() {
        for(int i = 0; i<size; i++) {
            for(int j = 0; j<size; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }



}

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lines = Integer.parseInt(input.nextLine());
        Percolation pc = new Percolation(lines);
        for(int i = 0; i< lines; i++) {
            String[] tokens = input.nextLine().split(" ");
            pc.add(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }
        pc.print();

    }

}