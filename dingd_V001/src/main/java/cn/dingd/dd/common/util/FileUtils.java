package cn.dingd.dd.common.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import sun.misc.BASE64Encoder;

public class FileUtils {

    /**
     * 文件转字节
     *
     * @param filePath  文件全路径
     * @return  byte[]
     */
    public static byte[] File2byte(String filePath) {
        byte[] buffer = null;
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;
        try {
            File file = new File(filePath);
            if(file == null || !file.exists())
                return null;
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024 * 1];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            buffer = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis != null)
                    fis.close();
                if(bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer;
    }

    /**
     * 字节写文件
     *
     * @param buf   字节
     * @param fileDir   目的文件目录
     * @param fileName  目的文件名
     * @return  目的文件
     * @throws Exception 
     */
    public static File byte2File(byte[] buf, String fileDir, String fileName) throws Exception {
        File file = null;
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try {
            File dir = new File(fileDir);
            if (!dir.exists() && !dir.isDirectory()) {
                dir.mkdirs();
            }
            file = new File(fileDir + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
            bos.flush();
            file.setReadable(true, false);
         //   to_50x50(fileDir+fileName);
          //  oldFile.delete();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            try {
                if(bos != null)
                    bos.close();
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
	 * 2016/5/17
	 * 将图片转化为base64
	 * 
	 * @author Licy
	 * @param  img
	 * @return
	 * 
	 */
	public static String GetImageStr(String url) {
		//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
		InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(url);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }

	public static void to_50x50(String path) throws Exception {
		try {
			File file = new File(path);
			Image image = ImageIO.read(file); //得到图片位置
			String lastTag = path.substring(path.lastIndexOf("."), path.length());
			String newPath = path.substring(0, path.lastIndexOf("."));
			int wideth = 50;
			int height = 50;
			BufferedImage tag = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_BGR);
			tag.getGraphics().drawImage(image, 0, 0, wideth, height, null);//设置图片文件宽高，然后需要输入流并指定路径，然后设置编码集将流配置到编码集中去
			FileOutputStream outputStream = new FileOutputStream(newPath + "_50x50" + lastTag);
			ImageIO.write(tag, "jpg", outputStream);
			File f = new File(newPath + "_50x50" + lastTag);
			f.setReadable(true, false);
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			 throw new Exception(e.getMessage());
		}
	}
}
