package chatbotProject;

public class ChatbotJessi implements Topic {
	
	private String[] keywords;
	private String goodbyeWords;
	private String secretWord;
	private String noResponse;
	private boolean chatting;
	private int wishCount;
	private ChatbotJane jane;
	
	public ChatbotJessi(){
		String[] temp = {"wish","wants","hope","need","craving","demand","fancy","longing","yearning"};
		keywords = temp;
		goodbyeWords = "bye";
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
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWords, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalkin();
				}else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
					ChatbotMain.print("You believe in magic too!! We are friends now. I will grant you an extra wish!");
					wishCount = wishCount + 1;
			}else {
				ChatbotMain.print("Huh. I don't really get you. Tell me something else?");
				if(ChatbotMain.findKeyword(response, noResponse, 0) >= 0) {
					ChatbotMain.print("Well I guess you really don't want to make any wishes...");
					wishCount = wishCount - 1;
				}
			}
		}
	}
	
	

}
