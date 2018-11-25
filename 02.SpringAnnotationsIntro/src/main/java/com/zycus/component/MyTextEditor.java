package com.zycus.component;

public class MyTextEditor implements TextEditor {

	private SpellChecker spellChecker;
	
	//setter injection
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}
	
	public void load(String document) {
		System.out.println("loaded " + document);
		//SpellChecker spellChecker = new MySpellChecker();
		spellChecker.checkSpellingMistakes(document);
	}
}

