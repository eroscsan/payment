package hu.itk.ppke.erocs.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import hu.ppke.itk.dao.DataManager;
import hu.ppke.itk.model.Transactions;

@Path("/payment")
@Produces(MediaType.APPLICATION_JSON)
public class PaymentService {
	
	@GET
	@Path("/transaction")
	public Response getTransaction(@QueryParam(value = "id") int id) {
		DataManager manager = (DataManager) SpringApplicationContext.getBean("dataManager");
		
		Transactions transaction = manager.getTransactionByID(id);
		
		return Response.status(200).entity(transaction).build();
	}
	
}
