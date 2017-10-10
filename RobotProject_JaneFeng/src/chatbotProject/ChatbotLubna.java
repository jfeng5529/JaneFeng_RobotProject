
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
		String[] temp3 = {"hate","food"};
		keywords = temp3;
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
		int responsecount = 1;
		ChatbotMain.print("Tell me something you like!");
		chatting =true;
		String userName=ChatbotMain.chatbot.name();
		while(chatting) {
			responsecount++;
			response = ChatbotMain.getInput();
			boolean keywordFound = false;
			inLikeLoop = true;
			while(inLikeLoop && responsecount < 4) {
				responsecount++;
				
				likeResponse = response;
				int likePsn = likeResponse.indexOf("like");
				if(likePsn > -1) {
					thingsLiked = likeResponse.substring(likePsn+5);
					userLikeStored = true;
					if(thingsLiked.length( ) > 10) {
						ChatbotMain.print("That's so interesting. Do you want to know what I know about you ;)");
					}
					else {
						ChatbotMain.print("You are such an interesting person, because you like "+ thingsLiked + "." + " Since you've entered the fortune cookie world, do you want to talk about your fortune, or your zodiac signs?? Oh or maybe you want to make some wishes?  "); 
					}
				
				}
				else {
					thingsLiked = likeResponse;
					
					if(thingsLiked.length( ) > 10) {
						ChatbotMain.print("That's so interesting. Do you want to know what I know about you ;)");
					}
					else {
						ChatbotMain.print("You are such an interesting person, because you like "+ thingsLiked + "." + " Since you've"
								+ " entered the fortune cookie world, do you want to talk about your fortune, or your zodiac signs?? Oh "
								+ " or maybe you want to make some wishes?");
					}
				}
					inLikeLoop = false;
					ChatbotMain.chatbot.resume();
					}
				}
			for(int i=0; i<keywords.length; i++)
			{	
			 if(ChatbotMain.findKeyword(response, keywords[i], 0)>=0) {
				 if(i == 0)
				 {
					 ChatbotMain.print("What are some things you like?");
				 }
							
							if(ChatbotMain.findKeyword(thingsLiked,"" , 0) >= 0){
								inLikeLoop = false;
								
							}
							else
							{
								inLikeLoop = false;
		
							}
							
						}
					}
	}

	public String[] meanWords() {
		return meanwords;
	}
	public String[] lovewWords() {
		return lovewords;
	}

	public void decreaseLove(String response){
		for (int i = 0; i<meanwords.length; i++) {
			if(ChatbotMain.findKeyword(response, meanwords[i], 0) >= 0) {
			jane.decreaseLoveCount();
	}
		}
	}
	public void increaseLove(String response) {
		for (int i = 0; i<lovewords.length; i++) {
			if(ChatbotMain.findKeyword(response, lovewords[i], 0) >= 0) {
				jane.increaseLoveCount();
			}	
		}
	}
}

/*if(!keywordFound){
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