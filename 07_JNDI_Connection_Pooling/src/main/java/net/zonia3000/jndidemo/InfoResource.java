package net.zonia3000.jndidemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@RequestScoped
@Path("info")
public class InfoResource {

    @Resource(lookup = "jdbc/utenti")
    DataSource dataSource;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() throws NamingException, SQLException {
        
        StringBuilder sb = new StringBuilder();
        
        try(Connection conn = dataSource.getConnection();
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery("SELECT * FROM UTENTE")) {
            
            while(rs.next()) {
                int id = rs.getInt("ID");
                String username = rs.getString("USERNAME");
                
                sb.append("id=");
                sb.append(id);
                sb.append(", username=");
                sb.append(username);
                sb.append("\n");
            }
            
            return sb.toString();
        }
    }

}
