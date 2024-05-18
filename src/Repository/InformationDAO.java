/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Until.DBconnect;
import java.sql.*; 

/**
 *
 * @author Admin
 */
public class InformationDAO  {
    
    // lấy ra ID nhân viên thông qua email nhân viên 
    public int getIDNVByEmail(String email){
        int id = -1 ; 
        String sql = "SELECT IDNhanVien FROM NhanVien where Email = '"+email+"' "; 
        try(Connection con = DBconnect.getConnection() ; PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {                
                id = rs.getInt(1); 
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id ; 
    }
    
    public static void main(String[] args) {
        InformationDAO x = new InformationDAO(); 
        int id = x.getIDNVByEmail("nguyenvana@example.com"); 
        System.out.println(id);
    }
}
