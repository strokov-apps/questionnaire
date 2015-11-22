package questionnaire.client.web;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException>{

	@Override
	public Response toResponse(NotFoundException exception) {
		return Response
				.status(Response.Status.NOT_FOUND)
				.entity("No such resource.")
				.build();
	}

}
