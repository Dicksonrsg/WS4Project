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
    
    private String msg;
    
    private Soldier sol = new Soldier();

    public Soldier getSol() {
        return sol;
    }

    public void setSol(Soldier sol) {
        this.sol = sol;
    }
    
    public String select(Soldier sold){
        this.sol = sold;
        return null;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String validateSoldier(){
        SoldierDAO sodao = new SoldierDAO();
        String user = getSol().getUser();
        String pw = getSol().getPassword();        
        if(sodao.login(user, pw) != null){
            sol = sodao.login(user, pw);
            SessionUtils.getInstance().setAttribute("usuarioLogado", sol);
            return "f1w";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd", "-"));
            return "login";
        }        
    }

    public String doLogout() {
        SessionUtils.getInstance().encerrarSessao();
        addInfo("Logout realizado com sucesso!");
        return "login";
    }    
}
