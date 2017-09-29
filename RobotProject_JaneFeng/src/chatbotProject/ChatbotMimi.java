package chatbotProject;

public class ChatbotMimi implements Topic {

	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ChatbotMimi() {
		String[] temp = {"food", "entertainment", "Internet", "video games"};
		keywords = temp;
		goodbyeWord = "bye";
		secretWord = "weenie";
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0)
				return true;
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		ChatbotMain.print("Hey! It sounds like you and I have a common interest! Let's talk some more!");
		chatting = true;
		
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalkin();
			}
			else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0)
				ChatbotMain.print("OMG you know weenie hut jr.?!??!??! We're BFFS!!!");
			else
				ChatbotMain.print("wat r u talkin aboot lol.");
		}
	}

}
