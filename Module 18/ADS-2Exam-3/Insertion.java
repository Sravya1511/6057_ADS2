import java.util.Arrays;
class Insertion {

    Insertion() {

    }
    public void exchange(int a, int b) {
        int temp = 0;
    	temp = a;
    	a = b;
    	b = temp;
    }

    public void insertionSort(int[] array, int size) {
    	for(int i = 0; i<size; i++) {
    		for(int j = i; j>0; j--) {
    			if(array[j] > array[j-1]) {
    				int temp = 0;
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
    			}
    		}
    	}
    }
}