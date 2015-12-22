package uk.ac.cam.gla23.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextInput implements HangmanInput {
	
	Hangman main;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	TextInput(Hangman control) {
		main = control;
	}
	
	@Override
	public String inputGuess() {
		
		String input = "";
		while (input.length() != 1){
			try {
				input = br.readLine();
			} catch (IOException e) {
				System.out.println("Failed to get input from the user.");
				e.printStackTrace();
			}
		}
		
		return input;
	}

	@Override
	public int inputSize() {
		
		Integer i = null;
		
		while(i == null) {
			try{
				
	            i = Integer.parseInt(br.readLine());
	        } catch(NumberFormatException e) {
	            
	        } catch (IOException e) {
	        	System.out.println("Failed to get input from the user.");
				e.printStackTrace();
			}
		}
		
		return i;
	}
}
