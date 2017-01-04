
package dao;

import database.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Teacher;

public class TeacherDAO {
    
    private DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public TeacherDAO() {
        db = new DataBase();
    }
    
    public void insert(Teacher teacher){
        db.connect();
        sql = "INSERT INTO tb_teachers (tea_name, tea_phone, tea_language, tea_days) VALUES (?, ?, ?, ?)";
        try{
            ps = db.connection.prepareStatement(sql);
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getPhone());
            ps.setString(3, teacher.getLanguage());
            /*Look for example of lists added, solve it vefore running this*/
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex);
        }finally{db.disconnect();}
    }
    
    public void delete(Teacher teacher){
        db.connect();
        sql = "DELETE FROM tb_teachers WHERE tea_id = ?";
        try{
            ps = db.connection.prepareStatement(sql);
            ps.setInt(1, teacher.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex);
        }finally{db.disconnect();}
    }    
    
    public void edit(Teacher teacher){
        db.connect();
        sql = "UPDATE tb_teachers set tea_name = ?, tea_phone = ?, tea_language = ?, tea_days = ? WHERE tea_id = ?";
        try{
            ps = db.connection.prepareStatement(sql);
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getPhone());
            ps.setString(3, teacher.getLanguage());
            /*Look for example of lists added, solve it vefore running this*/
            ps.setInt(5, teacher.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex);
        }finally{db.disconnect();}
    }    
    
    public Teacher findById(int id){
        Teacher teacher = new Teacher();
        db.connect();
        sql = "SELECT * FROM tb_teachers WHERE tea_id = ?";
        try{
            ps = db.connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                teacher.setId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setPhone(rs.getString(3));
                teacher.setLanguage(rs.getString(4));
                /*language doubt still not resolved*/
            }
            rs.close();
            ps.close();
            return teacher;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{db.disconnect();}
        return null;
    }
    
    public List<Teacher> findAll(){
        List<Teacher> teachers = new ArrayList();
        db.connect();
        sql = "SELECT * FROM tb_teachers";
        try{
            ps = db.connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setPhone(rs.getString(3));
                teacher.setLanguage(rs.getString(4));
                /*language doubt still not resolved*/
                teachers.add(teacher);
            }
            rs.close();
            ps.close();
            return teachers;
        }catch(SQLException ex){
            System.out.println("Error: " + ex);
        }finally{db.disconnect();}
        return null;
    }
}
