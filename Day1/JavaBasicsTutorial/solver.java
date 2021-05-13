class solver
{
    static int board[][] = {{7, 8, 0, 4, 0, 0, 1, 2, 0}, {6, 0, 0, 0, 7, 5, 0, 0, 9}, {0, 0, 0, 6, 0, 1, 0, 7, 8}, {0, 0, 7, 0, 4, 0, 2, 6, 0},
        {0, 0, 1, 0, 5, 0, 9, 3, 0}, {9, 0, 4, 0, 6, 0, 0, 0, 5}, {0, 7, 0, 3, 0, 0, 0, 1, 2}, {1, 2, 0, 0, 0, 7, 4, 0, 0}, {0, 4, 9, 2, 0, 6, 0, 0, 7}};
    public static int[] find_empty(int[][] bo)
    {
        int[] a = {-1,-1};
        for(int i = 0; i < 9 ; i++)
            for(int j = 0; j < 9 ; j++)
                if(bo[i][j] == 0)
                {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
        return a;
    }
    public static boolean valid(int[][] bo, int num, int[] pos)
    {
        //Check row
        for(int i = 0; i<9; i++)
        {
            if(bo[pos[0]][i] == num && pos[1]!=i)
                return false;
        }
        //Check col
        for(int i = 0; i<9; i++)
        {
            if(bo[i][pos[1]] == num && pos[0]!=i)
                return false;
        }
        //Check box
        int bx = (int)Math.floor(pos[0] / 3);
        int by = (int)Math.floor(pos[1] / 3);
        for(int i = by * 3; i < by * 3 + 3; i++)
        {
            for(int j = bx * 3; j < bx * 3 + 3; j++)
            {
                if(bo[i][j] == num && pos[0] == i && pos[1] == j)
                    return false;
            }
        }
        return true;
    }
    public static boolean solve(int[][] board)
    {
        int[] a = find_empty(board);
        if(a[0] == -1)
            return true;
        int row = a[0];
        int col = a[1];
        for(int i = 1; i <= 9; i++)
        {
            if(valid(board, i, a))
            {
                board[row][col] = i;
                if(solve(board))
                {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        
        return false;
    }
    public static void print_board(int[][] bo)
    {
        for(int i = 0; i < 9; i++)
        {
            if(i % 3 == 0 && i != 0)
                System.out.println("- - - - - - - - - - - - -");
            for(int j = 0; j < 9; j++)
            {
                if(j % 3 == 0 && j != 0)
                    System.out.print(" | ");
                if(j == 8)
                    System.out.println(bo[i][j]);
                else
                    System.out.print(bo[i][j]+" ");
            }
        }
    }
    public static void main()
    {
        solver s = new solver();
        System.out.println();
        s.solve(board);
        s.print_board(board);
    }
}