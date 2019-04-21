/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtclass;

import java.sql.*;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tasos
 */
public class dbConnect {
   Connection conn=null;
   
    public  Connection Connect(){
        try{
              Class.forName("org.sqlite.JDBC");
              Connection con=DriverManager.getConnection("jdbc:sqlite:data.db");
              return con;
           // JOptionPane.showMessageDialog(null,"success");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
           
        }
        return null;
    }
    
    
    public boolean firstTime() throws SQLException{
        String query="Select * from user ";
        conn=this.Connect();
        PreparedStatement smt = conn.prepareStatement(query);
        ResultSet rs=smt.executeQuery();
       if(rs.next()){
                  smt.close();
                   conn.close();
          return false;
        }else{
                
                  smt.close();
                   conn.close();
          return true;
       }

      
    }
  
    public void create_user(String name,String password) throws SQLException{
        String query="insert into user values(?,?)";
        conn=this.Connect();
        PreparedStatement smt = conn.prepareStatement(query);
        smt.setString(1, name);
        smt.setString(2, password);
        smt.execute();
        
        smt.close();
        conn.close();
    }
    public void add_subject(String name) throws SQLException{
         String query="insert into subjects values(?)";
        conn=this.Connect();
        PreparedStatement smt = conn.prepareStatement(query);
        smt.setString(1, name);
        smt.execute();
        
        smt.close();
        conn.close();
    }
    
    public boolean log(String password) throws SQLException{
        String query="Select password from user ";
        conn=this.Connect();
        boolean valid=false;
        PreparedStatement smt = conn.prepareStatement(query);
        ResultSet rs=smt.executeQuery();
        if(rs.next()){
            
         valid= password.equals(rs.getString("password"));
        }
         smt.close();
         conn.close();
        return valid;
    }
    
    public void create_class(String Name) throws SQLException{
        String query="Insert into class values (?)";
         conn=this.Connect();
        PreparedStatement smt=conn.prepareStatement(query);
        smt.setString(1, Name);
        smt.execute();
        smt.close();
        conn.close();
    }
    
    public boolean class_exists(String Name) throws SQLException{
        String query="Select * from class where name=?";
        conn=this.Connect();
        PreparedStatement smt=conn.prepareStatement(query);
        smt.setString(1, Name);
        ResultSet rs=smt.executeQuery();
        if(rs.next()){
           smt.close();
           conn.close();
          return true;
        }
         smt.close();
         conn.close();
        return false;
    }
    public Vector<String> getAllClass() throws SQLException{
       String query="Select * from class";
       Vector<String> cl=new Vector<String>();
        conn=this.Connect();
        PreparedStatement smt=conn.prepareStatement(query);
        ResultSet rs=smt.executeQuery();
        while(rs.next()){
            cl.add(rs.getString("name"));
        }
        smt.close();
        conn.close();
        return cl;
    }
    
   
    public Vector <String > getSubjects() throws SQLException{
        Vector <String> vec=new Vector<String>();
        Connection con=this.Connect();
        String query="Select name from subjects";
        PreparedStatement smt=con.prepareStatement(query);
        ResultSet rs=smt.executeQuery();
        while(rs.next()){
            vec.add(rs.getString("name"));
        }
        return vec;
    }
   
     public void add_student(String name,String lname,String fname,String mname,String classname) throws SQLException{
        Connection con=this.Connect();
         Random r = new Random();
                 String id="";
                    String alphabet = "1234567890abcdefghijklmnopqrstvuwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                 for (int i = 0; i < 4; i++) {
                    id+=alphabet.charAt(r.nextInt(alphabet.length()));
                 } 
        String student="Insert into Students values(?,?,?,?,?,?)";
        PreparedStatement smt=con.prepareStatement(student);
        smt.setString(1, name);
        smt.setString(2, lname);
        smt.setString(3, mname);
        smt.setString(4, fname);
        
