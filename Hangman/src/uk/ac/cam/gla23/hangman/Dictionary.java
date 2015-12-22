package uk.ac.cam.gla23.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary {

	Dictionary(String filename) throws IOException {
		// Imports words from the dictionary file into a list of
		// lists containing words of the same length.
		FileReader f = new FileReader(filename);
		BufferedReader b = new BufferedReader(f);

		dictionary = new ArrayList<ArrayList<String>>();

		String nextWord = b.readLine();

		int wordLength;

		while (nextWord != null) {
			// Input the words into the dictionary
			wordLength = nextWord.length();
			// increase the size of the list so that its not larger than the
			// largest word
			while (dictionary.size() < wordLength) {
				dictionary.add(new ArrayList<String>());
			}
			dictionary.get(wordLength - 1).add(nextWord);
			nextWord = b.readLine();
		}
		f.close();
		b.close();
	}

	private ArrayList<ArrayList<String>> dictionary;

	public String getWordOfLength(int l) {
		// returns a random word in the dictionary of length l, and returns ""
		// if there are no words of that length in the dictionary
		if (l <= 0 || l > dictionary.size()) {
			return "";
		}
		int innerListSize = dictionary.get(l - 1).size();
		if (innerListSize == 0) {
			return "";
		}

		Random r = new Random();
		return dictionary.get(l - 1).get(r.nextInt(innerListSize));

	}

}
