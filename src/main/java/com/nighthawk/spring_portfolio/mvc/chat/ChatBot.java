package com.nighthawk.spring_portfolio.mvc.chat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
	
/**
 * This class represents a simple chatbot that responds to user input based on a training data file.
 */
public class ChatBot {
	private List<String> trainingData;
	
	/**
	 * Constructor to initialize the chatbot with the training data from a file.
	 *
	 * @param trainingDataFile The file path of the training data file.
	 * @throws IOException if there is an error reading the training data file.
	 */
	public ChatBot(String trainingDataFile) throws IOException {
		trainingData = loadTrainingData(trainingDataFile);
	}
	
	/**
	 * Loads the training data from a file into a list of strings.
	 *
	 * @param trainingDataFile The file path of the training data file.
	 * @return Returns a list of strings containing the training data.
	 * @throws IOException if there is an error reading the training data file.
	 */
	private List<String> loadTrainingData(String trainingDataFile) throws IOException {
		List<String> data = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(trainingDataFile));
		String line;
		while ((line = reader.readLine()) != null) {
			data.add(line);
		}
		reader.close();
		return data;
	}
	
	/**
	 * Generates a random response from the training data.
	 *
	 * @return Returns a randomly selected response from the training data.
	 */
	private String generateResponse() {
		Random random = new Random();
		int index = random.nextInt(trainingData.size());
		return trainingData.get(index);
	}
	
	/**
	 * Starts the chatbot and interacts with the user.
	 */
	public void startChat() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Chatbot: Hello! How can I assist you today?");
		while (true) {
			System.out.print("User: ");
			String userInput = scanner.nextLine();
			if (userInput.equalsIgnoreCase("exit")) {
				System.out.println("Chatbot: Goodbye! Have a nice day!");
				break;
			}
			String response = generateResponse();
			System.out.println("Chatbot: " + response);
		}
		scanner.close();
	}
	
	/**
	 * Main method to run the chatbot.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		try {
			ChatBot chatbot = new ChatBot("traindata.txt");
			chatbot.startChat();
		} catch (IOException e) {
			System.out.println("Error loading training data: " + e.getMessage());
		}
	}
}