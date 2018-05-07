package com.joy.java.util.io;

import com.joy.java.util.common.CollectionUtil;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Zip压缩综合类，依赖于commons-compress-1.5.jar。
 */
public class ZipUtil {
	private  static Logger log = Logger.getLogger(ZipUtil.class);
//	public static void main(String[] args){
//		try {
//			//new ZipUtil().decompressZip(new File("d://img.zip"),"img/pic201300006.jpg","d://");
//			new ZipUtil().decompressZip(new File("d://img.zip"),"flight.log","d://");
//			//new File("d://flight.log").delete();
//			//ZipUtil.compress(new File("D://测试压缩文件"),new File("d://img.zip"));
////			ZipUtil.compress(new File[]{new File("F:/movies/MTV/(KTV)[劉德華]世界第一等.mpg"),new File("d://ftp"),new File("e://ftp")},new File("d://压缩文件.zip"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	 /**
     * 把N多文件或文件夹压缩成zip。
     * @param files  需要压缩的文件或文件夹。
     * @param zipFile 压缩后的zip文件
	 * @throws IOException 压缩时IO异常。
     */
    public static void compress(File[] files,File zipFile) throws IOException {
        if(CollectionUtil.isEmpty(files)) {
        	return ;
        }
        
        ZipArchiveOutputStream out=null;
        try{
	        out = new ZipArchiveOutputStream(zipFile);
	        out.setUseZip64(Zip64Mode.AsNeeded);
	        //将每个文件用ZipArchiveEntry封装
	        for(File file : files) {
	            if(file == null) {
	            	continue;
	            }
	            compressOneFile(file,out,"");
	        }
        }catch(IOException e){
        	throw e;
        }finally{
        	 if(out != null) {
             	out.close();
             }
        }
    }
    
	
	/**
	 * 功能：压缩文件或文件夹。
	 * @param srcFile 源文件。
	 * @param destFile 压缩后的文件
	 * @throws IOException 压缩时出现了异常。
	 */
	public static void compress(File srcFile, File destFile) throws IOException {
		ZipArchiveOutputStream out = null;
		try {
			out = new ZipArchiveOutputStream(new BufferedOutputStream(new FileOutputStream(destFile), 1024));
			compressOneFile(srcFile,out,"");
		} finally {
			out.close();
		}
	}
	
    /**
	 * 功能：压缩单个文件,非文件夹。私有，不对外开放。
	 * @param srcFile 源文件，不能是文件夹。
	 * @param out 压缩文件的输出流。
	 * @param dir 在压缩包中的位置,根目录传入/。
	 * @throws IOException 压缩时出现了异常。
	 */
	private static void compressOneFile(File srcFile, ZipArchiveOutputStream out,String dir) throws IOException {
		if(srcFile.isDirectory()){//对文件夹进行处理。
			ZipArchiveEntry entry=new ZipArchiveEntry(dir+srcFile.getName()+"/");
			out.putArchiveEntry(entry);
			out.closeArchiveEntry(); 
			//循环文件夹中的所有文件进行压缩处理。
			String[] subFiles=srcFile.list();
			for(String subFile : subFiles){
				compressOneFile(new File(srcFile.getPath()+"/"+subFile),out,(dir+srcFile.getName()+"/"));
			}
		}else{	//普通文件。
			InputStream is = null;
			try {
				is = new BufferedInputStream(new FileInputStream(srcFile));
				//创建一个压缩包。
				ZipArchiveEntry entry = new ZipArchiveEntry(srcFile,dir+srcFile.getName());
				out.putArchiveEntry(entry);
				IOUtils.copy(is, out);
				out.closeArchiveEntry(); 
			} finally {
				if(is != null)
	                is.close();
			}
		}
	}
	
	/**
	 * 功能：解压缩zip压缩包下的所有文件。
	 * @param zipFile zip压缩文件
	 * @param dir 解压缩到这个路径下
	 * @throws IOException 文件流异常
	 */
	public void decompressZip(File zipFile,String dir) throws IOException{
        ZipFile zf = new ZipFile(zipFile);
        try {
            for (Enumeration<ZipArchiveEntry> entries = zf.getEntries();
                 entries.hasMoreElements(); ) {
                ZipArchiveEntry ze = entries.nextElement();
                //不存在则创建目标文件夹。
        		File targetFile = new File(dir, ze.getName());
        		//遇到根目录时跳过。
        		if(ze.getName().lastIndexOf("/")==(ze.getName().length()-1)){
        			continue;
        		}
        		//如果文件夹不存在，创建文件夹。
                if (!targetFile.getParentFile().exists()) {
                	targetFile.getParentFile().mkdirs();
                }
                
                InputStream i = zf.getInputStream(ze);
                OutputStream o=null;
                try {
					o=new FileOutputStream(targetFile);
					IOUtils.copy(i, o);
                } finally {
                	if(i!=null){
						i.close();
					}
					if (o!= null) {
		                o.close();
		            }
                }
            }
        } finally {
            zf.close();
        }
	}
	
