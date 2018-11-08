
public class SeamCarver {
	Picture picture;
	int w;
	int h;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
         this.picture = picture;
         if(picture == null) {
         	System.out.println("picture is null");
         	return;
         }
         this.w = picture.width();
         this.h = picture.height();


	}
	// current picture
	public Picture picture() {
		return picture;
	}
	// width of current picture
	public int width() {
		return w;
	}

	// height of current picture
	public int height() {
		return h;
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		return 0;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}