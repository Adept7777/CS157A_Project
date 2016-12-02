import java.sql.*;


public class Tables {

	public static void add(String Username, String Password,
			String ConnString, String Driver) {

		Connection conn;
		Statement stmt;
		
		try{
			Class.forName(Driver);
			
			conn = DriverManager.getConnection(ConnString, Username, Password);
			System.out.println("Inserting entries into tables");
						
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			//sql statement to insert to table authors
			String SQLAddAuthor = "INSERT INTO authors " +
					"(authorID, firstName, lastName) " +
					"VALUES(1, 'J.K', 'Rowling')";
			//sql statement to insert to table authorISBN
			String SQLAddAuthorISBN = "INSERT INTO authorISBN " +
					"(authorId, isbn) " +
					"VALUES(1, '978140883')";
			//sql statement to insert to titles
			String SQLAddTitles = "INSERT INTO titles " +
					"(isbn, title, editionNumber, copyright, publisherID, price) " +
					"VALUES('978140883', 'Fantastic Beasts & Where to Find Them', 1, 2001, 1, 12.00)";
			String SQLAddPublishers = "INSERT INTO publishers " +
					"(publisherID, publisherName) " +
					"VALUES(1, 'Bloomsbury')";
			//adding multiple queries into a batch
			stmt.addBatch(SQLAddAuthor); stmt.addBatch(SQLAddPublishers); 
			stmt.addBatch(SQLAddTitles); stmt.addBatch(SQLAddAuthorISBN);
			
			
			
			SQLAddAuthor = "INSERT INTO authors " +
					"(authorID, firstName, lastName) " +
					"VALUES(2, 'Stephen', 'Hawking')";
			SQLAddAuthorISBN = "INSERT INTO authorISBN " +
					"(authorId, isbn) " +
					"VALUES(2, '978159777')";
			SQLAddTitles = "INSERT INTO titles " +
					"(isbn, title, editionNumber, copyright, publisherID, price) " +
					"VALUES('978159777', 'The Universe in a Nutshell', 2, 2001, 2, 35.00)";
			SQLAddPublishers = "INSERT INTO publishers " +
					"(publisherID, publisherName) " +
					"VALUES(2, 'Bantam Spectra')";
			stmt.addBatch(SQLAddAuthor); stmt.addBatch(SQLAddPublishers); 
			stmt.addBatch(SQLAddTitles); stmt.addBatch(SQLAddAuthorISBN); 

			
			
			SQLAddAuthor = "INSERT INTO authors " +
					"(authorID, firstName, lastName) " +
					"VALUES(3, 'F.Scott', 'Fitzgerald')";
			SQLAddAuthorISBN = "INSERT INTO authorISBN " +
					"(authorId, isbn) " +
					"VALUES(3, '9780816082')";
			SQLAddTitles = "INSERT INTO titles " +
					"(isbn, title, editionNumber, copyright, publisherID, price) " +
					"VALUES('9780816082', 'The Great Gatsby', 5, 1925, 3, 20.00)";
			SQLAddPublishers = "INSERT INTO publishers " +
					"(publisherID, publisherName) " +
					"VALUES(3, 'Charles Scribners Sons')";
			stmt.addBatch(SQLAddAuthor); stmt.addBatch(SQLAddPublishers); 
			stmt.addBatch(SQLAddTitles); stmt.addBatch(SQLAddAuthorISBN);
			
			
			
			SQLAddAuthorISBN = "INSERT INTO authorISBN " +
					"(authorId, isbn) " +
					"VALUES(1, '747532745')";
			SQLAddTitles = "INSERT INTO titles " +
					"(isbn, title, editionNumber, copyright, publisherID, price) " +
					"VALUES('747532745', 'Harry Potter and the Philosophers Stone', 3, 1997, 1, 30.00)";
			stmt.addBatch(SQLAddTitles); stmt.addBatch(SQLAddAuthorISBN); 
			
			
			
			SQLAddAuthor = "INSERT INTO authors " +
					"(authorID, firstName, lastName) " +
					"VALUES(4, 'Stephen', 'King')";
			SQLAddAuthorISBN = "INSERT INTO authorISBN " +
					"(authorId, isbn) " +
					"VALUES(4, '9780670813')";
			SQLAddTitles = "INSERT INTO titles " +
					"(isbn, title, editionNumber, copyright, publisherID, price) " +
					"VALUES('9780670813', 'Misery', 1, 1987, 4, 50.00)";
			SQLAddPublishers = "INSERT INTO publishers " +
					"(publisherID, publisherName) " +
					"VALUES(4, 'Viking')";
			stmt.addBatch(SQLAddAuthor); stmt.addBatch(SQLAddPublishers); 
			stmt.addBatch(SQLAddTitles); stmt.addBatch(SQLAddAuthorISBN);
			
			
			
			//executes the batch
			stmt.executeBatch();
			conn.commit();
			
			System.out.println("Finished inserting entries");
			
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
