package uk.ac.cam.gla23.hangman;

import java.io.IOException;

public class Hangman {

	// Output and input modules
	HangmanOutput outputModule;
	HangmanInput inputModule;

	Dictionary dictionary;

	int guessesLeft = 7;
	int wordSize;
	Word word;
	String guess;

	private void playGame() {

		// Setup output and input modules
		outputModule = new TextOutput();
		inputModule = new TextInput(this);

		// Create dictionary
		try {
			dictionary = new Dictionary("src\\uk\\ac\\cam\\gla23\\hangman\\dictionary.txt");
		} catch (IOException e) {
			outputModule.outputAlertDictionaryReadFail();
			return;
		}

		// Help
		outputModule.outputHelp();

		// Ask for word size and get it
		String w = "";
		
		while(w == ""){
			int wordLength = inputModule.inputSize();
			w = dictionary.getWordOfLength(wordLength);
			if (w == "") {
				outputModule.outputNoWordsOfThatLength();
			};
		}
		word = new Word(w);

		while (!word.wordGuessed()) {

			// input guess
			outputModule.outputAskNextGuess();

			guess = inputModule.inputGuess();
			if (word.guessAlreadyGuessed(guess)) {
				outputModule.outputAlertAlreadyGuessed(guess);
			} else {
				if (word.guessLetter(guess)) {
					outputModule.outputAlertCorrectLetter(guess);
				} else {
					outputModule.outputAlertIncorrectLetter(guess);
					guessesLeft -= 1;
					if (guessesLeft == 0) {
						word.outputUpdateHangman(this);
						outputModule.outputAlertGameOver(w);
					}
				}

				outputModule.outputGuessesLeft(guessesLeft);
				word.outputIncorrectGuesses(this);
				word.outputUpdateHangman(this);
				word.outputWord(this);

			}
		}
		outputModule.outputAlertGameWon();
	}

	public static void main(String[] args) {

		Hangman game = new Hangman();

		game.playGame();

	}
}
