package teste.model;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import org.json.JSONObject;


public class APIUsage {
	private final String USER_AGENT = "Mozilla/5.0";

	private String sendGet(String url) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		
		con.setRequestMethod("GET");

		con.setRequestProperty("User-Agent", USER_AGENT );

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		return (response.toString());

	}

	public String marvelAPI(String character) {

		try {
			JSONObject obj = null;
			if (character != "") {
				obj = new JSONObject(sendGet(
						"http://gateway.marvel.com/v1/public/characters?name=" + character + "&apikey=ba9a18ec9aae5ddcaeaf7afe958db3e9"));

			} else {

				System.out.println("Por favor preencha o espaço com o nome de um herói.");
			}
			
			 int id_character = obj.getJSONObject("data").getJSONObject("results").getJSONObject("0").getInt("id");
			
			JSONObject objcomics = null;
			JSONObject objevents = null;
			if (id_character != 0) {
				objcomics = new JSONObject(sendGet(
						"http://gateway.marvel.com/v1/public/characters/" + id_character + "/comics?apikey=ba9a18ec9aae5ddcaeaf7afe958db3e9)"));
				
				JSONObject comics= objcomics.getJSONObject("data").getJSONObject("results");
				
				
				objevents = new JSONObject(sendGet(
						"http://gateway.marvel.com/v1/public/characters/" + id_character + "/events?apikey=ba9a18ec9aae5ddcaeaf7afe958db3e9)"));
				JSONObject events = objevents.getJSONObject("data").getJSONObject("results");
			} else {
				System.out.println("Herói não identificado.");
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (e.toString());
		}
		return character;
	}
}

//https://www.reddit.com/r/marvel/search?q=hero&restrict_sr=1%2F.json&sort=top