/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5.persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kata5.model.Mail;
import kata5.persistence.ObjectsListLoader;

/**
 *
 * @author abiam
 */
public class DatabaseMailListLoader implements ObjectsListLoader{

    @Override
    public List<Mail> loadMails(String databaseName) {
        List<Mail> mails = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseMailListLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName);Statement statement = connection.createStatement();) {
            ResultSet result = statement.executeQuery("SELECT email FROM people");
            while(result.next()){
                String email = result.getString("email");
                if(Mail.isMail(email)){
                    mails.add(new Mail(email));
                }
                //System.out.println(email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMailListLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mails;
    }
    
}
