package chatbotProject;
	

public class Chatbot {
		private String userName;
		private Topic jane;
		private boolean chatting;

	public Chatbot() {
		jane= new ChatbotJane();
		userName="unknown user";
	}		
	public void startTalkin() {
		ChatbotMain.print("Welcome to our chatbot! What is your name?");
		userName= ChatbotMain.getInput();
		chatting = true;
		while(chatting) {
			ChatbotMain.print("What do you want to talk about?");
			String response = ChatbotMain.getInput();
			if(jane.isTriggered(response)) {
				chatting = false;
				jane.startChatting(response);
			}
			else
				ChatbotMain.print("I'm sorry. I don't understand");
		}
		
	}
	
}
