import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

public class UploadStudentFromExcel {


    public static void main(String[] args) {


        Connection conn = StudentManagement.getConnection();

        String StudentExcelpath = "students.xlsx" ;

        int batchSize = 100 ;



        try{
//            long start = System.currentTimeMillis() ;

            //read Excel
            FileInputStream inputStream = new FileInputStream(StudentExcelpath) ;
            Workbook workbook = new XSSFWorkbook(inputStream);


            Sheet sheet = workbook.getSheetAt(0) ;

            Iterator<Row> rowIterator = sheet.iterator() ;


            if(conn == null) {
                System.out.println("Connection Failed");
                return ;
            }


            conn.setAutoCommit(false);

            String sql = "INSERT INTO students (roll_no, first_name, last_name, department, mobile_no, email, enroll_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql) ;

            int count = 0 ;

            // skip header
            if (rowIterator.hasNext()) rowIterator.next();


            while(rowIterator.hasNext()){
                Row row = rowIterator.next() ;


                int rollNo = (int) row.getCell(0).getNumericCellValue();
                String firstName = row.getCell(1).getStringCellValue();
                String lastName = row.getCell(2).getStringCellValue();
                String department = row.getCell(3).getStringCellValue();
                String mobileNo = row.getCell(4).getStringCellValue();
                String email = row.getCell(5).getStringCellValue();
                String enrollId = row.getCell(6).getStringCellValue();




                statement.setInt(1, rollNo);
                statement.setString(2, firstName);
                statement.setString(3, lastName);
                statement.setString(4, department);
                statement.setString(5, mobileNo);
                statement.setString(6, email);
                statement.setString(7, enrollId);

                statement.addBatch();

                if(++count % batchSize == 0 ){
                    statement.executeBatch() ;
                }
            }
            //final batch
            statement.executeBatch() ;
            conn.commit();
            workbook.close();

            System.out.println("Import Done");
            CRUDOperation.main(null);

        }
        catch(IOException e ){
            System.out.println("Error reading File "+ e.getMessage());
        }
        catch (SQLException e ){
            System.out.println("Error in database " + e.getMessage());
        }

    }

    }


