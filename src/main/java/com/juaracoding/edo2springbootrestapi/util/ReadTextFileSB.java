package com.juaracoding.edo2springbootrestapi.util;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;


public class ReadTextFileSB {
    private FileInputStream fInput;
    private BufferedInputStream bInput;
    private String[] exceptionString = new String[2];
    private String contentFile;
    private byte[] contentOfFile;

    public ReadTextFileSB(String pathFiles) throws Exception {
        setContentFile(pathFiles);
    }

    public void setContentFile(String pathFile) throws Exception {

        try {
            File filez = ResourceUtils.getFile("D:\\springboot\\edo2springbootapi\\src\\main\\resources"+pathFile);
            fInput = new FileInputStream(filez);
            bInput = new BufferedInputStream(fInput);
            byte[] bdata = FileCopyUtils.copyToByteArray(bInput);
            String data = new String(bdata, StandardCharsets.UTF_8);
            this.contentOfFile = bdata;
            this.contentFile = new String(contentOfFile, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        finally {
            try {
                fInput.close();
                bInput.close();
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
    }

    public String getContentFile()
    {
        return contentFile;
    }

    public byte[] getByteOfFile()
    {
        return contentOfFile;
    }

    public static void main(String[] args) throws Exception {
        ReadTextFileSB rtfSB = new ReadTextFileSB("\\data\\MailHTMLExample.txt");
        System.out.println("STRING => "+rtfSB.getContentFile());
        System.out.println("BYTE FILE => "+rtfSB.getByteOfFile());
    }
}