import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "dS6OhbqS1fShQc5wbK2DTMwrP";
    private final static String CONSUMER_KEY_SECRET = "QzgWsgA5fd9g71AOpycpCmbgWEApjjTF9P10Lu0JQOJDt1sfxt";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo tugas webservice Oktio Ryan");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "890trDbA9sfCHb6aXXWiilElYDivaUZ9DlX9yyE5QroVB";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "604340232-zXifF85RAyx2VsDjS4LiFEtWCWcNN2eXAhfwAHvH";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
