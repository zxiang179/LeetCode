package zx.leetcode.chicken.Sep.mcm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ReadTxt1 {

	public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
    	
        File file = new File("G:/MCM/z-f.txt");
        StringBuilder result = new StringBuilder();
        double[] resDou = new double[360];
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            int countLine = 0;
            int count = 0;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
                countLine++;
                if(s.trim()!=null||!"".equals(s.trim())){
                	String[] split = s.split("\\s");
                	for(int i=0;i<split.length;i++){
                		resDou[i]=Double.valueOf(split[i]);
                	}
                }
                
            }
            System.out.println(result.toString());
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
