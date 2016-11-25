package ctrls;

import dao.SoldierDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Soldier;

@ManagedBean(name = "soldierMB")
@SessionScoped
public class SoldierMbean extends AbstractCtrl<Soldier> implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String msg, user, pass, king;
    
    public Soldier getSoldier(){
        return (Soldier) SessionUtils.getInstance().getUsuarioLogado();
    }    
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getKing() {
        return king;
    }

    public void setKing(String king) {
        this.king = king;
    }
    
    public String doLogin(){
        SoldierDAO sodao = new SoldierDAO();
        if(user.equals("adm") && pass.equals("adm")){
            Soldier soldier = new Soldier();
            soldier.setUser(user);
            soldier.setPassword(pass);
            soldier.setName("Master Administrator");
            king = soldier.getName();
            SessionUtils.getInstance().setAttribute("usuarioLogado", soldier);
            System.out.println("EUREKA");
            return "/pages/f1w.xhtml?faces-redirect=true";
            
        }else if(sodao.login(user, pass) != null){
            Soldier sol = sodao.login(user, pass);
            king = sol.getName();
            System.out.println("USER: " + sol.toString());
            SessionUtils.getInstance().setAttribute("usuarioLogado", sol);
            System.out.println("EUREKA");
            return "/pages/f1w?faces-redirect=true";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd", "-"));
            FacesContext.getCurrentInstance().validationFailed();
            return "";
        }        
    }

    public String doLogout() {
        SessionUtils.getInstance().encerrarSessao();
        addInfo("Logout realizado com sucesso!");
        return "/guard/login.xhtml?faces-redirect=true";
    }  
    
}
