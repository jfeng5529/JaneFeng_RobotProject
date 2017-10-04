package chatbotProject;

public class ChatbotJane implements Topic {

	private String[] keywords; 
	private String[] goodbyeWords;
	private String secretWord;
	private String[] answerWords;
	private boolean chatting;
	private int loveCount;
	private String[] meanResponse;
	private String[] loveResponse;
	private String[] goodbyeResponse;
	
	public ChatbotJane() {
		String[] temp = {"fortune", "future", "luck", "success", "failure"};
		keywords = temp;
		String[] temp2 = {"bye", "got to go", "talk to you later", "goodbye", "see you"};
		goodbyeWords= temp2;
		String[] temp3 = {"no", "are you kidding", "yes", "sure", "go ahead", "of course", "why not" };
		answerWords=temp3;
		secretWord = "crystal ball";
		String[] temp4= {"Hey, you need to stop speaking nonsense.", "My crystal ball remembers all the things good and bad.", "Momomopika! turn into a piggy!", "Let me go make a posion potion just for you."};
		meanResponse=temp4;
		String[] temp5= {"Let me put some faith and luck into ur fortune.", "honey, lets talk about something I get.", "Hmmm hows your day so far?"};
		loveResponse=temp5;
	}
    
	public boolean isTriggered(String response) {
		loveSpotting(response);
		for(int i =0; i<keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0)>=0) {
				return true;
			}
		}
		return false;
	}

	public void startChatting(String response) {
		ChatbotMain.print("Ah ha! Now you have asked, too bad if you didn't, I want to give a you a fortune telling.");
		chatting =true;
		String userName=ChatbotMain.chatbot.name();
		while(chatting) {
			response = ChatbotMain.getInput();
			for(int i=0; i<answerWords.length; i++)
			{	
			 if(ChatbotMain.findKeyword(response, answerWords[i], 0)>=0) {
				 if(i<=1)
				 {
					 ChatbotMain.print("Rude. Why don't you trust me!");
					 decreaseLoveCount();
				 }
				 if(i>1)
				 {
					 ChatbotMain.print("okay. Let's go! To able to give you an accurate reading"+userName+ " , there are some questions i want you to answer honestly and thoughtfully.");
					 startQuiz();
				 }
			}
			for(int t =0; t<goodbyeWords.length; t++) {
					if(ChatbotMain.findKeyword(response, goodbyeWords[t], 0)>=0) {
						chatting = false;
						if(loveCount>0) {
						ChatbotMain.print("Awwww. Rememeber to come back soon.");
						}
						else
						{
							ChatbotMain.print("Good don't come back...................Ha just kidding or not.");
						}
						ChatbotMain.chatbot.startTalkin();
					}
				}
			}
			if(ChatbotMain.findKeyword(response, secretWord, 0)>=0)
			{
				ChatbotMain.print("Oh my goodness! you guessed my favorite thing ever. We are friends now.");
				increaseLoveCount();
			}
			else {
				if(loveCount<0) {
				ChatbotMain.print(meanResponse[(int) (Math.random()*meanResponse.length)]);
			  }
				else {
					ChatbotMain.print(loveResponse[(int) (Math.random()*loveResponse.length)]);
				}
			}
				
		}
	}
	
	private void startQuiz() {

	}
	
	private void loveSpotting(String response) {
		String[] meanWords=ChatbotMain.chatbot.getLubna().meanWords();
		String[] loveWords=ChatbotMain.chatbot.getLubna().lovewWords();
		for(int i =0; i<meanWords.length; i++) {
			if(ChatbotMain.findKeyword(response, meanWords[i], 0)>=0) {
				decreaseLoveCount();
			}
		}
		for(int i =0; i<loveWords.length; i++) {
			if(ChatbotMain.findKeyword(response, loveWords[i], 0)>=0) {
				increaseLoveCount();
			}
		}
		
	}
	public int getLoveCount()
	{
		return loveCount;
	}
	
	public void increaseLoveCount() {
		loveCount++;
	}
	
	public void decreaseLoveCount() {
		loveCount--;
	}

}