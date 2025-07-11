
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class UploadResult {

    public static void main(String[] args) {





        String ResultExcel = "results_with_marks.xlsx" ;

        int batchSize = 100 ;



        try{
//            long start = System.currentTimeMillis() ;

            //read Excel
            FileInputStream inputStream = new FileInputStream(ResultExcel) ;
            Workbook workbook = new XSSFWorkbook(inputStream);


            Sheet sheet = workbook.getSheetAt(0) ;

            Iterator<Row> rowIterator = sheet.iterator() ;






            int count = 0 ;
            List<Row> currentBatch = new ArrayList<>() ;
            List<Thread> threads = new ArrayList<>() ;

            // skip header
            if (rowIterator.hasNext()) rowIterator.next();

            System.out.println("upper body of loop ");
            while(rowIterator.hasNext()){

                Row row = rowIterator.next() ;


               currentBatch.add(row) ;

                if(++count % batchSize == 0 ){
                    System.out.println("execute batch" );
                    Thread t = new Thread(new BatchInsertThread(new ArrayList<>(currentBatch)));
                    t.start();
     threads.add(t) ;
                  currentBatch.clear();
                }
            }
            //final batch

          if(!currentBatch.isEmpty()){
              System.out.println("if remaining batch");
              Thread t = new Thread(new BatchInsertThread(new ArrayList<>(currentBatch))) ;
              t.start();
              threads.add(t) ;
          }

          //waiting for threads
            for(Thread t : threads ){
                try{
                    t.join();
                }
                catch (InterruptedException e ){
                    e.printStackTrace();
                }
            }

            System.out.println("Import Done in parallel");
            CRUDOperation.main(null);

        }
        catch(IOException e ){
            System.out.println("Error reading File "+ e.getMessage());
        }


    }

}
