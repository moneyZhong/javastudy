package com.study.javastudy.simpletool;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 修改文件中的内容
 */
public class ChangeFileContext {


    private static List<String> changePaths;
    static{
        changePaths = new ArrayList();
        String fileRoot = "D:\\niuwa\\risk-control-parent";
        File file = new File(fileRoot);
        File[] files = file.listFiles();
        Arrays.stream(files).forEach((fileE)->{if(fileE.isDirectory()){
            if(fileE.isDirectory() && !fileE.getName().equals("build_conf")  && !fileE.getName().equals(".idea")){
                System.out.println(fileE.getAbsolutePath());
                changePaths.add(fileE.getAbsolutePath());
            }
        }});


        System.out.println("目录加载完成");
    }

    public static void main(String[] args) {
//        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                4,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        Semaphore semaphore = new Semaphore(4);
        changePaths.stream().forEach((path)->{
//            executorService.execute(
//                () -> {
//
//                });
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+":-->"+path);
                    changeTxt(path);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        });

        executorService.shutdown();

    }

    private static void changeTxt(String filePath) throws Exception{
        File file  = new File(filePath);

        List<File> allFile = new ArrayList<>();

        readFile(file,allFile);
        for(File isFile : allFile){
            System.out.println(isFile.getAbsolutePath());
            createNewFile(isFile);
        }
    }
    private static int readIsContains(File file , String text) throws Exception{
        BufferedReader bufferReader = new BufferedReader(new FileReader(file));
        String line = "";
        int count = 0;
        while((line = bufferReader.readLine()) != null){
            if(line.contains(text)){
                count++;
            }
        }
        bufferReader.close();
        return count;
    }

    private static boolean isRemove(String line){
        String[] removeLine = {"@author","@version","Copyright","Created by","create on","the email is","@created"};
        for(String s : removeLine){
            if(line.contains(s)){
                return true;
            }
        }
        return false;
    }

    private static void createNewFile(File file) throws Exception{
        BufferedReader bufferReader = new BufferedReader(new FileReader(file));
        File tempFile = createTmpFile(file);
        String originFilePath = file.getAbsolutePath();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile,true));
        String line ;
        while((line = bufferReader.readLine()) != null){
            if(!isRemove(line)){
                if(line.contains("com.niuwa.p2p"))
                    line = line.replace("com.niuwa.p2p","com.risk.frame");
                if(line.contains("com.niuwa.risk"))
                    line = line.replace("com.niuwa.risk","com.risk");
                if(line.contains("by tennyqin"))
                    line = line.replace("by tennyqin","");
                bufferedWriter.write(line+"\r\n");
            }

        }

        bufferReader.close();
        bufferedWriter.close();
        file.delete();
        tempFile.renameTo(new File(originFilePath));
    }

    public static File createTmpFile(File file) throws Exception{
        File filetmp = new File(file.getAbsolutePath()+".copy");
        if(!filetmp.exists()){
            filetmp.createNewFile();
        }
        return filetmp;
    }



    private static void readFile(File file,List<File> allFile){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File fileSi : files){
                if(fileSi.getName().equals("target")){
                    continue;
                }
                readFile(fileSi,allFile);
            }
        }else{
            if(file.getAbsolutePath().endsWith(".java") || file.getAbsolutePath().endsWith(".xml")){
                allFile.add(file);
            }
        }
    }
}
