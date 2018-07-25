package cn.kinva.test;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*poi文件的读写，记得要添加依赖*/
public class Demo {
    public static void main(String[] args) throws IOException {
        //创建新的workbook--在指定路径中
        XSSFWorkbook wb=new XSSFWorkbook();
        XSSFSheet sheet=wb.createSheet();
        //从索引0开始，2表示是第3行第3列
        //行
        XSSFRow row=sheet.createRow(2);
        //列
        XSSFCell cell=row.createCell(2);
        //在指定的表格中添加数据
        cell.setCellValue("测试");
        //输出到指定的路径(要抛出异常）--输出流
        FileOutputStream fos=new FileOutputStream("C:\\Users\\oujh7\\Desktop\\demo2.xlsx");
        //在页面中输出
        wb.write(fos);
        System.out.println("成功");

    }


   /* *//*读取表格*//*
    public static void main(String[] args) throws IOException {
        //创建输入流，指定要读取的文件
        FileInputStream fis=new FileInputStream("C:\\Users\\oujh7\\Desktop\\demo.xlsx");
        //利用输入流去获取workbook对象
       XSSFWorkbook wb= new XSSFWorkbook(fis);
       //获取sheel中的值
       XSSFSheet sheet  = wb.getSheetAt(0);
       //获取sheet表中的行列，获取表中指定的数据-----
        XSSFRow row = sheet.getRow(2);
        XSSFCell cell = row.getCell(2);
        String value = cell.getStringCellValue();
        System.out.println(value);

        XSSFRow row2 = sheet.getRow(5);
        XSSFCell cell2 = row2.getCell(3);
        String value2 = cell2.getStringCellValue();
        System.out.println(value2);
        //获取文档中的sheet表
    }*/

    /*//通过工厂方法调用输入流读取表中的数据
    public static void main(String[] args) throws IOException, InvalidFormatException {
        //找到指定的文件
        FileInputStream fis=new FileInputStream("C:\\Users\\oujh7\\Desktop\\demo.xlsx");
        //利用工厂模式获取workbook
        Workbook wb = WorkbookFactory.create(fis);
        //得到sheet工作表对象
        Sheet sheet = wb.getSheetAt(0);
        //获取sheet表中的行列，获取表中指定的数据-----
        Row row = sheet.getRow(2);
        Cell cell = row.getCell(2);
        String value = cell.getStringCellValue();
        System.out.println(value);

        Row row2 = sheet.getRow(5);
        Cell cell2 = row2.getCell(3);
        String value2 = cell2.getStringCellValue();
        System.out.println(value2);

    }*/



   /* //将xlsx文件里面的数据表格式输出到控制台
    public static void main(String[] args) throws IOException {
        //获取xlsx文件
        String path="C:\\Users\\oujh7\\Desktop\\demo.xlsx";
        //转换为输入流
        FileInputStream fis =  new FileInputStream(path);
        //获取workbook对象
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        //得到sheet工作表对象
        XSSFSheet sheet = wb.getSheetAt(0);

        //获取到表的行数，遍历获取的所有行
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0 ; i<rows ; i++) {
            XSSFRow row = sheet.getRow(i);
            //获取到表的行数，遍历获取的所有列
            int cells = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cells; j++) {
                XSSFCell cell = row.getCell(j);
                cell.setCellType(CellType.STRING);
                String value = cell.getStringCellValue();
                System.out.print(value + "   ");
            }
            //控制台输出
            System.out.println();
        }
        fis.close();
        }

*/
}
