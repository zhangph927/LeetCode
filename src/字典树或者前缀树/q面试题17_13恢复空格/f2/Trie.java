package 字典树或者前缀树.q面试题17_13恢复空格.f2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Trie
 * @Description :字典树
 * @Author : zph
 * @Date: 2020-07-09 21:31
 * @Version : V1.0
 */
public class Trie {
   public TrieNode root;
   public Trie(){
       root=new TrieNode();
   }
   /**
    * @Title insert
    * @Description 将单词倒序插入字典树
    * @Author zph
    * @Date 2020/7/9 21:32
    * @Param [word]
    * @return void
    */
   public void insert(String word){
       TrieNode cur=root;
       int length=word.length();
       char[] chars = word.toCharArray();
       for(int i=length-1;i>=0;i--){
           int ch=chars[i]-'a';
           if(cur.children[ch]==null){
               cur.children[ch]=new TrieNode();
           }
           cur=cur.children[ch];
       }
       cur.isWord=true;
   }
   /**
    * @Title search
    * @Description 找到 sentence 中以 endPos 为结尾的单词，返回这些单词的开头下标。
    * @Author zph
    * @Date 2020/7/9 21:42
    * @Param [sentence, endPos]
    * @return java.util.List<java.lang.Integer>
    */
   public List<Integer> search(String sentence,int endPos){
       List<Integer> res = new ArrayList<>();
       TrieNode cur=root;
       char[] chars = sentence.toCharArray();
       for(int i=endPos;i>=0;i--){
           int ch=chars[i]-'a';
           if(cur.children[ch]==null){
               break;
           }
           cur=cur.children[ch];
           if(cur.isWord){
               res.add(i);
           }
       }
       return res;
   }


}
