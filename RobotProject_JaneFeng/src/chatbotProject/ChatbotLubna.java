
package chatbotProject;

public class ChatbotLubna implements Topic {
	
	private String[] meanwords;
	private String[]  lovewords;
	private String  secretWord;
	private boolean chatting;
	private ChatbotJane jane;
	private String[] keywords;

	public ChatbotLubna() {
		String[] temp = {"ugly","dumb","mean", "stupid","dull","foolish"};
		meanwords = temp;
		String[] temp2 = {"lovely","nice","sweet","pretty","kind","great","like","love","beautiful","funny"};
		lovewords = temp2;
		secretWord = "potato";
		String[] temp3 = {"food","dates","interests", "like","jokes","magic","stars","crystal ball"};
		keywords = temp3;
		//magic=jessi, stars= mimi,jane= crystal ball;
	}

	
	public boolean isTriggered(String response) {
		jane = ChatbotMain.chatbot.getJane();
		for(int i = 0; i<keywords.length; i++) {
			if)(ChatbotMain.findKeyword(response, keywords[i], 0) >=0){
				return true;
			}
		}
		/*for (int i = 0; i<meanwords.length; i++) {
			if(ChatbotMain.findKeyword(response, meanwords[i], 0) >= 0) {
				jane.decreaseLoveCount();
				return true;
			}
		}
			for (int i = 0; i<lovewords.length; i++) {
				if(ChatbotMain.findKeyword(response, lovewords[i], 0) >= 0) {
					jane.increaseLoveCount();
					return true;
		}*/
			}
			return false;
		
	}
	public void startChatting(String response) {
		ChatbotMain.print();
	}

	/*public void startChatting(String response) {
		ChatbotMain.print("Aww you so sweet!");
		chatting = true;
		while(chatting) {
			 response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, lovewords[0], 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.resume();
			}
			else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0){
				ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever. We area friends now.");
			}
			else {
				ChatbotMain.print("Huh. I don't really get you.");
			}
		}
	}*/
	public void practiceLove() {
		int loveCount = ChatbotMain.chatbot.getJane().getLoveCount();
	}
	public String[] meanWords() {
		return meanwords;
	}
	public String[] lovewWords() {
		return lovewords;
	}
}
