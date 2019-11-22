package ws;


import java.util.List;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

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
	public String delete(@QueryParam("idCliente")int idCliente){
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
	@GET
	@Path("/listaCliente")
	@Produces(MediaType.APPLICATION_JSON)
	public String clientesAll() {
		List<Cliente>lista= new ArrayList<Cliente>();
		lista=cf.mostrar();
		
		Gson gson = new Gson();
		String data= gson.toJson(lista);
		JsonArray jsonArray= new JsonParser().parse(data).getAsJsonArray();
		String resultado=gson.toJson(jsonArray);
		
		return resultado;
		
	}
	@PUT
	@Path("/modificarCliente")
	@Produces(MediaType.APPLICATION_JSON)
	public String udpate(@QueryParam("idCliente")int idCliente,
			@QueryParam("nombre")String nombre,
			@QueryParam("apellido")String apellido,
			@QueryParam("telefono")String telefono,						
			@QueryParam("dui")String dui,
			@QueryParam("email")String email,
			@QueryParam("dirrecion")String dirrecion,
			@QueryParam("genero")String genero) 
	{
		if(idCliente != 0) {
			c.setCodigoCliente(idCliente);
			c.setNombre(nombre);
			c.setApellido(apellido);
			c.setTelefono(telefono);
			c.setDui(dui);
			c.setEmail(email);
			c.setDirrecion(dirrecion);
			c.setGenero(genero);
			cf.update(c);
			return "datos modificado";
		}else {
			return "error";
		}
	}
}
		
	
	

	
	

