package com.zhiyun.util;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 读取压缩文件内容
 *
 * @auther xufei
 */
public class ReadZipFile {
    private static final Logger logger = Logger.getLogger(ReadZipFile.class);

    public static void readZipFile(String file) throws Exception {
        InputStream in = new BufferedInputStream(new FileInputStream(file));

        Charset gbk = Charset.forName("gbk");
        ZipInputStream zin = new ZipInputStream(in, gbk);
        ZipEntry ze;
        int i = 0;
        while ((ze = zin.getNextEntry()) != null) {
            if (ze.isDirectory()) {
            } else {
                long size = ze.getSize();
                if (size > 0) {
                    if (ze.getName().endsWith(".jsp")) {
                        i = i + 1;
                    }
                    if (ze.getName().endsWith(".html")) {
                        i = i + 1;
                    }
                }
            }
        }
        zin.closeEntry();
        in.close();
        System.out.println("i=" + i);
        if (i != 2) {
            logger.debug("文件格式不正确！");
        }
    }
}