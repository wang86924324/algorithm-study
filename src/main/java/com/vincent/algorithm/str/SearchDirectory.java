package com.vincent.algorithm.str;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 只打包share包
 * Goals and options：Global option：全量打包 clean deploy -B -U -Dmaven.test.skip=true
 * 打前类生成部分打包的命令
 */
public class SearchDirectory {
    private final static String PATH = "D:\\workspace\\git\\genesis-fusion\\";
    private final static String SUFFIX = "-share";

    public static void main(String[] args) throws Exception {
        List<String> projects = new ArrayList<>();
        searchDirctoryName(projects,PATH, SUFFIX);
        String projectStr = String.join(",", projects);
        System.out.println("projectStr:" + projectStr);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mvn -B -f pom.xml --projects ");
        stringBuilder.append(projectStr);
        stringBuilder.append(" -am clean deploy -Dmaven.test.skip=true");

        System.out.println(stringBuilder.toString());


    }

    public static List<String> searchDirctoryName(List<String> directoryNames, String path, String suffix) {

        File dir = new File(path);
        File[] subFiles = dir.listFiles();
        String tempProject = "";

        if (null != subFiles) {
            for (File subFile : subFiles) {
                //文件夹则递归寻找
                if (subFile.isDirectory()) {
                    if (subFile.getAbsolutePath().endsWith(suffix)) {
                        tempProject = subFile.getAbsolutePath().replace(PATH, "").replace("\\","/");
                        directoryNames.add(tempProject);
                        System.out.println(tempProject);
                    } else {
                        searchDirctoryName(directoryNames,subFile.getAbsolutePath(), suffix);
                    }
                }
            }
        }
        return directoryNames;
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


}
