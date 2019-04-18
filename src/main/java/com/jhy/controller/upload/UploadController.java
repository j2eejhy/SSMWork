package com.jhy.controller.upload;

import com.jhy.util.SFTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @Auther: haiyang.jin
 * @Date: 2019/4/18 10:05
 * @Description:
 */
@Controller
@Slf4j
public class UploadController {

    @RequestMapping("/upload1")
    public String upload(Model model){
        return "/upload";
    }

    @RequestMapping("/upload2")
    public String uploadSftp(Model model){
        return "/uploadSftp";
    }

    /**
     * sftp模式下载 使用SFTPUtil工具类 上传下载
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadSftp")
    public String uploadSftp(@RequestParam("file") MultipartFile file , HttpServletRequest request) throws Exception {

        //获取到文件名
        String fileName = file.getOriginalFilename();
        //将MultipartFile转换成流的形式存储
        InputStream in = file.getInputStream();

        SFTPUtil sftp = new SFTPUtil("root", "Jin@123456", "106.13.7.126", 22);
        sftp.login();
        sftp.upload("/usr","upload",fileName ,in);
        sftp.logout();
        return "redirect:/";
    }

    /**
     * 上传文件到本服务器
     * @param myfiles
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/uploadIo")
    public String upload(@RequestParam MultipartFile[] myfiles,HttpServletRequest request) throws IOException {
        for(MultipartFile file : myfiles){
            //此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了
            if(file.isEmpty()){
                System.out.println("文件为空!");
            }
            else{
                //得到上传的文件名
                String fileName = file.getOriginalFilename();
                /*
                //得到服务器项目发布运行所在地址
                String path1 = request.getSession().getServletContext().getRealPath("image")+File.separator;
                File f = new File(path1);
                if (!f.exists()) {
                    f.mkdirs();
                }
                //  此处未使用UUID来生成唯一标识,用日期做为标识
                String path = path1+ new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date())+ fileName;
                //查看文件上传路径,方便查找
                System.out.println(path);
                //把文件上传至path的路径
                File localFile = new File(path);
                */
                //获取电脑路径
                String path1 = System.getProperty("file.physical","D:/java/image/");
                System.out.println(file.getSize());
                //判断有没有改文件夹 没有的话创建
                File f = new File(path1);
                if (!f.exists()) {
                    f.mkdirs();
                }
                String path = path1 + fileName;
                //查看文件上传路径,方便查找
                System.out.println(path);
                //把文件上传至path的路径
                File localFile = new File(path);
                file.transferTo(localFile);
            }
        }
        return "uploadSuccess";
    }

    @RequestMapping("/download")
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response) {
        try {
            fileName = "“智慧龙华”一期经济促进服务平台建设项目初步设计及概算【20180725zhong1.1版】-整理版.docx";
            response.setCharacterEncoding("UTF-8");
            response.setContentType("multipart/form-data");
            //设置文件名称编码 防止乱码
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            //项目路径
            //String path = request.getSession().getServletContext().getRealPath("image")+File.separator;
            String path = System.getProperty("file.physical","D:/java/image/");
            File file = new File(path + fileName);
            if (!file.exists()) {
                System.out.println("下载文件不存在！");
                return;
            }
            InputStream inputStream = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  返回值要注意，要不然就出现下面这句错误！
        //java+getOutputStream() has already been called for this response
    }

}
