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
		
		jane = ChatbotMain.chatbot.getJane();
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i< keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		ChatbotMain.print("Tell me your 3 wishes and I will make them come true!");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWords, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalkin();
				}else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
					ChatbotMain.print("You believe that magic is real too!! We are friends now. I will grant you an extra wish!");
					wishCount = wishCount + 1;
			}else {
				ChatbotMain.print("Huh. I don't really get you. Tell me something else?");
				if(ChatbotMain.findKeyword(response, noResponse, 0) >= 0) {
					wishCount = wishCount - 1;
				}
			}
		}
	}
	
	public void practiceLove() {
		int loveCount = ChatbotMain.chatbot.getJane().getLoveCount();
	}

}