        smt.setString(5, classname);
        smt.setString(6, id);
        smt.execute();
        smt.close();
        con.close();
        
        
        Vector<String> subjects=this.getSubjects();
        for(int i=0;i<subjects.size();i++){
            for(int j=0;j<2;j++){
                con=this.Connect();
                student="Insert into Grades values(?,?,?,?,?,?,?,?,?,?)";
               smt=con.prepareStatement(student);
               smt.setString(1, "");
               smt.setString(2, "");
               smt.setString(3, "");
               smt.setString(4, "");
               smt.setString(5, "");
               smt.setInt(6, j+1);
               smt.setString(7, id);
               smt.setString(8, subjects.get(i));
               smt.setString(9, "");
               smt.setString(10, "");
               smt.execute();
               smt.close();
               con.close();
            }
        }   
        
    }
    
   public Vector<String> getStudent(String id) throws SQLException{
       Vector<String> vec=new Vector<String>();
       Connection con=this.Connect();
        String query="Select * from Students where id=?";
        PreparedStatement smt=con.prepareStatement(query);
        smt.setString(1, id);
        ResultSet rs=smt.executeQuery();
        if(rs.next()){
            vec.add(rs.getString("name"));
            vec.add(rs.getString("lastname"));
            vec.add(rs.getString("mothers"));
            vec.add(rs.getString("fathers"));
            vec.add(rs.getString("class"));
            vec.add(rs.getString("id"));
               
        }
       
       smt.close();
        con.close();
       return vec;
   }
   
   
     public Object[][]searchStudents(String text) {
       try {
           Vector<String> vec=new Vector<String>();
           Connection con=this.Connect();
           String query="Select * from Students  where lastname LIKE ? order by lastname asc";
           PreparedStatement smt;
           
           smt = con.prepareStatement(query);             
           
          smt.setString(1, text);
           
           ResultSet rs=smt.executeQuery();
           
           
               while(rs.next()){
                   vec.add(rs.getString("lastname"));
                   vec.add(rs.getString("name"));
                   vec.add(rs.getString("class"));
                   vec.add(rs.getString("fathers"));
                   vec.add(rs.getString("mothers"));
                   vec.add(rs.getString("id"));
               }
               
           int size=vec.size()/6;
           
           Object[][] ob=new Object[size][6];
           int rec=0,det=0;
      
                    while(rec<size){
           
                       ob[rec][0]=vec.get(det);
                       ob[rec][1]=vec.get(det+1);
                       ob[rec][2]=vec.get(det+2);
                       ob[rec][3]=vec.get(det+3);
                       ob[rec][4]=vec.get(det+4);
                       ob[rec][5]=vec.get(det+5);
                       if(det%6==0)rec++;
                       det++;
                     
                    }           
                 
               
           

           smt.close();
           con.close();
           return ob;
       } catch (Exception e) {
           System.out.println(e);
       }
       return null;
   }
   
     public Object[][]getAllStudents(String classname) {
       try {
           Vector<String> vec=new Vector<String>();
           Connection con=this.Connect();
           String query="Select * from Students order by lastname asc";
           PreparedStatement smt;
           
           smt = con.prepareStatement(query);             
           
           if(!classname.equals("all")){
                  
               query="Select * from Students where class=? order by lastname asc";
               smt = con.prepareStatement(query); 
               smt.setString(1, classname);
           }
           
           ResultSet rs=smt.executeQuery();
           
           
               while(rs.next()){
                   vec.add(rs.getString("lastname"));
                   vec.add(rs.getString("name"));
                   vec.add(rs.getString("class"));
                   vec.add(rs.getString("fathers"));
                   vec.add(rs.getString("mothers"));
                   vec.add(rs.getString("id"));
               }
               
           int size=vec.size()/6;
           
           Object[][] ob=new Object[size][6];
           int rec=0,det=0;
      
                    while(rec<size){
           
                       ob[rec][0]=vec.get(det);
                       ob[rec][1]=vec.get(det+1);
                       ob[rec][2]=vec.get(det+2);
                       ob[rec][3]=vec.get(det+3);
                       ob[rec][4]=vec.get(det+4);
                       ob[rec][5]=vec.get(det+5);
                       if(det%6==0)rec++;
                       det++;
                     
                    }           
                 
               
           

           smt.close();
           con.close();
           return ob;
       } catch (Exception e) {
           System.out.println(e);
       }
       return null;
   }
   
   
      
   public Vector<String> getGrades(String id,int term,String Subject) throws SQLException{
       System.out.println("mpika");
       Vector<String> vec=new Vector<String>();
       Connection con=this.Connect();
        String query="Select * from Grades where id=? and term=? and subject=? ";
        PreparedStatement smt=con.prepareStatement(query);
        smt.setString(1, id);
        smt.setInt(2, term);
        smt.setString(3, Subject);
        ResultSet rs=smt.executeQuery();
        if(rs.next()){
            vec.add(rs.getString("midterm"));
            vec.add(rs.getString("test1"));
            vec.add(rs.getString("test2"));
            vec.add(rs.getString("evaluation"));
            vec.add(rs.getString("projects"));
            vec.add(rs.getString("oral"));
            vec.add(rs.getString("total"));
               
        }
       
       smt.close();
        con.close();
        
       return vec;
   }
    
   public void updateGrades(String id,int term,String Subject,
           String midterm,String test1,String test2,String evaluation,String projects,String oral,String total) throws SQLException{
       Connection con=this.Connect();
       String query="Update Grades SET midterm=?,test1=?,test2=?,evaluation=?,projects=?,oral=?,total=? WHERE id=? and term=? and subject=? ";
        PreparedStatement smt=con.prepareStatement(query);
        smt.setString(1, midterm);
        smt.setString(2, test1);
        smt.setString(3, test2);
        smt.setString(4, evaluation);
        smt.setString(5, projects);
        smt.setString(6, oral);
        smt.setString(7, total);
        smt.setString(8, id);
        smt.setInt(9, term);
        smt.setString(10, Subject);
        smt.execute();
         smt.close();
        con.close();
   }
   
   public void deleteStudent(String id) throws SQLException{
        Connection con=this.Connect();
       String query="Delete from Grades where id=? ";
        PreparedStatement smt=con.prepareStatement(query);
        smt.setString(1, id);
        smt.execute();
        smt.close();
        con.close();
         con=this.Connect();
        query="Delete from Students where id=? ";
         smt=con.prepareStatement(query);
        smt.setString(1, id);
        smt.execute();
        smt.close();
        con.close();
   }
    public void deleteClass(String classname) throws SQLException{
        Connection con=this.Connect();
       String query="Delete from class where name=? ";
        PreparedStatement smt=con.prepareStatement(query);
        smt.setString(1, classname);
        smt.execute();
        smt.close();
        con.close();
         con=this.Connect();
        query="Delete from Students where class=? ";
         smt=con.prepareStatement(query);
        smt.setString(1, classname);
        smt.execute();
        smt.close();
        con.close();
   }
    
   public void updateClass(String classname,String newclassname) throws SQLException{
       Connection con=this.Connect();
       String query="Update class SET name=? WHERE name=?";
        PreparedStatement smt=con.prepareStatement(query);
        smt.setString(1, newclassname);
        smt.setString(2, classname);
        smt.execute();
        smt.close();
        con.close();
        
         con=this.Connect();
         query="Update Students SET class=? WHERE class=?";
        smt=con.prepareStatement(query);
        smt.setString(1, newclassname);
        smt.setString(2, classname);
        smt.execute();
        smt.close();
        con.close();
        
   }
   
     public void updateGradesAfterClass(String classname) throws SQLException{
       Connection con=this.Connect();
       String sel="Select id from Students where class=?";
       PreparedStatement sm=con.prepareStatement(sel);
       sm.setString(1, classname);
       ResultSet rs=sm.executeQuery();
       Vector<String>id=new Vector<String>();
       while(rs.next()){
           id.add(rs.getString("id"));
       }
        sm.close();
        con.close();
        int i=0;
        while(i<id.size()){
               String query="Update Grades SET midterm=?,test1=?,test2=?,evaluation=?,projects=?,oral=?,total=? WHERE id=?";
               con=this.Connect();
                PreparedStatement smt=con.prepareStatement(query);
        smt.setString(1, "");
        smt.setString(2, "");
        smt.setString(3, "");
        smt.setString(4, "");
        smt.setString(5, "");
        smt.setString(6, "");
        smt.setString(7, "");
        smt.setString(8, id.get(i));
        
        smt.execute();
         smt.close();
        con.close();
        i++;
        }
       
   }
   
   public void emptyDatabase() throws SQLException{
       String Grades="Delete from Grades";
       String Students="Delete from Students";
       String Class="Delete from class";
       String subjects="Delete from subjects";
       String user="Delete from user";
       
       Connection con=this.Connect();
       PreparedStatement smt=con.prepareStatement(Grades);
       smt.execute();
       smt.close();
       con.close();
       
       con=this.Connect();
       smt=con.prepareStatement(Class);
       smt.execute();
       smt.close();
       con.close();
       
       con=this.Connect();
       smt=con.prepareStatement(subjects);
       smt.execute();
       smt.close();
       con.close();
       
       con=this.Connect();
       smt=con.prepareStatement(Students);
       smt.execute();
       smt.close();
       con.close();
       
       con=this.Connect();
       smt=con.prepareStatement(user);
       smt.execute();
       smt.close();
       con.close();
               
   }
   public void updateStudent(String name,String lname,String fname,String mname,String classname,String id) throws SQLException{
       String query="update Students set name=?, lastname=?, mothers=?, fathers=?, class=? where id=?";
       Connection con=this.Connect();
       PreparedStatement smt=con.prepareStatement(query);
       smt.setString(1, name);
       smt.setString(2, lname);
       smt.setString(3, fname);
       smt.setString(4, mname);
       smt.setString(5, classname);
       smt.setString(6, id);
       smt.execute();
       
   }
}
