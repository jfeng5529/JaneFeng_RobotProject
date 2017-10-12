package chatbotProject;

import java.util.Random;

public class ChatbotMimi implements Topic {

	private String[] keywords;
	private String[] horoscopeKeywords;
	private String[] zodiacKeywords;
	private boolean chatting; 
	private String goodbyeWord;
	private String secretWord;
	private ChatbotJane jane;
	private String[] meanwords;
	private String[]  lovewords;

	public ChatbotMimi() {
		String[] temp = {"zodiac", "horoscope"};
		keywords = temp;
		String[] temp1 = { "aries", "taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio", "sagittarius", "capricorn", "aquarius", "pisces"};
		horoscopeKeywords = temp1;
		String[] temp2 = {"rat", "ox", "tiger", "rabbit", "dragon", "snake", "horse", "sheep", "monkey", "rooster", "dog", "pig"};
		zodiacKeywords = temp2;
		String temp3 = "bye";
		goodbyeWord= temp3;
		secretWord = "stars";
	}

	// make a method so that it checks which index of the array the input matches, then output a different message depending on the index

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

		ChatbotMain.print("Ooh! I love talking about this! Tell me your zodiac sign, and I'll give you your fortune. ( ͡° ͜ʖ ͡°)");
		chatting = true;

		while(chatting) {
			response = ChatbotMain.getInput();
			//			String zodiac = getZodiac(response);
			String zodiac = findKeywords(response, zodiacKeywords);
			if(zodiac == null)
				zodiac = findKeywords(response, horoscopeKeywords);

			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.resume();
			}

