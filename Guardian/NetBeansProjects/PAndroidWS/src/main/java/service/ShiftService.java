
package service;

import dao.ShiftDAO;
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
import model.Shift;

@Path("/shift")
public class ShiftService {
    
    private final ShiftDAO sdao = new ShiftDAO();

    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Shift> listAll(){
        return sdao.findAll();
    }
    
    @GET
    @Path("/searchby/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Shift finById(@PathParam("id") int id){
        return sdao.findByPrimaryKey(id);
    }   
    
    @POST
    @Path("/register")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response register(Shift shift){
        try{
            sdao.create(shift);
            return Response.status(200).entity("Horario cadastrado").build();
        }catch(Exception e){
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha no cadastro").build();
    }
    
    @PUT
    @Path("/edit")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(Shift shift){
        try{
            sdao.update(shift);
            return Response.status(200).entity("Horario editado").build();
        }catch(Exception e){
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha na alteração").build();        
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int id){
        try{
            sdao.delete(sdao.findByPrimaryKey(id));
            return Response.status(200).entity("Horario excluido").build();
        }catch(Exception e){
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha ao excluir").build();        
    }    
}
