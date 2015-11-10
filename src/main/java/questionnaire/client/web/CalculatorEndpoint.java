package questionnaire.client.web;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/calc")
@Produces(MediaType.APPLICATION_JSON)
public class CalculatorEndpoint {

    @GET
    @Path("/{x}/{y}")
    public Map<String, Object> sum(@PathParam("x") int x, @PathParam("y")int y) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Pavel");
        map.put("age", 24);
        map.put("x", x);
        map.put("y", y);
        return map;
    }
}
