package psl.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import psl.base.US500;
import psl.crud.CRUDOps;

@Path("service")
public class Resources 
{
	CRUDOps ops = new CRUDOps();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ping()
	{
		return "Server Active";
	}

	
	@GET
	@Path(value = "/users")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response readData()
	{
		List<US500> list = new ArrayList<US500>();
		list = ops.readFromDb();
		
		if(list.size()<=0)
			return Response.serverError().build();
		else
		{
			GenericEntity<List<US500>> entity = new GenericEntity<List<US500>>(list){};
			return Response.ok(entity).build();
		}
	}
	
	@GET
	@Path(value = "/users/{email}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response readByEmail(@PathParam("email") String mail)
	{
		List<US500> list = ops.searchDB(mail);
		if(list.size() <= 0)
			return Response.status(404).build();
		else
		{
			GenericEntity <List<US500>> entity = new GenericEntity<List<US500>>(list){};
			return Response.ok(entity).build();
		}
	}
	
	///////////////////////////// TEST
	@GET
	@Path(value = "/users/{county}/zip/{zip}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response readByMultiple(@PathParam("county") String county, @PathParam("zip") String zip)
	{
		List<US500> list = ops.searchMultiple(county, zip);
		if(list.size() <= 0)
			return Response.status(404).build();
		else
		{
			GenericEntity <List<US500>> entity = new GenericEntity<List<US500>>(list){};
			return Response.ok(entity).build();
		}
	}
	
	///////////////////////////// TEST
	
	
	@POST
	@Path(value = "/users/")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response writeData(
			@FormParam("first_name") String fName,
			@FormParam("last_name") String lName, 
			@FormParam("company_name") String cName,
			@FormParam("address") String addr,
			@FormParam("city") String cty,
			@FormParam("county") String coun,
			@FormParam("state") String st,
			@FormParam("zip") String zp,
			@FormParam("phone1") String ph1,
			@FormParam("phone2") String ph2,
			@FormParam("email") String em,
			@FormParam("web") String wb
			)
	{
		
		US500 toWrite = new US500(fName, lName, cName, addr, cty, coun, st, Integer.parseInt(zp), ph1, ph2, em, wb);
		boolean flag = ops.writeToDb(toWrite);
		if(flag == false)
		{
			List<US500> list = ops.readFromDb();
			GenericEntity <List<US500>> entity = new GenericEntity<List<US500>>(list){};
			return Response.ok(entity).build();
		}
		else
		{
			return Response.serverError().build();
		}
	}
	@PUT
	@Path(value = "/users/")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updateData(
			@FormParam("first_name") String fName,
			@FormParam("last_name") String lName, 
			@FormParam("company_name") String cName,
			@FormParam("address") String addr,
			@FormParam("city") String cty,
			@FormParam("county") String coun,
			@FormParam("state") String st,
			@FormParam("zip") String zp,
			@FormParam("phone1") String ph1,
			@FormParam("phone2") String ph2,
			@FormParam("email") String em,
			@FormParam("web") String wb
			)
	{
		
		US500 toUpdate = new US500(fName, lName, cName, addr, cty, coun, st, Integer.parseInt(zp), ph1, ph2, em, wb);
		boolean flag = ops.updateToDb(em, toUpdate);
		if(flag == false)
		{
			List<US500> list = ops.readFromDb();
			GenericEntity <List<US500>> entity = new GenericEntity<List<US500>>(list){};
			return Response.ok(entity).build();
		}
		else
		{
			return Response.serverError().build();
		}
	}
	@DELETE
	@Path(value = "/users/{email}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response deleteByEmail(@PathParam("email") String mail)
	{
		
		boolean flag = ops.deleteFromDb(mail);
		System.out.println("Delete Flag" + flag);
		if(flag == false)
		{
			List<US500> list = ops.readFromDb();
			GenericEntity <List<US500>> entity = new GenericEntity<List<US500>>(list){};
			return Response.ok(entity).build();
		}
		else
		{
			return Response.serverError().build();
		}
	}
	@DELETE
	@Path(value = "/users/")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response deleteByCityAndState(
							@QueryParam("city") String cty,
							@QueryParam("state") String st
			)
	{
		
		boolean flag = ops.deleteFromDbByCityState(cty, st);
		if(flag == false)
		{
			List<US500> list = ops.readFromDb();
			GenericEntity <List<US500>> entity = new GenericEntity<List<US500>>(list){};
			return Response.ok(entity).build();
		}
		else
		{
			return Response.serverError().build();
		}
	}
}
