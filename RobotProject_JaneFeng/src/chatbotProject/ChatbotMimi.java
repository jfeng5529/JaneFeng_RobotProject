package chatbotProject;

public class ChatbotMimi implements Topic {

	private String[] keywords;
	private String[] horoscopeKeywords;
	private String[] zodiacKeywords;
	private boolean chatting; 
	private String goodbyeWord;
	private String secretWord;
	private ChatbotJane jane;
	private String[] meanwords;
	private String[]  lovewords;

	public ChatbotMimi() {
		String[] temp = {"zodiac", "horoscope"};
		keywords = temp;
		String[] temp1 = { "aries", "taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio", "sagittarius", "capricorn", "aquarius", "pisces"};
		horoscopeKeywords = temp1;
		String[] temp2 = {"rat", "ox", "tiger", "rabbit", "dragon", "snake", "horse", "sheep", "monkey", "rooster", "dog", "pig"};
		zodiacKeywords = temp2;
		String temp3 = "bye";
		goodbyeWord= temp3;
		secretWord = "orion's belt";
	}

	// make a method so that it checks which index of the array the input matches, then output a different message depending on the index
	
	public boolean isTriggered(String response) {
		jane = ChatbotMain.chatbot.getJane();
		for (int i = 0; i<meanwords.length; i++) {
			if(ChatbotMain.findKeyword(response, meanwords[i], 0) >= 0) {
				jane.decreaseLoveCount();

				jane = ChatbotMain.chatbot.getJane();
				for(int j = 0; j < keywords.length; j++) {
					if(ChatbotMain.findKeyword(response, keywords[j], 0) >= 0)
						return true;
				}
			}
			for (int j = 0; j<lovewords.length; j++) {
				if(ChatbotMain.findKeyword(response, lovewords[j], 0) >= 0) {
					jane.increaseLoveCount();
					return true;
				}
			}
		}
		return false;
	}

	public void startChatting(String response) {
		ChatbotMain.print("Ooh! I love talking about this! Tell me when you were born, and I'll give you your fortune. ( ͡° ͜ʖ ͡°)");
		chatting = true;

		while(chatting) {
			response = ChatbotMain.getInput();
//			String zodiac = getZodiac(response);
			String zodiac = findKeywords(response, zodiacKeywords);
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.resume();
			}

			else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0)
				ChatbotMain.print("I love counting the stars! Glad you do too :)");
			else if(findKeywords(response, keywords) != null) {
				ChatbotMain.print("Excellent! Tell me when you were born");
				// user input
				// reply with array of responses  
			}
			else if(zodiac != null)
				tellHoroscope(zodiac);
			else
				ChatbotMain.print("wat r u talkin aboot lol.");
		}
	}

	public static String findKeywords(String response, String [] keywords) {
		for(int i=0; i<keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return keywords[i];
			}
		}
		return null;
	}

	private void tellHoroscope(String zodiac) {
		// this is what the bot returns after the user inputs their birth date.
		 //if (zodiac = keywords) {
			ChatbotMain.print("The intensity should increase around an issue regarding love and romance. Friction is building. Unfortunately, this tension may be unavoidable. It's likely that some sort of power struggle is being thrown into the mix, and you may fight for control of your emotions. Try not to get sucked into a bottomless pit.");
			/*
			 * Taurus = "Let your heart shine. Love surrounds you like a beautiful pink cloud, and you can't help but attract people to you. Take romance to a higher level with someone really special tonight. You'll find that whatever you give will come back to you tenfold. Your aura glows brightly with emotion, so let it light your way."
			 * Gem = There's a great deal of transforming energy in the air that you should harness and capitalize on. You may be a fan of the diet that you'll start "tomorrow." When tomorrow comes and there's a huge meal of pizza, soda, and fries, suddenly the diet once again starts "tomorrow." Use the powerful energy of today to break out of this habit and make a real change in your life.
			 * Canc = You may experience writer's block in every sense of the phrase. Even if you don't consider yourself a writer, for some reason it may be difficult to get even the simplest words down on paper. Don't get upset. Your verbal juices may not be flowing freely, but they haven't disappeared. Use this time to read other people's works and visit museums for inspiration.
			 * Leo = Action should be your main priority, especially when it comes to love and romance. You may not be too concerned about what sort of action you take. Your only concern is that you aren't sitting still at any time. Once you figure out what you want, you're unlikely to stop until you get it. Your power is forceful and extreme.
			 * Virgo = A surprise in love and romance is on its way to you. Things are coming full circle, and the investment you made in this realm is finally paying off. Something new is cropping up, but in reality, this is a result of things you set in motion long ago. Be open to embracing the tremendous flow of love and beauty that's coming your way.
			 * 
			 */
		}

	//}

//	public String getZodiac(String input) {
//		//returns word in the array based on their birthday.
//		//returns null if it doesn't get anything.
//		for (int i = 0; i < horoscopeKeywords.length; i++) {
//			if(ChatbotMain.findKeyword(input, keywords[i], 0) >= 0) {
//				// look for what the input was inside of the array
//				tellHoroscope(input);
//			}
//			else {
//				for (int i = 0; i < zodiacKeywords.length; i++) {
//					// do the same, but look in the zodiac array
//					tellHoroscope(input);
//				}
//			}
//
//		}
//		return null;
//		ChatbotMain.print("You might've made a mistake. Could you please repeat when you were born?");
//	}

	public void practiceLove() {
		int loveCount = ChatbotMain.chatbot.getJane().getLoveCount();
	}

}
//comment 
