package uk.ac.cam.gla23.hangman;

import java.util.ArrayList;
import java.util.List;

public class Word {

	Word(String w) {
		word = w;
		length = w.length();
		lettersGuessed = new boolean[length];
	}

	private int length;
	private String word;
	private boolean[] lettersGuessed;
	private List<String> incorrectGuesses = new ArrayList<String>();

	public void outputWord(Hangman h) {
		h.outputModule.outputWord(word, lettersGuessed);
	}

	public void outputIncorrectGuesses(Hangman h) {
		h.outputModule.outputIncorrectGuesses(incorrectGuesses);
	}

	public void outputUpdateHangman(Hangman h) {
		h.outputModule.outputUpdateHangman(incorrectGuesses);
	}

	public int getLength() {
		return length;
	}

	public boolean wordGuessed() {
		for (int i = 0; i < length; i++) {
			if (lettersGuessed[i] == false) {
				return false;
			}
		}
		return true;
	}

	public boolean guessAlreadyGuessed(String s) {
		/// used to check whether the letter has already been guessed so that
		/// the consequences will only happen once.
		if (incorrectGuesses.contains(s)) {
			return true;
		}
		for (int i = 0; i < word.length(); i++) {
			if (lettersGuessed[i] == true)
				if (Character.toString(word.charAt(i)).equals(s)) {
					return true;
				}
		}
		return false;
	}

	public boolean guessLetter(String s) {
		/// Used to update the letters guessed in this word.
		/// returns true if the letter was correct
		/// you have to check beforehand if an incorrect letter has already been
		/// guessed.
		Boolean letterChanged = false;
		for (int i = 0; i < word.length(); i++) {
			if (Character.toString(word.charAt(i)).equals(s)) {
				lettersGuessed[i] = true;
				letterChanged = true;
			}
		}
		if (letterChanged == false) {
			incorrectGuesses.add(s);
		}
		return letterChanged;
	}

}
