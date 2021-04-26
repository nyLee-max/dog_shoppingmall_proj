package dog_shoppingmall_proj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {   
   
public static Connection getConnection() {
   
//   웹에선 테스트 못한다/
//impl 작동하기 위해서 Jdbcutil있어야함
      Connection con = null;      
         try {
            String url = "jdbc:mysql://localhost:3306/shoppingmall?useSSL=false";
            String id = "user_shoppingmall";            
            String passwd = "rootroot";
            
            con = DriverManager.getConnection(url, id, passwd);
         } catch (SQLException e) {
            e.printStackTrace();
         }   

      return con;
   }
}