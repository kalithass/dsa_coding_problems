package strivers.graph.problem.wordLadder1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordLadderISingleDirection {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> frontQueue = new HashSet<>();
        Set<String> backQueue = new HashSet<>();
        if(!wordSet.contains(endWord)) return 0;
        frontQueue.add(beginWord);
        backQueue.add(endWord);
        int frontLen = 1;
        int endLen = 1;
        while(!frontQueue.isEmpty() && !backQueue.isEmpty()) {

                Set<String> newStart = new HashSet<>();
                Set<String> newEnd = new HashSet<>();

                char[] ar;
                char temp;
                String val;
                // String word;

                // front operations
                for(String word : frontQueue) {
                    ar = word.toCharArray();
                    for(int i=0;i<word.length();i++) {
                        temp = ar[i];
                        for(char ch='a';ch<='z';ch++) {
                            if(temp == ch) continue;
                            ar[i] = ch;
                            val = new String(ar);
                            if(backQueue.contains(val)) {
                                return frontLen+endLen;
                            }
                            // System.out.println(val);
                            if(wordSet.contains(val)) {
                                wordSet.remove(val);
                                newStart.add(val);
                            }
                        }
                        ar[i] = temp;
                    }
                }
                frontQueue = newStart;
                frontLen++;
                // System.out.println(frontLen+" "+frontQueue);


                // back operations
                for(String word: backQueue) {
                    ar = word.toCharArray();
                    for(int i=0;i<word.length();i++) {
                        temp = ar[i];
                        for(char ch='a';ch<='z';ch++) {
                            if(temp == ch) continue;
                            ar[i] = ch;
                            val = new String(ar);
                            if(frontQueue.contains(val)) {
                                return frontLen+endLen;
                            }
                            if(wordSet.contains(val)) {
                                wordSet.remove(val);
                                newEnd.add(val);
                            }
                        }
                        ar[i] = temp;
                    }
                }
                backQueue = newEnd;
                endLen++;
        }
        return 0;
    }
}