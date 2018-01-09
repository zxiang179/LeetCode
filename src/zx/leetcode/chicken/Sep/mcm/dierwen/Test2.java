package zx.leetcode.chicken.Sep.mcm.dierwen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
	
//	$F_{28}$ & 107.9    & $F_{28}$ & 121.3 & $F_{36}$ & 153.2 & $F_{33}$ & 115.5    & $F_{33}$ & 95.8     & $F_{36}$ & 81.0  \\ \hline
//	$F_{54}$ & 147.8    & $F_{51}$ & 157.9 & $F_{28}$ & 177.2 & $F_{36}$ & 145.0    & $F_{36}$ & 125.3    & $F_{28}$ & 93.3  \\ \hline
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//        File file = new File("G:/MCM/z-f.txt");
        File file = new File("G:/MCM/change.txt");

        StringBuilder result = new StringBuilder();
        List<String> strList = new ArrayList<String>();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                if(s.trim()!=null||!"".equals(s.trim())){
                	String[] split = s.split("\\s+");
                	for(int i=0;i<split.length;i++){
                		s = split[i];
                		if(s.startsWith("F")){
                			String digStr = s.substring(1);
                			s = "$F_{"+digStr+"}$";
                			System.out.print(s+" ");
                		}else{
                			System.out.print(s+" ");
                		}
                	}
                	strList.add(s);
                	
                }
                System.out.println();
            }
            System.out.println();
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
	}

}
