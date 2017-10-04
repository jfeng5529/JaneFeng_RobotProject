package chatbotProject;

public class ChatbotMimi implements Topic {

	private String[] keywords;
	private String[] horoscopeKeywords;
	private String[] zodiacKeywords;
	private boolean chatting; 
	private String goodbyeWord;
	private String secretWord;
	private ChatbotJane jane;
	
	public ChatbotMimi() {
		String[] temp = {"zodiac", "horoscope"};
		keywords = temp;
		String[] temp1 = { "aries", "taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio", "sagittarius", "capricorn", "aquarius", "pisces"};
		horoscopeKeywords = temp1;
		String[] temp2 = {"rat", "ox", "tiger", "rabbit", "dragon", "snake", "horse", "sheep", "monkey", "rooster", "dog", "pig"};
		zodiacKeywords = temp2;
		String temp3 = "bye";
		goodbyeWord= temp3;
		secretWord = "weenie";
		}

	@Override
	public boolean isTriggered(String response) {
		jane = ChatbotMain.chatbot.getJane();
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0)
				return true;
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		ChatbotMain.print("Ooh! I love talking about this! Tell me when you were born, and I'll give you your fortune. ( ͡° ͜ʖ ͡°)");
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
	
	public void practiceLove() {
		int loveCount = ChatbotMain.chatbot.getJane().getLoveCount();
	}

}

//comment