	/**
	 * 功能：解压缩zip压缩包下的某个文件信息。
	 * @param zipFile zip压缩文件
	 * @param fileName 某个文件名,例如abc.zip下面的a.jpg，需要传入/abc/a.jpg。
	 * @param dir 解压缩到这个路径下
	 * @throws IOException 文件流异常
	 */
	public void decompressZip(File zipFile,String fileName,String dir) throws IOException{
		//不存在则创建目标文件夹。
		File targetFile = new File(dir, fileName);
        if (!targetFile.getParentFile().exists()) {
        	targetFile.getParentFile().mkdirs();
        }
        
		ZipFile zf = new ZipFile(zipFile);
		Enumeration<ZipArchiveEntry> zips=zf.getEntries();
		ZipArchiveEntry zip=null;
		while(zips.hasMoreElements()){
			zip = zips.nextElement();
			if(fileName.equals(zip.getName())){
				OutputStream o=null;
				InputStream i = zf.getInputStream(zip);
				try {
					o=new FileOutputStream(targetFile);
					IOUtils.copy(i, o);
				}finally{
					if(i!=null){
						i.close();
					}
					if (o!= null) {
		                o.close();
		            }
				}
			}
		}
	}
	
	/**
	 * 功能：得到zip压缩包下的某个文件信息,只能在根目录下查找。
	 * @param zipFile zip压缩文件
	 * @param fileName 某个文件名,例如abc.zip下面的a.jpg，需要传入/abc/a.jpg。
	 * @return ZipArchiveEntry 压缩文件中的这个文件,没有找到返回null。
	 * @throws IOException 文件流异常
	 */
	public ZipArchiveEntry readZip(File zipFile,String fileName) throws IOException{
		ZipFile zf = new ZipFile(zipFile);
		Enumeration<ZipArchiveEntry> zips=zf.getEntries();
		ZipArchiveEntry zip=null;
		while(zips.hasMoreElements()){
			zip = zips.nextElement();
			if(fileName.equals(zip.getName())){
				return zip;
			}
		}
		return null;
	}
	
	/**
	 * 功能：得到zip压缩包下的所有文件信息。
	 * @param zipFile zip压缩文件
	 * @return Enumeration<ZipArchiveEntry> 压缩文件中的文件枚举。
	 * @throws IOException 文件流异常
	 */
	public Enumeration<ZipArchiveEntry> readZip(File zipFile) throws IOException{
		ZipFile zf = new ZipFile(zipFile);
		Enumeration<ZipArchiveEntry> zips=zf.getEntries();
		return zips;
	}




	/**
	 * 功能：解压缩zip压缩包下的所有文件（含密码）。
	 * @param zipFile zip压缩文件
	 * @param dir 解压缩到这个路径下
	 * @param pwd 密码
	 * @throws IOException 文件流异常
	 */
	public static boolean decompressZipNeedPwd(String zipFile,String dir,String pwd) throws IOException{
		net.lingala.zip4j.core.ZipFile zFile = null;  // 首先创建ZipFile指向磁盘上的.zip文件
		try {
			zFile = new net.lingala.zip4j.core.ZipFile(zipFile);
			zFile.setFileNameCharset("GBK");       // 设置文件名编码，在GBK系统中需要设置
			if (!zFile.isValidZipFile()) {   // 验证.zip文件是否合法，包括文件是否存在、是否为zip文件、是否被损坏等
				log.error("压缩文件不合法,可能被损坏:"+zipFile);
				return false ;
			}
			File destDir = new File(dir);     // 解压目录
			if (destDir.isDirectory() && !destDir.exists()) {
				destDir.mkdirs();
			}
			if (zFile.isEncrypted()) {
				zFile.setPassword(pwd.toCharArray());  // 设置密码
			}
			zFile.extractAll(dir);      // 将文件抽出到解压目录(解压)
			return true ;
		} catch (net.lingala.zip4j.exception.ZipException e) {
			e.printStackTrace();
			return false ;
		}

	}

	/**
	 * 递归获取文件夹及子文件夹下所有type文件
	 * @param path
	 * @param zipFileList
	 * @param type  如.txt  .zip
	 * @return
	 */
	public static List<String> getFileListByType(String path, List<String> zipFileList, String type) {
		if (zipFileList == null) {
			zipFileList = new ArrayList<String>();
		}
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
				for (File file2 : files) {
					if (file2.isDirectory()) {
						getFileListByType(file2.getAbsolutePath(), zipFileList,type);
					} else {
						if (file2.isFile() && file2.getName().endsWith(type)) {
							zipFileList.add(file2.getAbsolutePath());
						}
					}
			}
		}
		return zipFileList;
	}
    /**
     * @Package: com.hnzr.rz.ServiceImpl
     * @Class: ZipServiceImpl
     * @Author: 赵旭承
     * @date: 2018/1/31 14:34
     * @Description: 修改压缩包文件名
     * @Param: path:文件路径
     * @Param: type:修改后的后缀名如.zip
     * @ReturnType: boolean
     * @Exception
     **/
    public static boolean ChangZipName(String path,String type){
        String message = "";
        boolean flag = false;

        File oldFile = new File(path);
        if(!oldFile.exists()){
            message =  "文件不存在";
            return false;
        }
        File newFile = new File(path+ type);
        if (oldFile.renameTo(newFile)){
            message = "修改成功!";
            flag = true;
        }else{
            message = "修改失败";
            flag = false;
        }
        return flag;
    }
}
