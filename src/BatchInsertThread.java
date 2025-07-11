import org.apache.poi.ss.usermodel.Row;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

class BatchInsertThread implements  Runnable{
private  List<Row>rows ;

public BatchInsertThread(List<Row>rows){
    this.rows = rows;
}
    Connection conn = StudentManagement.getConnection() ;
  public  void run(){



      try{
          String sql = "INSERT INTO results (enroll_id, first_name, last_name, department, mobile_no, marks , grade) " +
                  "VALUES (?, ?, ?, ?, ?, ?, ?)";

          PreparedStatement stmt = conn.prepareStatement(sql);


          for (Row row : rows) {
              stmt.setString(1, row.getCell(0).getStringCellValue());
              stmt.setString(2, row.getCell(1).getStringCellValue());
              stmt.setString(3, row.getCell(2).getStringCellValue());
              stmt.setString(4, row.getCell(3).getStringCellValue());
              stmt.setString(5, row.getCell(4).getStringCellValue());
              stmt.setInt(6, (int) row.getCell  (5).getNumericCellValue());
              stmt.setString(7, row.getCell(6).getStringCellValue());
              stmt.addBatch();
          }

stmt.executeBatch() ;
          System.out.println(Thread.currentThread().getName() + " Inserted " + rows.size() + " rows .");


      }
      catch (SQLException e ){
          e.printStackTrace();
      }



  }

}
