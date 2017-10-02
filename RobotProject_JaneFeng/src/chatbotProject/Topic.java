package chatbotProject;

public interface Topic {

	boolean isTriggered(String response, int meanCount, int loveCount);

	void startChatting(String response);



}
