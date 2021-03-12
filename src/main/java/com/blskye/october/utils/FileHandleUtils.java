package com.blskye.october.utils;

import java.io.*;

/**
 * @author wanghaotian
 * @version 1.0
 * @date 2021/3/12 11:31 下午
 */
public class FileHandleUtils {

    public static boolean write(String pathname,String content){
        try {
            File file = new File(pathname);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write(content);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static String read(String pathname){
        try {
            File file = new File(pathname);
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            String s;
            int i = 0;
            // 先判断要读的文件的文本行数不为null，才进入循环
            StringBuilder stringBuilder=new StringBuilder();
            while ((s = bufr.readLine()) != null) {
                i++;
                stringBuilder.append(s).append("\n");
            }
            fr.close();
            bufr.close();
            return stringBuilder.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FileHandleUtils.write("./b.md","# ABC");
        String str = FileHandleUtils.read("./b.md");
        System.out.println(str);
    }
}
