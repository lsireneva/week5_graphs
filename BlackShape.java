import java.util.ArrayList;

public class BlackShape {

    public static void main(String[] args){
        BlackShape b = new BlackShape();
        ArrayList<String> a = new ArrayList<String>();
        a.add("OOOXOOO");
        a.add("OOXXOXO");
        a.add("OXOOOX0");

        System.out.println(b.black(a));
    }

    public int black(ArrayList<String> A) {
        int[][] matrix = new int[A.size()][A.get(0).length()];
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).length();j++){
                if(A.get(i).charAt(j)=='O')
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = 1;
            }
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==1){
                    dfs(matrix,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int matrix[][],int row,int column){
        if(row>=matrix.length || row<0) return;
        if(column>=matrix[0].length || column<0) return;
        if(matrix[row][column]!=1) return;
        else{
            matrix[row][column] = Integer.MIN_VALUE;
            dfs(matrix,row+1,column);
            dfs(matrix,row,column+1);
            dfs(matrix,row-1,column);
            dfs(matrix,row,column-1);
        }
    }
}
