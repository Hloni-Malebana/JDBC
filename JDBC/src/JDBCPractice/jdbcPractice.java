package JDBCPractice;

/* 1.import
 * 2.load and register
 * 3.establish the connection
 * 4.create the statement
 * 5.execute the query
 * 6.process the query 
 * 7.close
 */
import java.sql.*;


public class jdbcPractice {

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
		try {
		System.out.println("Loading to the com.mysql.cj.jdbc.Driver driver.");
		
		/*
		 * Load class called com.mysql.jdbc.Driver
		 * this driver is sitting in the 
		 * mysql-connector-java-8.0.26.jar file.
		 */
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Step 1 :Now that the driver has loaded,the jvm will attempt to connect to the sql database.");
		/* Instantiate a Driver Manager object, a child of the 
		 * Connection class,then call the getConnection method
		 * which will establish the connection between this program
		 * and the sql database
		 */
		/*
		 * The url parameter of the getConnection() method is a
		 * database URL that specifies the subprotocol 
		 * (the database connectivity mechanism), the database
		 * or database server identifier, and a list of 
		 * properties. A second parameter to the getConnection() method
		 * , property,is the property list.
		 * 
		 */
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","hloni","Hl0ni@1447");
		
		System.out.println("Step 2 : Now that the jvm has connected to the sql server \n"
				+ "using port 3306 and the password and username root root,\n"
				+ "the jvm will read information from the Student database.");

		/* Instantiate a con object,thatz is a child of the Statement
		 * class,then call the createStatement method.
		 */
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from Student where Roll_no=1");
		
		System.out.println("Step 3...");
		
		while(rs.next()) {
		
		int roll = rs.getInt("Roll no");
		String name = rs.getString("Name");
		String city = rs.getString("City");
		String surname = rs.getString("Surname");
		
		System.out.println(roll +" "+ name +" "+ city +" "+ surname);
		}
		st.close();
		con.close();	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}