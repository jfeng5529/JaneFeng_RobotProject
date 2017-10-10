package chatbotProject;

import java.util.Scanner;

public class ChatbotMain {

	//independent of instances, the chatbot represents the program itself. when the program runs, and we want to 
	//the state of the program, the static variable allows the user to access it anywhere in the program
	public static Chatbot chatbot = new Chatbot();
	
	public static void main(String[] args) {
		chatbot.startTalkin();

	}
	// paste code from Utility(dont need the main method)

		private static Scanner inputSource = new Scanner(System.in);

		/**
		 * This method returns the index of keyword in the searchString (after startPsn)
		 *  where keyword is isolated and has noNegations. It returns -1 if the
		 *  keyword is not found
		 */
		public static int findKeyword(String searchString, String answerWords, int startPsn) {
			//makes lowercase
			searchString = searchString.toLowerCase();
			answerWords = answerWords.toLowerCase();
			//find the first position after the startPsn
			int psn = searchString.indexOf(answerWords, startPsn);
			
			//keep searching until keyword is found (noNegations and isolated)
			while(psn >= 0) {
				
				if(keywordIsIsolated(psn, answerWords, searchString) && noNegations(searchString, psn)) {
					return psn;
				}else {
					//look for the next occurrence
					psn = searchString.indexOf(answerWords, psn+1);
				}
			}
			return -1;
		}
		
		
		public static boolean keywordIsIsolated(int psn, String keyword, String s){
			int keywordLength=keyword.length(); String letter1; String letter2;
			   if(psn==0) {
				   if(keywordLength==s.length())
				   {
					   return true;
				   }
				   letter1=s.substring(keywordLength, keywordLength+1);
				   if(letter1.compareTo("a")<0)
				   {
					   return true;
				   }
				   else
				   {   
				   return false;
				   }
			   }
			   if(psn+keywordLength==s.length()) {
				   letter1=s.substring(psn-1, psn);
				   if(letter1.compareTo("a")<0)
				   {
					   return true;
				   }
				   return false;
			   }
			   letter1=s.substring(psn-1, psn);
			   letter2=s.substring(keywordLength+psn, keywordLength+psn+1);
			   if(letter1.compareTo("a")<0||letter2.compareTo("a")<0)
			   {   
			   return true;
			  }
			   else
			   {
				   return false;
			   }
	}
		public static boolean noNegations(String s, int psn){
			if(psn>4)
			{
				String negation1=s.substring(psn-3, psn-1);
				String negation2=s.substring(psn-4, psn-1);
				if(negation1.equals("no")||negation2.equals("not"))
				{
					return false;
				}
				}
				return true;
		}


		public static String getInput(){
			return inputSource.nextLine();
		}

		public static void print(String s){
			multiLinePrint(s);
		}

		public static void multiLinePrint(String s){
			String printString = "";
			int cutoff = 55;
			//this while loop last as long as there are words left in the original String
			while(s.length() > 0){

				String currentCut = "";
				String nextWord = "";

				//while the current cut is still less than the line length 
				//AND there are still words left to add
				while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){

					//add the next word
					currentCut += nextWord;

					//remove the word that was added from the original String
					s = s.substring(nextWord.length());

					//identify the following word, exclude the space
					int endOfWord = s.indexOf(" ");

					//if there are no more spaces, this is the last word, so add the whole thing
					if(endOfWord == -1) {
						endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
					}

					//the next word should include the space
					nextWord = s.substring(0,endOfWord+1);
				}

				printString +=currentCut+"\n";

			}
			System.out.print(printString);
		}

		public static int getIntegerInput() {
			print("Please enter an integer.");
			String integerString = getInput();
			boolean isInteger = false;
			int value = 0;
			while(!isInteger){
				try{
					value = Integer.parseInt(integerString);
					//will not continue if an error above is thrown
					isInteger = true;//exits loop if entry is valid
				}catch(NumberFormatException e){
					print("You must enter an integer. You better try again.");
					integerString = getInput();
				}
			}
			return value;
		}
	}	

/*public void startChatting(String response) {
		ChatbotMain.print("Tell me something you like!");
		chatting =true;
		String userName=ChatbotMain.chatbot.name();
		while(chatting) {
			response = ChatbotMain.getInput();
			boolean keywordFound = false;
			inLikeLoop = true;
			while(inLikeLoop){
				
				likeResponse = response;
				int likePsn = likeResponse.indexOf("like");
				if(likePsn > -1) {
					thingsLiked = likeResponse.substring(likePsn+5);
					userLikeStored = true;
					if(thingsLiked.length( ) > 20) {
						ChatbotMain.print("That's so interesting. Do you want to know what I know about you ;)");
					}
					else {
						ChatbotMain.print("You are such an interesting person, because you like "+ thingsLiked + ".");
					}
				
				}
				else {
					thingsLiked = likeResponse;
					if(thingsLiked.length( ) > 20) {
						ChatbotMain.print("That's so interesting. Do you want to know what I know about you ;)");
					}
					else {
						ChatbotMain.print("You are such an interesting person, because you like "+ thingsLiked + ".");
					}
				}
					inLikeLoop = false;
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
*/


