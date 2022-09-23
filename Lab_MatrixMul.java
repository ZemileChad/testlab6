 import java.util.Arrays;
public class Lab_MatrixMul {
 public static void main(String[] args) {
    int[][] inputA = { { 5, 6, 7 }, { 4, 8, 9 } };
    int[][] inputB = { { 6, 4 }, { 5, 7 }, { 1, 2 } };
    MyData matA = new MyData(inputA);
    MyData matB = new MyData(inputB);
    int matC_r = matA.data.length;
    int matC_c = matB.data[0].length;
    MyData matC = new MyData(matC_r, matC_c);
    //q4
    Thread t1 = new Thread(new MatrixMulThread(matC_r, matC_c, matA, matB, matC));
    t1.start();
    //q5
    try{
        t1.join();
    }catch(Exception e) { System.out.println(e);}
        matC.show();
    }
}
 class MatrixMulThread implements Runnable {
    int processing_row; int processing_col;
    MyData datA; MyData datB; MyData datC;
    MatrixMulThread(int tRow, int tCol,MyData a, MyData b, MyData c) {
        //q1
        processing_row = tRow;
        processing_col = tCol;
        datA = a;
        datB = b;
        datC = c;
        
 }
    /*q2*/ public void run() {
            //q3
            int sum = 0;
            for(int i = 0; i < processing_row; i++){
                for(int j = 0; j < processing_col; j++){
                    for(int k = 0; k < datA.data[0].length; k++){
                        sum += datA.data[i][k] * datB.data[k][j];
                    }
                    datC.data[i][j] = sum;
                    sum = 0;
                }
            }
            //System.out.println("perform sum of multiplication of assigned row and col");
}
} //class
 class MyData {
    int[][] data;
    MyData(int[][] m) { data = m; }
    MyData(int r, int c) {
        data = new int[r][c];
        for (int[] aRow : data)
            Arrays.fill(aRow, 9);

 }
    void show() {
        System.out.println(Arrays.deepToString(data));
 }
} //class