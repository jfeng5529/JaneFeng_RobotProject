package chatbotProject;

public class ChatbotJane implements Topic {

	private String[] keywords; 
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ChatbotJane() {
		String[] temp = {"food", "entertainment", "Internet", "Video games"};
		keywords = temp;
		String temp2 = "bye";
		goodbyeWord= temp2;
		secretWord = "bubble tea";
	}

	public boolean isTriggered(String response) {
		for(int i =0; i<keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0)>=0) {
				return true;
			}
		}
		return false;
	}

	public void startChatting(String response) {
		ChatbotMain.print("Hey! sounds like you and I have a common interest! Let's talk some more!");
		chatting =true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0)>=0) {
				chatting = false;
				ChatbotMain.chatbot.startTalkin();
			}
			else if(ChatbotMain.findKeyword(response, secretWord, 0)>=0)
			{
				ChatbotMain.print("Oh my goodness! you guessed my favorite thing ever. We are friends now.");
			}
			else {
				ChatbotMain.print("I don't really get you. tell me something else?");
			}
		}
	}

}
