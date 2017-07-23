import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParsingWithJsonParser {

	public static void main(final String[] args) throws org.json.simple.parser.ParseException {

		System.out.println(getNumberOfMovies("dil"));

	}

	static int getNumberOfMovies(final String substr) {
		URL url = null;
		try {
			url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr);
		} catch (final MalformedURLException e) {
			e.printStackTrace();
		}
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (final IOException e2) {
			e2.printStackTrace();
		}
		try {
			conn.setRequestMethod("GET");
		} catch (final ProtocolException e) {
			e.printStackTrace();
		}
		conn.setRequestProperty("Accept", "application/json");

		try {
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		} catch (final IOException e1) {
			e1.printStackTrace();
		}

		String output;
		String jsonString = "";
		try {
			while ((output = br.readLine()) != null) {
				jsonString += output;
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
		final JSONParser parse = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parse.parse(jsonString);
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		final Long l = (long) obj.get("total");
		return l.intValue();
	}

}