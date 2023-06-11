public class MyRunnable extends MatrixTemp implements Runnable{
    int arr1[][], arr2 [][], arr3[][], i = 0, j = 0;

    @Override
    public void run() {
        int k = 0;
        while (k<arr2.length){
            //moving along row and calling Mult from MatrixTemp
            //Mult is responsible for calculating the value of this specific element
            arr3[i][k] = Mult(arr1,arr2,i,k);
            k++;
        }
    }


    public MyRunnable(int[][] arr1, int[][] arr2, int[][] arr3, int i) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.arr3 = arr3;
        this.i = i;
    }
}
