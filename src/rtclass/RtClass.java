/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtclass;

import java.sql.SQLException;

/**
 *
 * @author tasos
 */
public class RtClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        dbConnect con=new dbConnect();
        if(con.firstTime()){
             userCreate user=new userCreate();
                user.show();
        }else{
            login log=new login();
            log.show();
        }
        
        
        
      
       
    }
    
}
