package searchmatrix;

public class searchMatrix {
    public static boolean search(int[][] matrix, int x){
        //int[] low = matrix[0];
        //int[] upper = matrix[matrix.length-1];
        int rowLength = matrix[matrix.length-1].length-1;
        int[] middleRow = matrix[matrix.length/2];

        int lowIndex = 0;
        int upperIndex = matrix.length - 1;
        int middleIndex = matrix.length/2;
        if(x < matrix[0][0] || x>matrix[matrix.length-1][rowLength]){return false;}

        while (x>middleRow[middleRow.length-1]||x<middleRow[0]) {
            if (x > middleRow[middleRow.length - 1]) {
                lowIndex = middleIndex;
                middleIndex = (lowIndex + upperIndex) / 2;
                middleRow = matrix[middleIndex];
            } else if (x < middleRow[0]) {
                upperIndex = middleIndex;
                middleIndex = (lowIndex + upperIndex) / 2;
                middleRow = matrix[middleIndex];
            }
        }

        int middle = middleRow[middleRow.length/2];
        int lowIndex_ = 0;
        int upperIndex_ = middleRow.length - 1;
        int middleIndex_ = middleRow.length/2;

        while (x<=middleRow[upperIndex_]||x>=middleRow[lowIndex_]) {
            if (x > middle) {
                lowIndex_ = middleIndex_;
                middleIndex_ = (lowIndex_ + upperIndex_) / 2;
                middle = middleRow[middleIndex_];
            } else if (x < middle) {
                upperIndex_ = middleIndex_;
                middleIndex_ = (lowIndex_ + upperIndex_) / 2;
                middle = middleRow[middleIndex_];
            }
            else {return true;}
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = new int[10][10];
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j <= 9; j++){
                matrix[i][j] = i*10+j;
            }
        }
        boolean n = search(matrix, 36);
        System.out.println(n);
    }
}
