package ctrls;

import dao.SoldierDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Soldier;

@ManagedBean(name = "soldierMB")
@SessionScoped
public class SoldierMbean extends AbstractCtrl<Soldier> implements Serializable{
    
    private static final long serialVersionUID = 1094801825228386363L;
    
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
    
    //http://www.journaldev.com/7252/jsf-authentication-login-logout-database-example
    
    //validate login
    public String validateSoldier(){
        SoldierDAO sodao = new SoldierDAO();
        String user = getSol().getUser();
        String pw = getSol().getPassword();        
        if(sodao.login(user, pw) != null){
            sol = sodao.login(user, pw);
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "f1w";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd", "-"));
            return "login";
        }
    }
    
    //logout event, invalidate session
    public String logout(){
        sol = null;
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
    
}
