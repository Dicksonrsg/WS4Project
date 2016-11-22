
package ctrls;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.Soldier;

public class SessionUtils {
    
      private static SessionUtils instance;
      
      public static SessionUtils getInstance(){
           if (instance == null){
               instance = new SessionUtils();
           }
           
           return instance;
      }
      
      private SessionUtils(){
           
      }
      
      private ExternalContext currentExternalContext(){
           if (FacesContext.getCurrentInstance() == null){
               throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
           }else{
               return FacesContext.getCurrentInstance().getExternalContext();
           }
      }
      
      public Soldier getUsuarioLogado(){
           return (Soldier) getAttribute("usuarioLogado");
      }
      
      public void setUsuarioLogado(Soldier soldier){
           setAttribute("usuarioLogado", soldier);
      }
      
      public void encerrarSessao(){   
           currentExternalContext().invalidateSession();
      }
      
      public Object getAttribute(String nome){
           return currentExternalContext().getSessionMap().get(nome);
      }
      
      public void setAttribute(String nome, Object valor){
           currentExternalContext().getSessionMap().put(nome, valor);
      }    

}
