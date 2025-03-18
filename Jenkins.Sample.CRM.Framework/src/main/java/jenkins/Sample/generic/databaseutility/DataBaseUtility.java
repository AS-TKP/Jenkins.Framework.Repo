package jenkins.Sample.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn; //make it global variable
	//establish connection
public void getDbConnection(String url, String user,  String password) throws Throwable {
	try {
	Driver driverref = new Driver();
	DriverManager.registerDriver(driverref);
	 conn = DriverManager.getConnection(url, user, password);
	}catch(Exception e){}
}
//close the connection 
public void closeDbconnection() throws Throwable {
	try{
		conn.close();
	}catch(Exception e) {}
}
//hardcode the url,un,pwd
public void getDbConnection() throws Throwable {
	try {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	 conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	}catch(Exception e){}
	}
//close the connection 
public void closeDbconnection1() throws Throwable {
	try{
		conn.close();
	}catch(Exception e) {}
}
//for execution of select query
public ResultSet executeSelectQuery(String Query) throws Throwable {
	ResultSet result = null;
	try{
		Statement stat =  conn.createStatement();
	    result = stat.executeQuery(Query);	
        }catch(Exception e) {
        }
	    return result; //table
}
//for execution of non-select query
public int executeNonSelectQuery(String Query) throws Throwable {
	int result = 0;
	try{
		Statement stat =  conn.createStatement();
	    result = stat.executeUpdate(Query);	
        }catch(Exception e) {
        }
	    return result; // int value
}

}
