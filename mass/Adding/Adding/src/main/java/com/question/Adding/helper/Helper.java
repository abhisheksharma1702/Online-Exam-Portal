package com.question.Adding.helper;

import com.question.Adding.entity.Questions;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {


        public static boolean checkExcelFormat(MultipartFile file){

            String contentType = file.getContentType();

            //checking if content of file is excel or not
            if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
                return  true;
            }
            else {
                return false;
            }

        }

        //converts excel to list

        public static List<Questions> convertExcelToListOfQuestion(InputStream is){

            List<Questions> list=new ArrayList<>();
            try{

                XSSFWorkbook workbook = new XSSFWorkbook(is);
                XSSFSheet sheet = workbook.getSheet("data");

                int rowNumber=0;
                Iterator<Row> iterator = sheet.iterator();

                while(iterator.hasNext()){
                    Row row=iterator.next();
                    if(rowNumber==0)
                    {
                        rowNumber++;
                        continue;
                    }
                    Iterator<Cell> cells = row.iterator();

                    int cid=0;

                    Questions q=new Questions();

                    while(cells.hasNext()){

                        Cell cell = cells.next();

                        switch (cid)
                        {
                            case 0:
                                q.setQuestion_id((int)cell.getNumericCellValue());
                                break;
                            case 1:
                                q.setCorrect_option(cell.getStringCellValue());
                                break;
                            case 2:
                                q.setCourseId((int)cell.getNumericCellValue());
                                break;
                            case 3:
                                q.setLevelId((int)cell.getNumericCellValue());
                                break;
                            case 4:
                                q.setOption_1(cell.getStringCellValue());
                                break;

                            case 5:
                                q.setOption_2(cell.getStringCellValue());
                                break;
                            case 6:
                                q.setOption_3(cell.getStringCellValue());
                                break;
                            case 7:
                                q.setOption_4(cell.getStringCellValue());
                                break;
                            case 8:
                                q.setQuestion(cell.getStringCellValue());
                                break;

                            default:
                                break;
                        }
                        cid++;

                    }
                    list.add(q);
                }



            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return list;
        }
    }


