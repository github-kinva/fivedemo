package cn.kinva.controller;

import cn.kinva.pojo.User;
import cn.kinva.service.UserService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
   @RequestMapping("saveInfo")
    public String saveInfo(User user){
       boolean user1= userService.save(user);
       if(user1) {
           return "success";
       }
       return "error";
    }


    //将excle导入

    //1将excle表格中的数据中页面中显示---查询
    //因为需要将文件到出是有视图，所以选用了modelAndView
    @RequestMapping("getUserList")
    public ModelAndView getUserList(){
       //从数据库中获取数据
      List<User> userlist= userService.getAllInfo();
      ModelAndView mav =new ModelAndView();
      mav.setViewName("userlist");
      //将获取到数据放入userlist域,在jsp页面中显示
     mav.addObject("userlist",userlist);
     return mav;
    }

    //2将excle的内容导入到数据库，并在页面中显示--必须要格式一致，id是唯一，如果之前有了不能用统一的id
    //@RequestParam注解将请求参数绑定到你控制器的方法参数上
    @RequestMapping("excelImport")
    public String excelImport(@RequestParam MultipartFile excel) throws IOException {
       //获取流
      InputStream is= excel.getInputStream();
       //利用输入流构造workbook对象
        XSSFWorkbook wb=new XSSFWorkbook(is);
        //获取sheet工作表对象
        XSSFSheet sheet =wb.getSheetAt(0);
        //获取行数--返回物理定义的行数(不是工作表中的行数)
        int rows=sheet.getPhysicalNumberOfRows();
        //遍历获取到的行
        for(int i=1;i<rows ;i++){
            XSSFRow row =sheet.getRow(i);

            XSSFCell cell=row.getCell(0);
            cell.setCellType(CellType.NUMERIC);  //int类型，这里不用转换
            int id= (int) cell.getNumericCellValue();  //获取到id的值，从0开始

            XSSFCell cellname=row.getCell(1);
            cellname.setCellType(CellType.STRING);
            String name=cellname.getStringCellValue();//获取到id的值，从1开始


            //把获取的到行、列数据封装到类中
            User user=new User();
            user.setId(id);
            user.setName(name);


            userService.save(user);
        }
        //在跳转到本函数中表示在修改后更新(刷新)
        return "redirect:/getUserList.action";

    }


    /*把查询到的数据导出到指定位置*/
    /*
    * 查询list
    * 创建workbook
    * 创建sheet
    * 创建行、列（for循环）
    * 写给客户端-指定的位置
    * */
    @RequestMapping("exp")
    public String exp(){
        //查询
        List<User> userList=userService.getAllInfo();

        //创建workbook
        XSSFWorkbook WB=new XSSFWorkbook();
        //创建sheet
        XSSFSheet sheet=WB.createSheet();
        //遍历sheet  获取里面的值
        for(int i=0;i<userList.size();i++){
           XSSFRow row= sheet.createRow(i);
           row.createCell(0).setCellValue(userList.get(i).getId());
           row.createCell(1).setCellValue(userList.get(i).getName());
        }
        //输出到指定位置和给定导出的名称
        try {
            FileOutputStream fos=new FileOutputStream("D:\\addons\\testpoi2.xlsx");
            //显示在控制台
            try {
                WB.write(fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "ok";

    }


}
