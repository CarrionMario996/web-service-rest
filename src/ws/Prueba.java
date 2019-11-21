package ws;

import java.util.*;

import com.google.gson.*;

import dao.ClienteFacade;
import entity.Cliente;

public class Prueba {

	public static void main(String[] args) {
		ClienteFacade cf = new ClienteFacade();
		Cliente c = new Cliente();
		
		List<Cliente> lista = new ArrayList<Cliente>();
		lista = cf.mostrar();

		Gson gson = new Gson();
		String data = gson.toJson(lista);
		JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();
		gson.toJson(jsonArray);
		System.out.println(data.toString());
	}

}
