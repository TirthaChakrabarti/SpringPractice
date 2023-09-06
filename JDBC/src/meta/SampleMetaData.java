package meta;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import myconnections.MyConnection;

public class SampleMetaData {
	
	MyConnection myCon;
	
	public SampleMetaData() {
		myCon = new MyConnection();
	}
	
	public void getDatabaseMetaDataInfo() {
		Connection con = myCon.getMyConection();
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
			System.out.println("Database Major Version: "+dbmd.getDatabaseMajorVersion());
			System.out.println("Database Minor Version: "+dbmd.getDatabaseMinorVersion());
			
			System.out.println("Driver Name: "+dbmd.getDriverName());
			System.out.println("Driver Version: "+dbmd.getDriverVersion());
			
			//tables metadata (can take a separate method
			ResultSet rs = dbmd.getTables(null, null, null, null);
			System.out.println("The tables present are: ");
			while(rs.next()) {
				System.out.println(rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getResultSetMetaDataInfo() {
		Connection con = myCon.getMyConection();
		String query = "Select * from Employees";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("The column info: ");
			System.out.println("Column count: "+rsmd.getColumnCount());
			System.out.println("Column Label of 1st column: "+rsmd.getColumnLabel(1));
			System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
			System.out.println("Column Type of 1st column: "+rsmd.getColumnType(1));
			System.out.println("Column TypeName of 1st column: "+rsmd.getColumnTypeName(1));
			
			System.out.println("Column Label of 2nd column: "+rsmd.getColumnLabel(2));
			System.out.println("Column Name of 2nd column: "+rsmd.getColumnName(2));
			System.out.println("Column Type of 2nd column: "+rsmd.getColumnType(2));
			System.out.println("Column TypeName of 2nd column: "+rsmd.getColumnTypeName(2));
			
			System.out.println("Column Label of 5th column: "+rsmd.getColumnLabel(5));
			System.out.println("Column Name of 5th column: "+rsmd.getColumnName(5));
			System.out.println("Column Type of 5th column: "+rsmd.getColumnType(5));
			System.out.println("Column TypeName 5th 2nd column: "+rsmd.getColumnTypeName(5));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		SampleMetaData smd = new SampleMetaData();
		smd.getDatabaseMetaDataInfo();
		System.out.println();
		smd.getResultSetMetaDataInfo();
	}
}
