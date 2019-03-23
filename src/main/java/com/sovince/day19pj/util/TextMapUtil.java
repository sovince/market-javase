package com.sovince.day19pj.util;

import com.sovince.day19pj.mapper.ObjectMapper;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 13:32
 * Description:
 * 文本数据和Map数据的转换类
 */
public class TextMapUtil<T> {
    private static final String dataDir = "./src/main/java/com/sovince/day19pj/data/";
    private String fileName;
    private File file;
    private Map<Integer,T> map;


    public TextMapUtil(String fileName) {
        this.fileName = fileName;
        this.file = new File(dataDir+fileName);
        this.map = new HashMap<>();
    }

    /**
     * 读取全部数据
     * @param objectMapper
     * @throws IOException
     */
    public Map<Integer,T> readFile(ObjectMapper<T> objectMapper) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String br;
        bufferedReader.readLine();//舍弃第一行
        while ((br = bufferedReader.readLine()) != null) {
            String[] values = br.split(",");
            T t = objectMapper.doMap(values);//
            map.put(Integer.valueOf(values[0]),t);
        }
        bufferedReader.close();
        return map;
    }


    /**
     * 写入数据
     * @param objectMapper
     * @param map
     * @throws IOException
     */
    public void writeFileFromMap(ObjectMapper<T> objectMapper,Map<Integer,T> map) throws IOException {
        String firstRow = getFirstRow();//先把文件原本的第一行拿到
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstRow);
//        System.out.println(firstRow);
        stringBuilder.append(System.getProperty("line.separator"));
        for (T t:map.values()){
            String row = objectMapper.unMap(t);
            stringBuilder.append(row);
            stringBuilder.append(System.getProperty("line.separator"));
        }
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /**
     * 获取文件第一行
     * @return
     * @throws IOException
     */
    private String getFirstRow() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String firstRow = bufferedReader.readLine();//第一行不能丢
        bufferedReader.close();
        return firstRow;
    }

    public String getDataDir() {
        return dataDir;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Map<Integer, T> getMap() {
        return map;
    }

    public void setMap(Map<Integer, T> map) {
        this.map = map;
    }
}
