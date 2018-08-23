package serverpart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.json.XML;


@Path("demo")
public class RestService {

	@GET
	@Path("conAddress/{address}")
	@Produces (MediaType.APPLICATION_JSON)
	
	
	public String conAddress(@PathParam("address") String address) throws IOException {

			String TextXml = getResponse(address);			
			String JsonStr = convert(TextXml);
			return JsonStr;
		
	}
	
	public String getResponse(String address) throws IOException {
		try {
		String url ="https://nominatim.openstreetmap.org/search?format=xml&q="+address;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		int responseCode = con.getResponseCode();
		if (responseCode!=200) {
			return "";
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		String StrXml = response.toString();
		return StrXml;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	
		return "";	
	}
	
	  public  String convert(String TextXml) throws IOException {
			
	        JSONObject xmlJSONObj = XML.toJSONObject(TextXml);
	        String JsonStr = xmlJSONObj.toString(4);
	        return JsonStr;
	    }
}
