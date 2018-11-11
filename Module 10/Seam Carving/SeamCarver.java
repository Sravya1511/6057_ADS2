
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
		if (x == 0  || x == w - 1) {
			return 1000;
		} else if (y == 0 || y == h -1) {
			return 1000;
		}
		// int r1 = picture.get(x, y-1).getRed();
		// int r2 = picture.get(x, y+1).getRed();
		int rx = picture.get(x, y - 1).getRed() - picture.get(x, y + 1).getRed();
		int gx = picture.get(x, y - 1).getGreen() - picture.get(x, y + 1).getGreen();
		int bx = picture.get(x, y - 1).getBlue() - picture.get(x, y + 1).getBlue();
		double xs = (rx * rx) + (gx * gx) + (bx * bx);
		int ry = picture.get(x - 1, y).getRed() - picture.get(x + 1, y).getRed();
		int gy = picture.get(x - 1, y).getGreen() - picture.get(x + 1, y).getGreen();
		int by = picture.get(x - 1, y).getBlue() - picture.get(x + 1, y).getBlue();
		double ys = (ry * ry) + (gy * gy) + (by * by);
		double result = Math.sqrt(xs + ys);
		return result;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		int[][] edgeTo = new int[h][w];
        double[][] distTo = new double[h][w];
        reset(distTo);
        for (int row = 0; row < h; row++) {
            distTo[row][0] = 1000;
        }
        // this is for relaxation.
        for (int col = 0; col < w - 1; col++) {
            for (int row = 0; row < h; row++) {
                relaxH(row, col, edgeTo, distTo);
            }
        }
        double minDist = Double.MAX_VALUE;
        int minRow = 0;
        for (int row = 0; row < h; row++) {
            if (minDist > distTo[row][w - 1]) {
                minDist = distTo[row][w - 1];
                minRow = row;
            }
        }
        int[] indices = new int[w];
        //to find the horizontal seam.
        for (int col = w - 1, row = minRow; col >= 0; col--) {
            indices[col] = row;
            row -= edgeTo[row][col];
        }
        return indices;
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		double[][] energy = new double[h][w];
        int[][] edgeTo = new int[h][w];
        double[][] distTo = new double[h][w];
        reset(distTo);
        int[] indices = new int[h];
        if(w == 1 || h == 1) {
            return indices;
        }
        for(int i = 0; i < w; i++) {
            distTo[0][i] = 1000.0;
        }
        // this is for relaxation.
        for (int i = 0; i < h - 1; i++) {
            for(int j = 0; j < w; j++) {
                relaxV(i, j, edgeTo, distTo);
            }
        }
        // calculating from last row
        // column wise
        double minDist = Double.MAX_VALUE;
        int minCol = 0;
        for (int col = 0; col < w; col++) {
            if (minDist > distTo[h - 1][col]) {
                minDist = distTo[h - 1][col];
                minCol = col;
            }
        }
        //indices values of shortest path.
        for (int row = h -1, col = minCol; row >= 0; row--) {
            indices[row] = col;
            col -= edgeTo[row][col];
        }
        indices[0] = indices[1];
        return indices;
	}

	   private void reset(double[][] distTo) {
        /**
         *reset all the values to maxvalue.
         */
        for(int i = 0; i < distTo.length; i++) {
            for(int j = 0; j < distTo[i].length; j++) {
                distTo[i][j] = Double.MAX_VALUE;
            }
        }
    }


     private void relaxV(int row, int col, int[][] edgeTo, double[][] distTo) {
        int nextRow = row + 1;
        for (int i = -1; i <= 1; i++) {
            int nextCol = col + i;
            if (nextCol < 0 || nextCol >= w) {
                continue;
            }
            //spl case for bottom element.
            if(i == 0) {
                if(distTo[nextRow][nextCol] >= distTo[row][col]
                    + energy(nextCol, nextRow)) {
                distTo[nextRow][nextCol] = distTo[row][col] + energy(nextCol, nextRow);
                edgeTo[nextRow][nextCol] = i;
                }
            }
            if (distTo[nextRow][nextCol] > distTo[row][col] + energy(nextCol, nextRow)) {
                distTo[nextRow][nextCol] = distTo[row][col] + energy(nextCol, nextRow);
                edgeTo[nextRow][nextCol] = i;
            }
        }
    }

    private void relaxH(int row, int col, int[][] edgeTo, double[][] distTo) {
        int nextCol = col + 1;
        for (int i = -1; i <= 1; i++) {
            int nextRow = row + i;
            if (nextRow < 0 || nextRow >= h) continue;
            if(i == 0) {
                if(distTo[nextRow][nextCol] >= distTo[row][col]  + energy(nextCol, nextRow)) {
                    distTo[nextRow][nextCol] = distTo[row][col]  + energy(nextCol, nextRow);
                    edgeTo[nextRow][nextCol] = i;
                }
            }
            if (distTo[nextRow][nextCol] > distTo[row][col]  + energy(nextCol, nextRow)) {
                distTo[nextRow][nextCol] = distTo[row][col]  + energy(nextCol, nextRow);
                edgeTo[nextRow][nextCol] = i;
            }
        }
    }



	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {
        for(int col = 0; col < w; col++) {
		    for(int row = seam[col]; row < h - 1; row++) {
			    this.picture.set(col, row, this.picture.get(col, row + 1));
		    }
	    }
	    h--;
	}


	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {
        for(int row = 0; row < h; row++) {
		    for(int col = seam[row]; col < w - 1; col++) {
		        this.picture.set(col, row, this.picture.get(col + 1, row));
		    }
	    }
	    w--;
	}
}