package ws;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dao.ClienteFacade;
import entity.Cliente;

@Path("/WSCliente")
public class WebService {

	Cliente c = new Cliente();
	ClienteFacade cf = new ClienteFacade();
	
	
	@PUT
	@Path("/deleteCliente")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteU(@QueryParam("idCliente")int idCliente){
		if(idCliente != 0) {
			this.c = cf.findId(idCliente);
			cf.delete(c);
			return "datos elimindados ";
		}else {
			return "error";
		}
	}
}
