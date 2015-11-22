package questionnaire.client.web;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import questionnaire.client.service.HelloService;

@Path("/actor")
@Component
public class ActorEndpoint {

	@Autowired
	private HelloService helloService;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(@NotNull @QueryParam("name") String name) {
		return helloService.hello(name);
	}
}
