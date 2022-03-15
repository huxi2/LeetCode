package Arrays;

import org.junit.Test;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int length=board.length;
        //二维数组表示第i行的10个数是否出现过
        boolean[][] cols=new boolean[length][length];
        boolean[][] rows=new boolean[length][length];
        boolean[][] cels=new boolean[length][length];

        //行列判断
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(board[i][j]!='.'){
                    int temp=board[i][j]-'1';
                    //判断行
                    if(rows[i][temp]){
                        return false;
                    }else{
                        rows[i][temp] = true;
                    }
                    //判断列
                    if(cols[j][temp]){
                        return false;
                    }else{
                        cols[j][temp] = true;
                    }
                    //判断是第几个单元格
                    int cell = j/3 + (i/3)*3;
                    if(cels[cell][temp]){
                        return false;
                    }else{
                        cels[cell][temp]=true;
                    }
                }
            }
        }
        //
        return true;
    }

    @Test
    public void mytest() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        System.out.println(isValidSudoku(board));

    }
}