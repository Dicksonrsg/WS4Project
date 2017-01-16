
package service;

import dao.TeacherDAO;
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
import model.Teacher;

@Path("/teacher")
public class TeacherService {
 
    private final TeacherDAO tdao = new TeacherDAO();
    
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Teacher> buscarTodos(){
        return tdao.findAll();
    }
    
    @GET
    @Path("/searchby/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Teacher buscarId(@PathParam("id") int id){
        return tdao.findByPrimaryKey(id);
    }   
    
    @POST
    @Path("/register")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response cadastrar(Teacher teacher){
        try{
            tdao.create(teacher);
            return Response.status(200).entity("Professor cadastrado").build();
        }catch(Exception e){
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha no cadastro").build();
    }
    
    @PUT
    @Path("/edit")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response alterar(Teacher teacher){
        try{
            tdao.update(teacher);
            return Response.status(200).entity("Professor editado").build();
        }catch(Exception e){
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha na alteração").build();        
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Response excluir(@PathParam("id") int id){
        try{
            tdao.delete(tdao.findByPrimaryKey(id));
            return Response.status(200).entity("Professor excluido").build();
        }catch(Exception e){
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha ao excluir").build();        
    }
}

/* CRUD --> SERVICE
    Create -> Post
    Read -> GET
    Update -> PUT
    Delete -> DELETE
*/
