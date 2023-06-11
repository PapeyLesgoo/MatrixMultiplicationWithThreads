public class MatrixTemp {

    public int Mult(int arr1[][], int arr2[][], int j1, int i2){
        int row = 0, col = 0;
        //j1 and i2 constants to stay in their specified row and column
        //arr1 moves along the column with help of row
        //arr2 moves along the row with help of col
        int sum = 0;
        while (row< arr2.length && col< arr1.length){
            //calc sum of products of elements in row and column
            sum+= arr1[row++][i2] * arr2[j1][col++];
        }
        return sum;
    }
}
