package 字典树或者前缀树.q面试题17_13恢复空格.f2;

/**
 * @ClassName : TrieNode
 * @Description :字典节点
 * @Author : zph
 * @Date: 2020-07-09 21:13
 * @Version : V1.0
 */
public class TrieNode {
    public boolean isWord;
    public TrieNode[] children=new TrieNode[26];
    public TrieNode(){

    }
}
