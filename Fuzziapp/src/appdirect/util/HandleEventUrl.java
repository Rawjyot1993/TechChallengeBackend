package appdirect.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import BeanCancel.JavaJson;
import BeanCreate.JavaConvertJson;
import oauth.signpost.basic.DefaultOAuthConsumer;

public class HandleEventUrl {
	 static String responseJson = "";
	public static String getJsonDataFromEventUrl(String eventUrl) {
	       try {
	           DefaultOAuthConsumer e = new DefaultOAuthConsumer("webappintegration-152211", "2NXxQoDqqhOaRyg5");
	           URL url = new URL(eventUrl);
	           HttpURLConnection request = (HttpURLConnection)url.openConnection();
	           request.setRequestProperty("Accept", "application/json");
	           e.sign(request);
	           int responseCode = request.getResponseCode();
	         System.out.println("Sending \'GET\' request to URL : {}/"+ eventUrl);
	         System.out.println("Response Code : {}"+ Integer.valueOf(responseCode));
	           BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
	           StringBuffer response = new StringBuffer();

	           String inputLine;
	           while((inputLine = in.readLine()) != null) {
	               response.append(inputLine);
	           }
	           in.close();
	           responseJson = response.toString();
	           System.out.println("Response json from app direct server is - {}"+ responseJson);
	       } catch (Exception var9) {
	           System.out.println("Error fetching data from eventUrl - {}"+ var9.getMessage());
	       }
	       System.out.println("JSON TO String");
	       return responseJson;
	   }	
					
}
	
	
	
	
	

	


