    import java.sql.*;
    public class sample
    {

     
        static final String  driver ="com.mysql.jdbc.Driver";
        static final String  url ="jdbc:mysql://localhost/demo";
        static final String USER = "root";
        static final String PASS = "admin";
    
         
        public static void main(String[] args) throws SQLException, ClassNotFoundException
        {
     
Class.forName("com.mysql.jdbc.Driver") ;
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", USER, PASS) ;
Statement stmt = conn.createStatement() ;

            {
                String sql;
                sql="select * from a";
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    System.out.println("result");
                    
                    while(rs.next())
                    {
                        int f= rs.getInt("a.x");
                        
                        System.out.println("a=" + f);
                        
                    }
                }
            }
            
            
        }
    }