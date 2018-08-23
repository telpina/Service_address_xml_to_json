package clientpart;

import java.text.MessageFormat;
import javax.ws.rs.core.*;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.*;


public class RestClient {
	private WebResource webResource;
	private Client client;
	private static final String BASE_URI = "http://localhost:8080/WebServiceFilmRate_Server/rest";
		
	public RestClient() {
		client = Client.create(new DefaultClientConfig());
		webResource = client.resource(BASE_URI).path("demo");
	}
	
	public String getAddressJson(String address) throws UniformInterfaceException {
		WebResource resource = webResource;		
		resource = resource.path(MessageFormat.format("conAdress/{0}", new Object[] {address}));	
		return resource.accept(MediaType.APPLICATION_JSON).get(String.class);	
	}	
		
	public void close() {
		client.destroy();
	}
}
