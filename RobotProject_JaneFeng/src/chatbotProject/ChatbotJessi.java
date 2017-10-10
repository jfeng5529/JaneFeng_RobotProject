package chatbotProject;

public class ChatbotJessi implements Topic {
	
	private String[] keywords;
	private String[] compliments;
	private String[] goodbyeWords;
	private String secretWord;
	private String noResponse;
	private boolean chatting;
	private int wishCount;
	private ChatbotJane jane;
	private int loveCount;																																								
	
	public ChatbotJessi(){
		String[] temp = {"wish","wishes","wants","hope","need","craving","demand","fancy","longing","yearning"};
		keywords = temp;
		String[] temp2 = {"adorable","authentic","amazing","awesome","best","brillant","cool","divine","fabulous","generous","giving","incredible","magnificient","nice","outstanding","powerful","vibrant"};
		compliments = temp2;
		String[] temp3 = {"bye","goodbye","see you", "adios","aloha","ciao","farewell","later"};
		goodbyeWords = temp3;
		secretWord = "magic";
		noResponse = "";	
	}

	@Override
	public boolean isTriggered(String response) {
		jane = ChatbotMain.chatbot.getJane();
		for(int i = 0; i< keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		ChatbotMain.print("Tell me your wishes and I will make them come true!");
		chatting = true;
		loveCount = jane.getLoveCount();
		if(loveCount > 0) {
			wishCount = 3;
			ChatbotMain.print("You have "+wishCount+" wishes to make!!!");
		}
		else if(loveCount == 0) {
			ChatbotMain.print("I see that you have just entered the fortune cookie world. Well aren't you greedy!!! Complimemt me! ");
			for(int i = 0; i< keywords.length; i++) {
				if(ChatbotMain.findKeyword(response, compliments[i], 0) >= 0) {
					wishCount = 2;
					ChatbotMain.print("You have "+wishCount+" wish to make!");
				}
				else {
					wishCount = 0;
					ChatbotMain.print("U");
				}
			}
		}
		else {
			wishCount = 1;
			ChatbotMain.print("Hmmmm...wait your attitude and the things you said earlier wasn't that nice. I will grant you "+wishCount+" and only "+wishCount+" wish.");
		}
		while(chatting) {
			response = ChatbotMain.getInput();
			for(int i = 0; i< keywords.length; i++) {
				if(ChatbotMain.findKeyword(response, goodbyeWords[i], 0) >= 0) {
					chatting = false;
					if(loveCount > 0) {
						ChatbotMain.print("Can't think of any wishes right now? It's okay! Feel free to come back anytime for your wishes to be granted!");
					}
					else {
						ChatbotMain.print("Good riddance! =P");
					}
					ChatbotMain.chatbot.startTalkin();
					}else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
						ChatbotMain.print("You believe in magic too!! We are buddies now. I will grant you an extra wish!");
						wishCount = wishCount + 1;
						ChatbotMain.print("You now have "+wishCount+" wishes.");
				}else {
					if(ChatbotMain.findKeyword(response, noResponse, 0) >= 0) {
						ChatbotMain.print("Well I guess you really don't want to make any wishes...");
						wishCount = wishCount - 1;
						ChatbotMain.print("You now have "+wishCount+" wishes.");
						chatting = false;
						
						ChatbotMain.print("Huh. I don't really get you. Tell me something else?");
						ChatbotMain.chatbot.resume();
					}
				}
			}
		}
	}
	//public String wishes(){
		
	//}
	
	

}

// wish count based on count of love and mean responses (loveCount)
// answers refers to user's wish!
// compliment me (wish section when love count == 0)