			else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0)
				ChatbotMain.print("I love counting the stars! Glad you do too :)");
			else if(findKeywords(response, keywords) != null) {
				ChatbotMain.print("Excellent! Tell me when you were born");
				// user input
				// reply with array of responses  
			}
			else if(zodiac != null)
				tellHoroscope(zodiac);
			else
				ChatbotMain.print("Hmm, not sure what you mean. Maybe you'd like to discuss something else? (wishes, fortune, etc.)");
			ChatbotMain.chatbot.resume();

		}
	}

	public static String findKeywords(String response, String [] keywords) {
		for(int i=0; i<keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return keywords[i];
			}
		}
		return null;
	}

	private void tellHoroscope(String zodiac) {
		String str=createRandomMsg();
		ChatbotMain.print(str);
	}

	private String createRandomMsg() {
		Random rand = new Random(); 
		int value = rand.nextInt(30);

		String returnMsg = null;
		if(value == 0)
			returnMsg = "You should team up with others and initiate action that resonates with your inner being. This might not be obvious now, but be on the lookout for unexpected events. These energies alert you to the fact that there's a much larger trend moving through your life that you may not be aware of right now. Stand back from your everyday routine and get a better perspective on your direction. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 1)
			returnMsg = "People of great power and drive may pop out of the woodwork today. They'll confront you directly and perhaps challenge you in some way. You may be at a climactic point right now, and feel like you're at a junction. Make adjustments now. Realize that change is a key ingredient for growth. Upheaval and action may be necessary. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 2)
			returnMsg = "You may be going through tremendous growth now. Focus on this and see where you need to make some changes. This may be interrupted by powerful energy from other people or situations. These issues are important. They're alerting you to certain changes that may be overdue. Look at how this upheaval can bring about growth and success. Opportunities await. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 3)
			returnMsg = "There's a free-spirited energy calling your name. Latch onto it and manifest creative abundance in your life. Perhaps a major opportunity for change is knocking on your door. Look through the keyhole before you invite anybody in, but realize that the answer you seek may not be wearing the costume you expect. Explore all options and be bold. Initiate action. Don't shy away from change. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 4)
			returnMsg = "A major force confronts you now. It may seem like this energy will never stop. It might be mental or physical, but either way, you may be letting it consume too much of your attention. Try not to get caught in drama that doesn't really involve you. Remedy the things you can change and leave the rest. Take responsibility for your actions and let others worry about theirs. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 5)
			returnMsg = "Keep your eyes open today. Be on the lookout for opportunities and invitations. Don't act too hastily. This is a key time in which life seems to be moving more quickly than ever. Change may be just what you need to foster your growth. Don't just grab the first thing that comes your way. Examine your options closely, make sure you're confident about the situation - then act. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 6)
			returnMsg = "Unexpected events may throw you for a loop today, but these incidents could be part of a bigger trend that you should pay attention to. There's great opportunity at hand, and you shouldn't ignore it. Small things may indicate some major change that needs to happen in your life before this new energy can take hold. Clear out the cobwebs and welcome a breath of fresh air. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 7)
			returnMsg = "There's a powerful movement of energy in your life now. Major overhauls and subsequent undertakings are just waiting for you to give the green light. Realize the potential of instigating a significant change in your life. Don't shy away from the unknown. You understand the need for upheaval. Chaos may be necessary in order to let new opportunities in. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 8)
			returnMsg = "Take charge of your life. Initiate action and major change in an important area. Large trends are being activated today, alerting you to the fact that there's a great opportunity at hand. Take note of any sudden energy and unexpected events. Chaos and confusion may be the initial result, but change is a key ingredient for your future growth. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 9)
			returnMsg = "There's electricity in the air today, which may spur you to make a significant change in one area of your life. Try not to rush on this one. Don't change just for the sake of change, but really examine something that needs to shift. You have a great opportunity for growth now, so look for ways in which you can make major personal improvements. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 10)
			returnMsg = "You're at the start of a very expansive time in your life, and opportunities are available whether you realize it or not. You may get the feeling that there's an area that needs a total overhaul. Major changes are a large piece of the puzzle. Revamp that which doesn't work for you any more to make room for the future that awaits you. This is your time to shine. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 11)
			returnMsg = "Bizarre and unexpected events lie in store for you today, so don't be surprised if not everything goes according to plan. Take note that these events may be part of a larger trend indicative of a tremendous opportunity. Heed the subtleties of this wave of energy. Latch onto it and see it as a major time of growth and expansion in your life. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 12)
			returnMsg = "It's time for you to face some facts, but it's not just you that's on the hook, fortunately. The universe is asking us all to sit still, quiet our minds, pay attention and be realistic, whether we like it or not. Now, the 'sit still' part is admittedly a little bit tougher on you than on others, but once you set your mind to it, you can do almost anything you want. Try not to make it look too easy! \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 13)
			returnMsg = "Someone higher up in the hierarchy is about to put their foot down and say no to an utterly reasonable request. You're not used to hearing that word from them because, as hard as you work, the meager requests you make just aren't seen as drawing on too many resources. After the shock has passed, think it over before you decide to skip getting mad and start getting even. There may be a much deeper reason behind the refusal. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 14)
			returnMsg = "You've been much more heavily focused on business than on play lately, which isn't like you at all. Your friends may be a bit taken aback -- and you really can't blame them. Try to explain that you've just about had it with bowing down to other people's professional whims, and you're thinking of making an impressive exit. Then they might start to get a glimmer. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 15)
			returnMsg = "You're not in the mood for public displays -- of affection, or much of anything else. When you're approached by someone who's more than willing to let the world in on private matters, you're less than receptive, but don't feel bad about it. They have no right to let a secret out -- at least nothing that doesn't belong to them exclusively. You can let them know what's what with one quick, cutting comment. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 16)
			returnMsg = "An elder you've long admired seems to have a bit of a problem with you today, and you can't quite figure out what's going on. You need to talk to them about it, but you're worried -- not so much about how they might treat you, but more about what's really going on between you. Take a deep breath and open up a new line of communications. It's certainly for the best! \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 17)
			returnMsg = "It takes quite a bit of teasing or meanness to get you really riled up -- but right around now, you're plenty mad. It's most likely the person you care most about, and they're probably feeling just as frustrated. You need to take time off, and that's not a euphemism for the early stages of a break-up. Put some distance -- and some time -- between you two. Then you can return to solve this in your usual loving way. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 18)
			returnMsg = "You're definitely in the mood to get some work done, and that's that. Keep your eyes open, though, because you're definitely not in the mood for being taken advantage of, especially when it comes to money. If someone tries to play you for a fool, not only can you spot it with great ease, you should also go after the culprit with all the energy you can muster -- as well you should. Don't let them get away with it. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 19)
			returnMsg = "You're not exactly happy with the way recent events have turned out, and you're not in the mood to pretend that you are. Fortunately, you won't have to for very long. Almost everyone can see you're aggravated, and those responsible know exactly how angry you are -- and don't bother you any further. Your only problem now will be what to do about the folks who aren't bright enough to figure it out. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 20)
			returnMsg = "Someone is trying to make you feel guilty and, believe it or not, that's pretty easy to do right now. Rather than giving in and letting it happen, do what you did yesterday and make sure all your bases are covered before doing much of anything for yourself. That way, you can ensure that if anyone tries to bust you, it's okay for you to bust them right back and soak up the sympathy from the home crowd. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 21)
			returnMsg = "The universe is in a freaky mood -- and so are you, mostly because energies you can't quite understand just now are driving your life. If you say 'no,' but those around you can't understand that simple answer, you need to unleash some serious consequences. If anyone can give you the right answer to the right question, however, things are going to get a lot better fast -- in fact, they may turn out to be downright excellent! \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 22)
			returnMsg = "Things have changed in a big way -- so much so that they might be unrecognizable after yesterday. This doesn't mean you're confused or unhappy with the choices that you made -- that hardly ever happens these days. You do need to deal with the outcome of those choices, though. There's no need for worries, though -- when was the last time you made the wrong call when you had all the facts? \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 23)
			returnMsg = "You've got all day to listen, and that's good enough. Once the talk is all finished, though, you absolutely must let go of it and remember that your own needs have to take priority, just this once. There may be someone you've been wanting to spend some time with, and if so, the feeling is mutual. It's not too late, so give them a call. You deserve to enjoy yourself! \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 24)
			returnMsg = "You may be licking your wounds over a past misunderstanding but, thankfully, your recovery is steady now. Your analysis of recent events can leave you feeling discouraged, but your assessment of the current situation reveals progress today. Although you might still feel wary, you can’t help but rebuild your confidence as the day wears on. Your willingness to see your predicament from someone else’s point of view enables you to widen your perspective. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 25)
			returnMsg = "Focused on the direction you wish to take, you could dismiss too many emotions instead of filling your heart with joy. Don’t be too ambitious to remember how you feel along the way, and try to find a fine line of balance between work and rest, social life and alone time. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 26)
			returnMsg = "Urban birds sing short and fast songs, and their rural counterparts stick to slow melodies. This is something you could become wildly aware of these days, especially if you are subjected to the chaos of urban life that started taking its tall. Ideals you strive for might need to be reestablished in order to work out for you in the future. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 27)
			returnMsg = "What starts out as a benign conversation could turn out to be the source of frustration for weeks to come. Be careful what you say and do, taking initiative and not letting anyone affect important decisions in your life, however righteous their point of view must be. You must make your own mistakes if this is what’s necessary to feel whole and like you are on your true path. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 28)
			returnMsg = "There were more abortions in Russia in 2005, than live births. Whatever your opinion, this is a fact from the real world you live in and strong grounding will inevitably face you with similar information. Be sure you have the stomach to face anything in your life without masks or your pink goggles on. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";
		if(value == 29)
			returnMsg = "You have something to say but don’t know exactly how to say it today. While you might be in a dilemma about the choice of words, other people in your life are in a dilemma about their direction in life. Take this into consideration while seeking understanding and trying to push your will onto them. \n Stay in zodiac? Move onto a new topic? (wishes, fortune, etc.)";

		return returnMsg;
	}

	public void practiceLove() {
		int loveCount = ChatbotMain.chatbot.getJane().getLoveCount();
	}

}

