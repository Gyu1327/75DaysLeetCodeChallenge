class WordDictionary {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode node = root;

        for(int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i) - 'a';

            if(node.child[index] == null)
            {
                node.child[index] = new TrieNode();
            }

            node = node.child[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        return check(word, 0, root);
    }

    public boolean check(String word, int pos, TrieNode node) {

        if(node == null)
        {
            return false;
        }

        if(pos == word.length())
        {
            return node.isEnd;
        }

        char ch = word.charAt(pos);

        if(ch == '.')
        {
            for(int i = 0; i < 26; i++)
            {
                if(check(word, pos + 1, node.child[i]))
                {
                    return true;
                }
            }
            return false;
        }
        else
        {
            int index = ch - 'a';
            return check(word, pos + 1, node.child[index]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
