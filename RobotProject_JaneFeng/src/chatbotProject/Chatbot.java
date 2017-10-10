package chatbotProject;


public class Chatbot {
		private String userName;
		private ChatbotJane jane;
		private ChatbotLubna lubna;
		private ChatbotMimi mimi;
		private ChatbotJessi jessi;
		private boolean chatting;

	public Chatbot() {
		jane= new ChatbotJane();
		lubna= new ChatbotLubna();
		mimi= new ChatbotMimi();
		jessi= new ChatbotJessi();
		userName="unknown user";
	}
	
	public ChatbotJane getJane() {
		return jane;
	}
	
	public ChatbotLubna getLubna() {
		return lubna;
		
	}
	public ChatbotMimi getMimi() {
		return mimi;
		
	}
	public ChatbotJessi getJessi() {
		return jessi;
		
	} 
	public String name()
	{
		return userName;
	}
	public void startTalkin() {
		ChatbotMain.print("You have entered the fortune cookie world. Give me your name.");
		userName= ChatbotMain.getInput();
		ChatbotMain.print("Nice meeting you "+userName+"!");
		String response = ChatbotMain.getInput();
		lubna.startChatting(response);
		
	}
	public void resume() {
		chatting = true;
		while(chatting) {
			String response = ChatbotMain.getInput();
			if(lubna.isTriggered(response)) {
				chatting = false;
				lubna.startChatting(response);
			}
			if(mimi.isTriggered(response)) {
				chatting = false;
				mimi.startChatting(response);
			}
			if(jane.isTriggered(response)) {
				chatting = false;
				jane.startChatting(response);
			}
			if(jessi.isTriggered(response)) {
				chatting = false;
				jessi.startChatting(response);
			}
			else
				ChatbotMain.print("I'm sorry. I don't understand. Let's talk about fortune, horoscope, wishes, cause you know I'm a fortune teller.");
		}
	}
	
}