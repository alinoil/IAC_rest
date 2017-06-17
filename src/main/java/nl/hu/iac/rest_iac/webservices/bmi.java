package nl.hu.iac.rest_iac.webservices;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/bmi")
public class bmi {

	@GET
	@Path("/getBMI")
	@Produces("application/json")
	public String getBMI(@QueryParam("weight") double weight, @QueryParam("length") double length) {
		
		JsonObjectBuilder job = Json.createObjectBuilder();
		double bmi = weight / (length * length);
		bmi = Math.round(bmi);
		job.add("bmi", bmi);
		return job.build().toString();
	}
	
	@GET
	@Path("/getBMIIndex")
	@Produces("application/json")
	public String getBMIIndex(@QueryParam("index") double index) {
		String bI = null;
		JsonObjectBuilder job = Json.createObjectBuilder();
		if(index < 18.5) {
			bI = "Ondergewicht";
		}
		else if(index >= 18.5 && index <  25.0) {
			bI = "Gezond gewicht";
		}
		else if(index >= 25.0 && index < 30.0) {
			bI = "Overgewicht";
		}
		else if(index >= 30.0 && index < 40.0){
			bI = "Obesitas";
		}
		else if (index >= 40.0) {
			bI = "Morbide Obesitas";
		}
		
		job.add("index", bI);
		return job.build().toString();
	}
	
}