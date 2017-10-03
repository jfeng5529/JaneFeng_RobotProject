
package chatbotProject;

public class ChatbotLubna implements Topic {
	
	private String[] meanwords;
	private String[]  lovewords;
	private String  secretWord;
	private boolean chatting;

	public ChatbotLubna() {
		String[] temp = {"ugly","dumb","mean", "stupid","dull","foolish"};
		meanwords = temp;
		String[] temp2 = {"lovely","nice","sweet","pretty","kind","great","like","love","beautiful","funny"};
		lovewords = temp2;
		secretWord = "potato";

	}

	
	public boolean isTriggered(String response) {
		for (int i = 0; i<meanwords.length; i++) {
			if(ChatbotMain.findKeyword(response, meanwords[i], 0) >= 0) {
				meanCount ++;
				return true;
			}
		}
			for (int i = 0; i<lovewords.length; i++) {
				if(ChatbotMain.findKeyword(response, lovewords[i], 0) >= 0) {
					loveCount ++;
					return true;
		}
			}
			return false;
		
	}

	public void startChatting(String response) {
		ChatbotMain.print("Hey! You could be a little nicer.");
		chatting = true;
		while(chatting) {
			 response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, lovewords, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalkin();
			}
			else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0){
				ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever. We area friends now.");
			}
			else {
				ChatbotMain.print("Huh. I don't really get you.");
			}
		}
	}
	public void practiceLove() {
		int loveCount = ChatbotMain.chatbot.getJane().getLoveCount();
	}
}
