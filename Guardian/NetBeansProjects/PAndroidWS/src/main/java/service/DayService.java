
package service;

import dao.DayDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Day;

@Path("/day")
public class DayService {
    
    private final DayDAO ddao = new DayDAO();
    
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Day> listAll(){
        return ddao.findAll();
    }
    
    @GET
    @Path("/search/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Day findById(@PathParam("id")int id){
        return ddao.findByPrimaryKey(id);
    }
    
    @POST
    @Path("/register")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response register(Day day){
        try{
            ddao.create(day);
            return Response.status(200).entity("Dia cadastrada").build();
        }catch(Exception e){
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha no cadastro").build();
    }
    
    @PUT
    @Path("/edit")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(Day day){
        try{
            ddao.update(day);
            return Response.status(200).entity("Dia editado").build();
        }catch(Exception e){
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha na edição").build();        
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id")int id){
        try{
            ddao.delete(ddao.findByPrimaryKey(id));
            return Response.status(200).entity("Professor excluido").build();
        }catch(Exception e){
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha na edição").build();
    }
}
