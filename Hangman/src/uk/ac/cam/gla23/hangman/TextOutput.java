package uk.ac.cam.gla23.hangman;

import java.util.List;

public class TextOutput implements HangmanOutput{

	@Override
	public void outputWord(String w, boolean[] g) {
		System.out.print("");
		for(int i = 0; i < w.length();i += 1) {
			System.out.print(" ");
			if (g[i]) {
				System.out.print(w.substring(i, i+1));
			} else {
				System.out.print("_");
			}
			System.out.print("");
		}
		System.out.println("");
	}

	@Override
	public void outputGuessesLeft(int g) {
		System.out.println("GuessesLeft: "+Integer.toString(g));
	}

	@Override
	public void outputIncorrectGuesses(List<String> g) {
		
		System.out.print("Incorrect Guesses: ");
		
		for(int i = 0; i < g.size();i += 1) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(g.get(i));
		}
		System.out.println("");
	}

	@Override
	public void outputAlertCorrectLetter(String c) {
		System.out.println(c+" is a correct guess.");
	}

	@Override
	public void outputAlertIncorrectLetter(String c) {
		System.out.println(c+" is not a correct guess.");
	}

	@Override
	public void outputAskNextGuess() {
		System.out.println("Enter a guess.");
	}

	@Override
	public void outputHelp() {
		System.out.println("Enter the length of the word you wish to guess.");
		
	}

	@Override
	public void outputNoWordsOfThatLength() {
		System.out.println("There are no words of that length in the dictionary. Please enter another length.");
	}

	@Override
	public void outputAlertDictionaryReadFail() {
		System.out.println("Failed to read from dictionary file.");
	}

	@Override
	public void outputAlertGameOver(String word) {
		System.out.println("Incorrect! Unfortunately you were hanged. The word was "+word+".");
		System.exit(0);
	}

	@Override
	public void outputAlertAlreadyGuessed(String g) {
		System.out.println("You have already guessed the letter " + g + ".");
	}

	@Override
	public void outputUpdateHangman(List<String> g) {
		int wrongGuesses = g.size();
		String buffer = "        ";
		
		System.out.println(buffer + "  ______ ");
		
		System.out.print(buffer + "  ");
		if (wrongGuesses>=1) {
			System.out.print("|");
		} else {System.out.print(" ");}
		System.out.println("     |");
		
		System.out.print(buffer + " ");
		if (wrongGuesses>=4) {
			System.out.print("|");
		} else {System.out.print(" ");}
		if (wrongGuesses>=2) {
			System.out.print("o");
		} else {System.out.print(" ");}
		if (wrongGuesses>=5) {
			System.out.print("/");
		} else {System.out.print(" ");}
		System.out.println("    |");
		
		System.out.print(buffer + "  ");
		if (wrongGuesses>=3) {
			System.out.print("|");
		} else {System.out.print(" ");}
		System.out.println("     |");
		
		System.out.print(buffer + " ");
		if (wrongGuesses>=6) {
			System.out.print("/");
		} else {System.out.print(" ");}
		System.out.print(" ");
		if (wrongGuesses>=7) {
			System.out.print("|");
		} else {System.out.print(" ");}
		System.out.println("   /|");
		
		System.out.println(buffer + "______/_|");
	}

	@Override
	public void outputAlertGameWon() {
		System.out.println("Congrats you won!");
	}



}
