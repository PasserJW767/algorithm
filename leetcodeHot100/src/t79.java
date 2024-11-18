public class t79 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // board，理解为字母棋盘
        // word，单词
        // i, 在棋盘上的行
        // j, 在棋盘上的列
        // k, 遍历到word中的哪一个

        // 超出边界，字符不是想要的，都返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) return true; // 如果长度合适了，就可以返回true了
        board[i][j] = '\0'; // 表示已经遍历过了
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k]; // 恢复，不要影响其他遍历
        return res;
    }
    public static void main(String[] args) {

    }
}
