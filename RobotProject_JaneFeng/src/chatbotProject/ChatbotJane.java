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
	private boolean quizLoop;
	private String[] quizConvo;
	private String[] quizResult;
	
	public ChatbotJane() {
		String[] temp = {"fortune", "future", "luck", "success", "failure"} ;
		keywords = temp;
		String[] temp2 = {"bye", "got to go", "talk to you later", "goodbye", "see you"};
		goodbyeWords= temp2;
		String[] temp3 = {"no", "are you kidding", "yes", "sure", "go ahead", "of course", "why not", "okay" };
		answerWords=temp3;
		secretWord = "crystal ball";
		String[] temp4= {"Hey, you need to stop speaking nonsense.", "My crystal ball remembers all the things good and bad.", "Momomopika! turn into a piggy!", "Let me go make a posion potion just for you."};
		meanResponse=temp4;
		String[] temp5= {"Let me put some faith and luck into ur fortune.", "honey, lets talk about something I get.", "Hmmm hows your day so far?"};
		loveResponse=temp5;
		String[] temp6= {"Awwww. Rememeber to come back soon.", "BYEEEEEEEE!", "I'll think about your fortune when you are gone.", "Don't let me miss you too much!", "Good don't come back...............Ha just kidding or not.", "Bye go do your work.", "I was going to say the same thing. Enough talking.", "I will think of a 'surprise' to put in ur fortune when you are gone.", "Okay bye bye bye.", "Fine, if you insist."};
		goodbyeResponse=temp6;	
		String[] temp7= {"Are you an active person?", "What is your age?", "What do you like to do in your spare time?", "Do you try to set goals and try to meet them?", "Do you worry about money alot?", "Do you spend alot of time by yourself?", "Do you like the way you look?", "Would you rather tell the truth or lie and get paid?"};
		quizConvo=temp7;
		String[] temp8= {"Wishes will come true for you. Always remember that God will reward those who commit good deeds and punish the ones that purse the worst of humanities. Time is not the problem; it is the solution. Maintain your honesty and innocence, and light will guide your way.", "It might sound sad, but you are an average person with an average ambition. Life might be ordinary, but how is that not something joyful and meaningful. As long as you STUDY AND DO YOUR HOMEWORK love will be approaching you. In other words no grade no love.", "Theres much room for you to improve, but on the good side you still have much time to accomplish that. Be committed to your own goals so they can be committed to you. Life is circle. You might find what your looking for is right there with you in the start. Don't forget your primary ambition, what started you on your journey. Keep that simple pleasure so you can reflect back when you are on the other half of the circle. Don't worry about money and love as much, they will come when the time is right."};
		quizResult=temp8;
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
			//loveSpotting();
			boolean keywordFound=false;	
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
					 ChatbotMain.print("okay. Let's go! To able to give you an accurate reading "+userName+ " , there are some questions I want you to answer honestly and thoughtfully.");
					 quizLoop=true;
					 startQuiz(response);
				 }
				 keywordFound=true;
			}
			for(int t =0; t<goodbyeWords.length; t++) {
					if(ChatbotMain.findKeyword(response, goodbyeWords[t], 0)>=0) {
						chatting = false;
						if(loveCount>0) {
						ChatbotMain.print(goodbyeResponse[(int) (Math.random()*4)]);
						}
						else
						{
							ChatbotMain.print(goodbyeResponse[(int) ((Math.random()*goodbyeResponse.length-4)+4)]);
						}
						ChatbotMain.chatbot.startTalkin();
						keywordFound=true;
					}
				}
			}
			if(ChatbotMain.findKeyword(response, secretWord, 0)>=0)
			{
				ChatbotMain.print("Oh my goodness! you guessed my favorite thing ever. We are friends now.");
				ChatbotMain.chatbot.resume();
				increaseLoveCount();
				keywordFound=true;
			}
			if(!keywordFound) {
				if(loveCount<0) {
				ChatbotMain.print(meanResponse[(int) (Math.random()*meanResponse.length)]);
				ChatbotMain.chatbot.resume();
				
			  }
				else {
					ChatbotMain.print(loveResponse[(int) (Math.random()*loveResponse.length)]);
					ChatbotMain.chatbot.resume();
				}
			}		
		}
	}

	private void startQuiz(String response) {
		ChatbotMain.print("okay, so here we go.");
		int conversationCount=0;
		int quizPoints=0;
		while(quizLoop)
		{
			response = ChatbotMain.getInput();
			if(conversationCount>=8){
				quizLoop=false;
			}
			else{
			ChatbotMain.print(quizConvo[conversationCount]);
			conversationCount++;
			if(conversationCount>=4)
			{
				if(response.equals("yes")) {
					quizPoints--;
				}
				else
				{
					quizPoints++;
				}
			}
			if(conversationCount<4)
			{
				if(response.equals("yes")&&conversationCount==0||conversationCount==3) {
					quizPoints++;
				}

			}
		}
		}
		if(quizPoints>3)
		{
			ChatbotMain.print(quizResult[0]);
		}
		else if(quizPoints>0) {
			ChatbotMain.print(quizResult[1]);
		}
		else {
			ChatbotMain.print(quizResult[2]);
		}
	}	
	
	private void loveSpotting(String response) {
		String[] meanWords=ChatbotMain.chatbot.getLubna().meanWords();
		String[] loveWords=ChatbotMain.chatbot.getLubna().lovewWords();
		for(int i =0; i<meanWords.length; i++) {
			if(ChatbotMain.findKeyword(response, meanWords[i], 0)>=0) {
				decreaseLoveCount();
				ChatbotMain.print("Hey watch what you say.");
			}
		}
		for(int i =0; i<loveWords.length; i++) {
			if(ChatbotMain.findKeyword(response, loveWords[i], 0)>=0) {
				increaseLoveCount();
				ChatbotMain.print("Awww thank you.");
				
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