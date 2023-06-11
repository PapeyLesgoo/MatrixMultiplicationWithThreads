import java.util.Random;
import java.util.Scanner;

public class Q1Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 last digits of roll number");
        int k = sc.nextInt();
        //get sum of last 2 digits of roll number
        int n = k%10 + k/10;
        //arr1 and arr2 are multiplied and result stored in arr3
        int arr1[][] = new int[n][n];
        int arr2[][] = new int[n][n];
        int arr3[][] = new int[n][n];
        Random r = new Random();
        Object a = new Object();
        //generating random values in array
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1.length ; j++){
                arr1[i][j] = r.nextInt(10);
                arr2[i][j] = r.nextInt(10);
            }
        }
        System.out.println("Printing Array 1");
        PrintArr(arr1);
        System.out.println("Printing Array 2");
        PrintArr(arr2);
        //Creating threads for each row
        //Each thread responsible for multiplication of their own row
        Thread[] myThreads = new Thread[n*n];
        for (int i = 0; i < n; i++){
            //initializing all threads with row number
            myThreads[i] = new Thread(new MyRunnable(arr1,arr2,arr3,i));
        }

        for (int i = 0; i < n; i++){
            //starting threads causing run to be called in MyRunnable
            myThreads[i].start();
        }
        synchronized (a){
            //to synchronize result, if not used matrix will be filled with 0s
            a.wait(5000);
        }
        System.out.println("Printing result array");
        PrintArr(arr3);
    }
    
    public static void PrintArr(int arr[][]){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length ; j++){
                int temp = arr[i][j]/10;
                if(temp == 0){
                    System.out.print("00" + arr[i][j] + " ");
                }else if(temp < 10){
                    System.out.print("0" + arr[i][j] + " ");
                }
                else{
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}