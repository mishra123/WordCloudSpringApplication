package com.wordcloud.utils;

public class CompareWords implements Comparable<CompareWords> {
	public String wordFromMap;
	public int numberOfOccurrence;
	 
	public CompareWords(String word, int occurences){
     this.wordFromMap = word;
     this.numberOfOccurrence = occurences;
 }
	@Override
	public int compareTo(CompareWords o) {
		int compareWords = Integer.compare(o.numberOfOccurrence, this.numberOfOccurrence);
		return compareWords != 0 ? compareWords : wordFromMap.compareTo(o.wordFromMap);
	}
}
	