package Arrays;

import org.junit.Test;

public class RotateImage {
    //列逆序
    public void reverse(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length -1 - j];
                matrix[i][matrix[i].length -1 - j] = temp;
            }
        }

    }
    //转置
    public void transform(int[][] matrix){
        int len = matrix.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

    }
    public void rotate(int[][] matrix) {
        transform(matrix);
        reverse(matrix);
    }

    @Test
    public void mytest() {
        int[][] img = {
                {1,2,3},{4,5,6},{7,8,9}
        };
        rotate(img);
        for (int[] row:img){
            for (int col:row){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}
