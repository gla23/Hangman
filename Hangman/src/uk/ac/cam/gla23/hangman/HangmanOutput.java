package uk.ac.cam.gla23.hangman;

import java.util.List;

public interface HangmanOutput {
	
	// Show current game state
	public void outputWord(String w,boolean[] g);
	public void outputGuessesLeft(int g);
	public void outputIncorrectGuesses(List<String> g);
	public void outputUpdateHangman(List<String> g);
	// Messages
	public void outputAlertCorrectLetter(String c);
	public void outputAlertAlreadyGuessed(String g);
	public void outputAlertIncorrectLetter(String c);
	public void outputAlertDictionaryReadFail();
	public void outputAlertGameOver(String word);
	public void outputAlertGameWon();
	// Prompts
	public void outputAskNextGuess();
	
	
	// Setup
	public void outputHelp();
	public void outputNoWordsOfThatLength();
	
	
}
