package chatbotProject;

public class ChatbotJane implements Topic {

	private String[] keywords; 
	private String goodbyeWord;
	private String secretWord;
	private String[] answerWords;
	private boolean chatting;
	private int loveCount;
	private ChatbotLubna lubna;
	
	public ChatbotJane() {
		String[] temp = {"fortune", "future", "luck", "success", "failure"};
		keywords = temp;
		String temp2 = "bye";
		goodbyeWord= temp2;
		String[] temp3 = {"no", "are you kidding", "yes", "sure", "go ahead", "of course", "why not" };
		answerWords=temp3;
		secretWord = "crystal ball";
		lubna=ChatbotMain.chatbot.getLubna();
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
		ChatbotMain.print("Ah ha! Now you have asked, too bad if you didn't, I want to give a you a fortune telling.");
		chatting =true;
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
					 ChatbotMain.print("okay. Let's go! To able to give an accurate reading AAAAA, there are some questions i want you to answer honestly and thoughtfully.");
					 startQuiz();
				 }
				chatting = false;
				ChatbotMain.chatbot.startTalkin();
			}
			}
			if(ChatbotMain.findKeyword(response, secretWord, 0)>=0)
			{
				ChatbotMain.print("Oh my goodness! you guessed my favorite thing ever. We are friends now.");
				increaseLoveCount();
			}
			else {
				ChatbotMain.print("I don't really get y`1ou. tell me something else?");
			}
		}
	}
	
	private void startQuiz() {
		
		
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