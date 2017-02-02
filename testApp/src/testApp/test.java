package testApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class test {
	public static void main(String[] args){
		System.out.println("Hello");
		JSONParser parser = new JSONParser();
		StringBuilder sb = new StringBuilder();
		
		 try {

				URL url = new URL("https://api.api.ai/v1/query?v=20150910");
				HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Authorization", "Bearer 7e2d7d4a273044b1acf3d254b99cf6dd");
				
				String input = "{\"query\":\"hi\",\"lang\":\"en\",\"sessionId\":\"somerandomthing\"}";

				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush();

				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					sb.append(output);
				}
				
				Object obj = parser.parse(sb.toString());
				JSONObject jsonObject = (JSONObject) obj;
				jsonObject = (JSONObject) jsonObject.get("result");
				jsonObject = (JSONObject) jsonObject.get("fulfillment");
				String speech = (String) jsonObject.get("speech");
				System.out.println(speech);
				
				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			 } catch (ParseException e) {
				 
				e.printStackTrace();
			}
	}
}
