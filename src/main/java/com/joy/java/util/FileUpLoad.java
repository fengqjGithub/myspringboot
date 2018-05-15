package com.joy.java.util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/fileup")
@Api(description = "上传文件")
public class FileUpLoad {
    private String savePath = this.getClass().getResource("/").getPath() + "static";

    /**
     * 文件上传
     *
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    @ApiOperation(value = "文件上传", response = String.class, notes = "备注")
    public String fileupload(HttpServletRequest request) throws ServletException, IOException {
        String timestamp = new Date().getTime() + "";
        if (savePath.indexOf(":") > -1) {
            savePath = savePath.substring(savePath.indexOf("/") + 1);
        }
        //创建文件夹
        String shijian = "/upload" + "/";
        File wshijianjj = new File(savePath + shijian);
        if (!wshijianjj.exists() && !wshijianjj.isDirectory()) {
            wshijianjj.mkdirs();
        }
        //使用Apache文件上传组件处理文件上传步骤：
        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码
        upload.setHeaderEncoding("UTF-8");
        //3、判断提交上来的数据是否是上传表单的数据
        if (!ServletFileUpload.isMultipartContent(request)) {
            return "无上传文件";
        }
        //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
        List<FileItem> list = null;
        try {
            list = upload.parseRequest(request);
        } catch (FileUploadException e) {
            return "解析请求数据失败";
        }
        boolean isok = false;
        String addAndFilename = "";
        try {
            for (FileItem f : list) {
                if (!f.isFormField() && !isok) {
                    //得到上传的文件名称，
                    String filename = f.getName();
                    if (filename == null || filename.trim().equals("")) continue;
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);
                    //获取item中的上传文件的输入流
                    InputStream in = f.getInputStream();
                    //创建一个文件输出流
                    //生成随机的地址
                    System.out.println("上传文件地址：" + savePath + addAndFilename);
                    FileOutputStream out = new FileOutputStream(savePath + addAndFilename);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while ((len = in.read(buffer)) > 0) {
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    f.delete();
                    isok = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "上传成功，地址：" + savePath + addAndFilename;
    }

}