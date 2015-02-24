import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainClass 
{
	
	public static void main(String[] args) throws SQLException
	{
		Connection myConn = null;
        java.sql.Statement myStmt = null;
        ResultSet myRs = null;
         
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "statealex", "Alex930825");
             
            System.out.println("Database connection successful!\n");
             
            // 2. Create a statement
            myStmt = myConn.createStatement();
             
            // 3. Execute SQL query
            ResultSet r = myStmt.executeQuery("SELECT COUNT(*) AS rowcount FROM ENCRYPTEDSTUDENT");
            r.next();
            int count = r.getInt("rowcount") ;
            r.close() ;
            System.out.println("MyTable has " + count + " row(s).");
            // am extras cate randuri sunt in baza de date, acum putem aloca memorie matricei de puncte criptate
            
            // "INSERT INTO ENCRYPTEDSTUDENT(DIMENSION1, DIMENSION2, DIMENSION3, DDIMENSION) VALUES (1,2,3,4)"
            /* 
            // 4. Process the result set
            while (myRs.next()) 
            {
                System.out.println(myRs.getString("last_name") + ", " 
                                + myRs.getString("first_name"));
            }*/
            
            
        	EncryptedStudent Estudent=new EncryptedStudent();
    		Estudent.initStudent(51,3,1);
    		Estudent.encryptedPointMethod();
    		java.sql.Statement myStmtInsert = myConn.createStatement();
    		ResultSet r1 = myStmtInsert.executeQuery("INSERT INTO ENCRYPTEDSTUDENT(DIMENSION1, DIMENSION2, DIMENSION3, DDIMENSION)"
    				+ " VALUES ("+Estudent.dimension1+","+Estudent.dimension2+","+Estudent.dimension3+","+Estudent.ePlusdimension+")");
    		System.out.println("Inserare reusita");
    		
            
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (myRs != null) {
                myRs.close();
            }
             
            if (myStmt != null) {
                myStmt.close();
            }
             
            if (myConn != null) {
                myConn.close();
            }
        }

		//String sql = "SELECT DIMENSION1 FROM ENCRYPTEDSTUDENT";
		//SQLQuery query = s.createSQLQuery(sql).addScalar("DIMENSION1");

		/*
		 * SELECT COUNT(*) FROM table_name;
		 * Numaram cate randuri sunt in tabela pentru a putea aloca memorie pentru o matrice in care sa importam datele.
		 */
       
	}
	
}
