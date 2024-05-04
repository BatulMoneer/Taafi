/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taafi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.mapping.List;

/**
 *
 * @author albat
 */
public class Main2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("AddMedicine.fxml"));
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("C:\\Users\\albat\\Documents\\NetBeansProjects\\Taafi\\src\\taafi\\Style.css");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main2 main =new Main2();
        medicine u1 = new medicine();
        u1.setMedicineid(0);
        u1.setDescription("dd");
        u1.setDoseno("3");
        u1.setDosetime("33");
        u1.setEnddate("33");
        u1.setFormula("ff");
        u1.setImage("dd");
        u1.setMedicinename("gg");
        u1.setStartdate("44");
        main.insertActor(u1);
        
        /*
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<medicine> uList = null;
        
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        uList = query.list();
        session.getTransaction().commit();
        session.close();
        
       System.out.println(uList.get(0));
       for(medicine u: uList){
            System.out.println(u.getNumber()+" "+u.getName()+" "+u.getUserName());
        
        
    }*/
        launch(args);
       
    }
    private final String url = "jdbc:mysql://localhost:3306/ap_project";
    private final String user = "root";
    private final String password = "Wren0966599731";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    
       
       public void insertActor(medicine us) {
        String SQL = "INSERT INTO medicine(medicineid,medicinename,startdate,enddate, description, formula, doseno,dosetime,image) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        
        try (Connection conn = connect();
                
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setInt(1, us.getMedicineid());
            pstmt.setString(2, us.getMedicinename());
            pstmt.setString(3, us.getStartdate());
            pstmt.setString(4, us.getEnddate());
            pstmt.setString(5, us.getDescription());
            pstmt.setString(6, us.getFormula());
            pstmt.setString(7, us.getDoseno());
            pstmt.setString(8, us.getDosetime());
            pstmt.setString(9, us.getImage());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
