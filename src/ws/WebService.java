package ws;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dao.ClienteFacade;
import entity.Cliente;

@Path("/WSCliente")
public class WebService {

	private Cliente c ;
	private ClienteFacade cf ;
	public WebService() {
		cf=new ClienteFacade();
		c=new Cliente();
	}
	
	
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
	@POST
	@Path("/guardarCliente")
	@Produces({MediaType.APPLICATION_JSON})
	public String guardarCliente(@QueryParam("nombre")String nombre,
								@QueryParam("apellido")String apellido,
								@QueryParam("telefono")String telefono,						
								@QueryParam("dui")String dui,
								@QueryParam("email")String email,
								@QueryParam("dirrecion")String dirrecion,
								@QueryParam("genero")String genero
								
								) {
			if(cf.create(new Cliente(nombre,apellido, telefono,dui,email, dirrecion, genero))) {
				
				return "cliente ingresado";
			}else {
				return "ocurrio un problema";
			}
	}
	
	
	
//	@POST
//	@Path("/guardarCliente")
//	@Produces({MediaType.APPLICATION_JSON})
//	public String guardarCliente(@QueryParam("nombre")String nombre,@QueryParam("apellido")String apellido,
//			@QueryParam("dirrecion")String dirrecion) {
//			if(cf.create(new Cliente(apellido, nombre,dirrecion))) {
//				
//				return "cliente ingresado";
//			}else {
//				return "ocurrio un problema";
//			}
//	}
}
