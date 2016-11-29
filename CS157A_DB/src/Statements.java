import java.sql.*;


public class Statements {

	public static void query(String Username, String Password, String ConnString, String Driver) {
		
		Connection conn;
		Statement stmt;
		ResultSet rs;
		try{
			Class.forName(Driver);
			
			conn = DriverManager.getConnection(ConnString, Username, Password);
			stmt = conn.createStatement();
			
			//select authors and order by author's last name and first name
			rs = stmt.executeQuery(SelectAuthors());
			
			System.out.println();
			System.out.println("Select all authors from authors table and order by last and first name");
			
			while(rs.next()) {
				int authorId = rs.getInt("authorId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				System.out.println("authorID: " + authorId + " firstName: " + firstName + " lastName: " + lastName);
			}
			
			System.out.println();
			
			
			
			//select all publishers from the publishers table
			rs = stmt.executeQuery(SelectPublishers());
			System.out.println("Select all publishers from publishers table");
			
			while(rs.next()) {
				int publisherID = rs.getInt("publisherID");
				String publisherName = rs.getString("publisherName");
				System.out.println("publisherID: " + publisherID + " publisherName: " + publisherName);
			}
			System.out.println();
			
			
			
			//select specific publisher 
			rs = stmt.executeQuery(SelectSpecificPublisher("Bloomsbury"));
			System.out.println("Select publisher named Bloomsbury and book information published by that publisher ordered by title");
			
			while(rs.next()) {
				String publisherName = rs.getString("publishers.publisherName");
				String title = rs.getString("titles.title");
				String copyright = rs.getString("titles.copyright");
				String isbn = rs.getString("titles.isbn");
				
				System.out.println("publisherName: " + publisherName + " title: " + title + 
						" year: " + copyright + " isbn: " + isbn);
				
			}
			System.out.println();
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Select all authors from the authors table and order information
	//alphabetically by the author's last name and first name
	private static String SelectAuthors() {
		return "SELECT * " +
				"FROM authors " +
				"ORDER BY lastName ASC, firstName ASC";
	}

	//Select all publishers from the publishers table
	private static String SelectPublishers() {
		return "SELECT * " +
				"FROM publishers";
	}
	
	//Select a specific publisher and list all books published by that publisher.
	//Include title, year and ISBN number.
	//Order the information alphabetically by title
	private static String SelectSpecificPublisher(String s) {
		return "SELECT publishers.publisherName, titles.title, titles.copyright, titles.isbn " +
				"FROM publishers, titles " +
				"WHERE publishers.publisherName='" + s + "' AND " + "publishers.publisherID=titles.publisherID " +
				"ORDER BY titles.title";
	}
}