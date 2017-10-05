
package chatbotProject;

public class ChatbotLubna implements Topic {
	
	private String[] meanwords;
	private String[]  lovewords;
	private String  secretWord;
	private boolean chatting;
	private ChatbotJane jane;
	private String[] keywords;
	private String likeResponse;
	private boolean inLikeLoop;
	private String thingsLiked;
	private boolean userLikeStored;

	public ChatbotLubna() {
		String[] temp = {"ugly","dumb","mean", "stupid","dull","foolish"};
		meanwords = temp;
		String[] temp2 = {"lovely","nice","sweet","pretty","kind","great","like","love","beautiful","funny"};
		lovewords = temp2;
		secretWord = "potato";
		String[] temp3 = {"like","hate","cards"};
		keywords = temp3;
		//magic=jessi, stars= mimi,jane= crystal ball;
	}

	
	public boolean isTriggered(String response) {
		jane = ChatbotMain.chatbot.getJane();
		for(int i = 0; i<keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >=0){
				return true;
			}
		}
		
			return false;
		
	}
	public void startChatting(String response) {
		ChatbotMain.print("Welcome! Tell me something about yourself!");
		chatting =true;
		String userName=ChatbotMain.chatbot.name();
		while(chatting) {
			response = ChatbotMain.getInput();
			boolean keywordFound = false;
			for(int i=0; i<keywords.length; i++)
			{	
			 if(ChatbotMain.findKeyword(response, keywords[i], 0)>=0) {
				 if(i == 0)
				 {
					 ChatbotMain.print("What are some things you like?");
				 }
					inLikeLoop = true;
					while(inLikeLoop){
						likeResponse = ChatbotMain.getInput();
						int likePsn = ChatbotMain.findKeyword(likeResponse,"like",0);
						if( likePsn >= 0 ){
							thingsLiked = likeResponse.substring(likePsn+5);
							userLikeStored = true;
							ChatbotMain.print("You are such an" + "interesting" + " person, because you like "+thingsLiked+".");
						keywordFound = true;
						}
							//ChatbotMain.chatbot.getHello().printMoodyString();
							if(ChatbotMain.findKeyword(thingsLiked, , 0) >= 0){
								inLikeLoop = false;
								//ChatbotMain.chatbot.getSchool().talk();
							}
							else
							{
								inLikeLoop = false;
								//ChatbotMain.chatbot.talkForever();	
							}
							
						}
					}
			 		}
				if(!keywordFound){
				ChatbotMain.print("I don't understand you.");
			}
				 }
			
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
}
}*/
/* */