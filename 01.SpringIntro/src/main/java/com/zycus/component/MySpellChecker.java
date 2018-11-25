package com.zycus.component;

public class MySpellChecker implements SpellChecker {

	public void checkSpellingMistakes(String document) {
		System.out.println("checking spelling mistakes for " + document);
		Dictionary dictionary = new  MyDictionary();
		dictionary.checkWord(document);
	}
}
