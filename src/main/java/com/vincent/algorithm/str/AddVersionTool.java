package com.vincent.algorithm.str;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 添加版权信息
 * 使用场景：
 * 1.当使用重构工具修改了大量文件的时候，得手动一个一个文件打开，然后添加版权信息
 * 2.merge操作时候merge了没有加版本号的文件，的手动一个一个文件打开添加版权信息
 * <p>
 * 使用方法：
 * 1.配置需要扫描的目录
 * 2.配置需要加版本号的文件名（可以通过git localChange窗口，commit变动窗口来copy出来）
 */
public class AddVersionTool {
    /**
     * 存放项目目录，扫描这个目录下的.java文件来添加版本号
     */
    private final static String SCAN_PATH = "D:\\workspace\\git\\genesis-product\\zatech-market\\scenario\\zatech-shelf-config-scenario-share";

    /**
     * 去重的时候 适用
     */
    private final static String COPY_KEY = "3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617";
    /**
     * 版权信息
     */
    private final static String content = "/*\n" +
            " * Copyright By ZATI\n" +
            " * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617\n" +
            " * All rights reserved.\n" +
            " *\n" +
            " * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or\n" +
            " * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.\n" +
            " */\n\n";

    /**
     * 把改变的文件名存储到记事本中：可以通过idea的git的localChange面板拷贝出来
     */
        private final static String changeFileNamesPath = "C:\\Users\\za-wangcheng\\Desktop\\版本添加测试\\changeFileName.txt";
    private final static boolean enableChangeFile = false;

    public static void main(String[] args) throws Exception {
        List<String> fileNames = new ArrayList<>();
        search(SCAN_PATH, fileNames);

        if (enableChangeFile) {
            List<String> changeFileName = Arrays.asList(readFor(changeFileNamesPath, Integer.MAX_VALUE, ",").split(","));
            fileNames = fileNames.stream()
                    .filter(o -> changeFileName.contains(o.substring(o.lastIndexOf("\\") + 1)))
                    .collect(Collectors.toList());
        }

        for (String fileName : fileNames) {
            addContainsToFile(fileName, content);
        }
    }


    public static List<String> search(String path, List<String> fileNames) {
        File dir = new File(path);
        File[] subFiles = dir.listFiles();

        if (null != subFiles) {
            for (File subFile : subFiles) {
                //文件夹则递归寻找，后缀为java文件则输出名字
                if (subFile.isDirectory())
                    search(subFile.getAbsolutePath(), fileNames);
                else if (subFile.isFile() && subFile.getName().endsWith(".java"))
                    fileNames.add(subFile.getAbsoluteFile().getAbsolutePath());
            }
        }
        return fileNames;
    }


    public static boolean addContainsToFile(String filePath, String content) throws IOException {
        // 如果已经加过，就不加了
        //if (content.equals(readFor(filePath, 8, "\n"))) return false;
        if (readFor(filePath, 8, "\n").contains(COPY_KEY)) return false;

        addContainsToFile(filePath, 0, content);
        return true;
    }

    public static String readFor(String path, int rows, String split) {
        StringBuffer res = new StringBuffer();
        String line = null;
        int sum = 0;
        int y = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            while ((line = reader.readLine()) != null) {
                if (sum == rows) {
                    break;
                }
                res.append(line);
                res.append(split);
                sum += 1;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res.toString();
    }

    public static void addContainsToFile(String filePath, int position, String contents) throws IOException {
        //1、参数校验
        File file = new File(filePath);
        System.out.println(file);
        //判断文件是否存在
        if (!(file.exists() && file.isFile())) {
            System.out.println("文件不存在  ~ ");
            return;
        }
        //判断position是否合法
        if ((position < 0) || (position > file.length())) {
            System.out.println("position不合法 ~ ");
            return;
        }

        //2、创建临时文件
        File tempFile = File.createTempFile("sss", ".temp", new File("d:/"));
        //File tempFile = new File("d:/wwwww.txt");
        //3、用文件输入流、文件输出流对文件进行操作
        FileOutputStream outputStream = new FileOutputStream(tempFile);
        FileInputStream inputStream = new FileInputStream(tempFile);
        //在退出JVM退出时自动删除
        tempFile.deleteOnExit();

        //4、创建RandomAccessFile流
        RandomAccessFile rw = new RandomAccessFile(file, "rw");
        //文件指定位置到 position
        rw.seek(position);

        int tmp;
        //5、将position位置后的内容写入临时文件
        while ((tmp = rw.read()) != -1) {
            outputStream.write(tmp);
        }
        //6、将追加内容 contents 写入 position 位置
        rw.seek(position);
        rw.write(contents.getBytes());

        //7、将临时文件写回文件，并将创建的流关闭
        while ((tmp = inputStream.read()) != -1) {
            rw.write(tmp);
        }
        rw.close();
        outputStream.close();
        inputStream.close();
    }
}
