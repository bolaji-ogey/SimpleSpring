/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.image;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ImageHandler {
    
    
    
    
    static Connection connect() throws SQLException {
      Connection connection = DriverManager.getConnection("jdbc:h2:./test", "sa", "");
      return connection;
    }
    
    
    
    
    public  void  createTable() throws SQLException {
        String  sql  =  "";        
       try (Connection connection = connect(); Statement stmt = connection.createStatement()) {
               stmt.execute(sql);             
        } 
    }
    
    
    
    // Use this for small image sizes
    static byte[] convertFileToByteArray(String filePath) throws IOException {
        File file = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(file); 
          ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            for (int len; (len = fileInputStream.read(buffer)) != -1; ) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }
    
    
    
    
    // Insert small size image file
    boolean insertFile(int id, String name, int capacity, String picture) throws SQLException, IOException {
        String insertSql = """
            INSERT INTO warehouses(id,name,capacity,picture) VALUES(?,?,?,?)
            """;
        try (Connection conn = connect()) {
            if (conn != null) {
                PreparedStatement stmt = conn.prepareStatement(insertSql);
                stmt.setInt(1, id);
                stmt.setString(2, name);
                stmt.setDouble(3, capacity);
                stmt.setBytes(4, convertFileToByteArray(picture));
                stmt.executeUpdate();
                return true;
            }
        }
        return false;
    }
    
    
    
    
    // insert large size image file
    boolean insertFileAsStream(int id,  String name,  int capacity, 
                                         String filePath) throws SQLException, IOException {
        String insertSql = """
            INSERT INTO warehouses(id,name,capacity,picture) VALUES(?,?,?,?)
            """;
        try (Connection conn = connect()) {
            if (conn != null) {
                PreparedStatement stmt = conn.prepareStatement(insertSql);
                stmt.setInt(1, id);
                stmt.setString(2, name);
                stmt.setDouble(3, capacity);
                File file = new File(filePath);
                try (FileInputStream fis = new FileInputStream(file)) {
                    stmt.setBinaryStream(4, fis, file.length());
                    stmt.executeUpdate();
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
    
    
    // Extract file from database and write it to file
    static boolean writeBlobToFile(String query, int paramIndex,   int id, 
                                         String filePath) throws IOException, SQLException {
    try (
        Connection connection = connect(); 
        PreparedStatement statement = connection.prepareStatement(query)
    ) {
        statement.setInt(paramIndex, id);
        try (
            ResultSet resultSet = statement.executeQuery(); 
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))
        ) {
            while (resultSet.next()) {
                InputStream input = resultSet.getBinaryStream("picture");
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
            }
            return true;
        }
    }
}
    
    
 
    
    /***
    @ParameterizedTest
    @CsvSource({ "1, 'Liu', 3000", "2, 'Walmart', 5000" })
    void givenBlobFile_whenInsertingTheBlobFileAsByteArray_thenSuccessful(int id,  String name,  
                                                        int capacity) throws SQLException, IOException {
        boolean result = jdbcConnection.insertFile(id, name, capacity, TEST_FILE_PATH);
        assertTrue(result);
    }
    ***/
    
    
    
    
    
}
