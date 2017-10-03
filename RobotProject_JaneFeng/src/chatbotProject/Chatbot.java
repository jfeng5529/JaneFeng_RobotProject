package chatbotProject;
	

public class Chatbot {
		private String userName;
		private ChatbotJane jane;
		private Topic lubna;
		private Topic mimi;
		private Topic jessi;
		private int meanCount;
		private int loveCount;
		private boolean chatting;

	public Chatbot() {
		jane= new ChatbotJane();
		lubna= new ChatbotLubna();
		mimi= new ChatbotMimi();
		jessi= new ChatbotJessi();
		meanCount=0;
		loveCount=0;
		userName="unknown user";
	}	
	
	public ChatbotJane getJane() {
		return jane;
	}
	
	public void startTalkin() {
		ChatbotMain.print("Welcome to our chatbot! What is your name?");
		userName= ChatbotMain.getInput();
		chatting = true;
		while(chatting) {
			ChatbotMain.print("What do you want to talk about?");
			String response = ChatbotMain.getInput();
			if(lubna.isTriggered(response, meanCount, loveCount)) {
				chatting = false;
				lubna.startChatting(response);
			}
			else if(mimi.isTriggered(response, meanCount, loveCount)) {
				chatting = false;
				mimi.startChatting(response);
			}
			else if(jane.isTriggered(response, meanCount, loveCount)) {
				chatting = false;
				jane.startChatting(response);
			}
			else if(jessi.isTriggered(response, meanCount, loveCount)) {
				chatting = false;
				jessi.startChatting(response);
			}
			else
				ChatbotMain.print("I'm sorry. I don't understand");
		}
		
	}
	
}
