package ctrls;

import dao.SoldierDAO;
import javax.faces.bean.ManagedBean;
import model.Soldier;

@ManagedBean(name = "soldierMB")
public class SoldierMbean extends AbstractCtrl<Soldier> {
    
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
    
    public String login(){
        SoldierDAO sodao = new SoldierDAO();
        String user = getSol().getUser();
        String pw = getSol().getPassword();
        try{
            if(sodao.login(user, pw) != null){
                return "f1w?faces-redirect=true";
            }else{
                return "login?faces-redirect=true";
            }           
        }finally{
            sodao.close();
        }
    }
}
