package page;

import java.sql.*; // to import everything from sql database

public class DatabasePage {

	public static String getData(String columnName) throws ClassNotFoundException, SQLException {

       // Setting properties for mysql
		Class.forName("com.mysql.cj.jdbc.Driver"); //driver that we are using now is mysql
	
		String sqlurl = "jdbc:mysql://localhost:3306/august2020";
		String sqlusername="root";
		String sqlpass ="root";
		String Query= "select * from Users";
		
		// creating a connection to your local database
		Connection con = DriverManager.getConnection(sqlurl, sqlusername, sqlpass);

		// empowering the con reference valiable to execute queries
		Statement smt = con.createStatement();

		// delivering the sql query
		ResultSet rs = smt.executeQuery(Query);
		while (rs.next()) {
			return rs.getString(columnName);
		}
		return columnName;
	}

}
