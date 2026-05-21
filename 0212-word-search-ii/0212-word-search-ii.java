

class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();

        for(String word : words)
        {
            TrieNode node = root;

            for(char ch : word.toCharArray())
            {
                int index = ch - 'a';

                if(node.child[index] == null)
                {
                    node.child[index] = new TrieNode();
                }

                node = node.child[index];
            }

            node.word = word;
        }

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node)
    {
        if(i < 0 || j < 0 ||
           i >= board.length || j >= board[0].length)
        {
            return;
        }

        char ch = board[i][j];

        if(ch == '#' || node.child[ch - 'a'] == null)
        {
            return;
        }

        node = node.child[ch - 'a'];

        if(node.word != null)
        {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        dfs(board, i + 1, j, node);
        dfs(board, i - 1, j, node);
        dfs(board, i, j + 1, node);
        dfs(board, i, j - 1, node);

        board[i][j] = ch;
    }
}