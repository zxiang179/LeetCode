package zx.leetcode.Sep.mcm.dierwen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OptZ2F {
	
	//规划后24辆车从z到f
	static int[][] isZ2F = new int[24][36];
	//记录z2f
	static List<Z2F> list = new ArrayList<Z2F>();
	//将z1-z6出发的点保存在对应的数组中
	static List<Z2F> listZ1 = new ArrayList<Z2F>();
	static List<Z2F> listZ2 = new ArrayList<Z2F>();
	static List<Z2F> listZ3 = new ArrayList<Z2F>();
	static List<Z2F> listZ4 = new ArrayList<Z2F>();
	static List<Z2F> listZ5 = new ArrayList<Z2F>();
	static List<Z2F> listZ6 = new ArrayList<Z2F>();
	static List<Z2F> listZ7 = new ArrayList<Z2F>();
	static List<Z2F> listZ8 = new ArrayList<Z2F>();
	//zLeft list
	static List<ZLeft> zLeftList =  new ArrayList<ZLeft>();
	static List<ZLeft> z1LeftList = new ArrayList<ZLeft>();
	static List<ZLeft> z2LeftList = new ArrayList<ZLeft>();
	static List<ZLeft> z3LeftList = new ArrayList<ZLeft>();
	static List<ZLeft> z4LeftList = new ArrayList<ZLeft>();
	static List<ZLeft> z5LeftList = new ArrayList<ZLeft>();
	static List<ZLeft> z6LeftList = new ArrayList<ZLeft>();
	static List<ZLeft> z7LeftList = new ArrayList<ZLeft>();
	static List<ZLeft> z8LeftList = new ArrayList<ZLeft>();
	
	
	//index 和 F的对应关系
	//第一问选取的点的对应关系
//	static String[] i2FMap = {"F01","F02","F07","F08","F09","F10","F11","F12","F13","F14","F15","F16","F17","F18","F19","F20","F21","F22","F23","F27","F28","F32","F33","F36","F40","F48","F50","F51","F52","F53","F54","F55","F56","F57","F59","F60"};
	//验证第二问
	static String[] i2FMap1 = {"F05","F07","F08","F09","F010","F11","F12","F13","F14","F15","F16","F17","F18","F19","F20","F21","F22","F23","F26","F27","F28","F30","F31","F32","F33","F40","F48","F49","F51","F52","F53","F55","F56","F57","F59","F60"};
	static String[] i2FMap2= {"F05","F07","F08","F09","F010","F11","F12","F13","F14","F15","F16","F17","F18","F19","F20","F21","F22","F23","F26","F27","F28","F31","F32","F33","F36","F40","F48","F50","F51","F52","F53","F55","F56","F57","F59","F60"};
	static String[] i2FMap3= {"F04","F05","F07","F08","F09","F010","F11","F12","F13","F14","F15","F16","F17","F18","F20","F22","F23","F26","F31","F32","F33","F36","F37","F39","F40","F48","F50","F51","F52","F53","F54","F55","F56","F57","F59","F60"};
	static String[] i2FMap4 = {"F04","F05","F07","F08","F09","F010","F11","F12","F13","F14","F15","F16","F17","F18","F19","F20","F21","F22","F23","F27","F28","F31","F32","F33","F40","F48","F50","F51","F52","F53","F54","F55","F56","F57","F59","F60"};
	static String[] i2FMap5 = {"F05","F07","F08","F09","F010","F11","F12","F13","F14","F15","F16","F17","F18","F19","F20","F21","F22","F23","F26","F27","F28","F30","F31","F32","F33","F40","F48","F49","F51","F52","F53","F55","F56","F57","F59","F60"};
	static String[] i2FMap6 = {"F01","F07","F08","F09","F12","F13","F14","F15","F16","F17","F18","F19","F20","F21","F22","F23","F26","F27","F28","F31","F32","F33","F36","F37","F39","F40","F48","F49","F51","F52","F53","F55","F56","F57","F59","F60"};
	static String[] i2FMap7 = {"F01","F05","F07","F08","F09","F010","F11","F12","F13","F14","F15","F16","F17","F18","F19","F20","F21","F22","F23","F26","F27","F28","F29","F31","F32","F33","F40","F48","F51","F52","F53","F55","F56","F57","F59","F60"};
	static String[] i2FMap8 = {"F01","F02","F08","F09","F010","F12","F13","F14","F15","F16","F17","F18","F19","F20","F21","F22","F23","F26","F27","F28","F32","F33","F36","F37","F39","F40","F48","F50","F51","F52","F53","F55","F56","F57","F59","F60"};
	static String[] i2FMap9 = {"F01","F02","F07","F08","F09","F010","F11","F12","F13","F14","F15","F16","F17","F18","F19","F20","F21","F22","F23","F27","F28","F29","F32","F33","F36","F40","F48","F50","F51","F52","F53","F55","F56","F57","F59","F60"};
	static String[] i2FMap = {"F01","F02","F03","F08","F09","F010","F12","F13","F14","F15","F16","F17","F18","F19","F20","F21","F22","F23","F27","F28","F33","F36","F37","F39","F40","F48","F50","F51","F52","F53","F54","F55","F56","F57","F59","F60"};
	
	
	//存储z-f的路径
	static double[][] z2fMap = new double[24][36];
	
	public static void main(String[] args) {
		//得到上一步的可以离开时间
		getDLeftTime();
		//获取z到F的对应矩阵
		getZ2FDis();
		getZCarInput();
		//将24条路径按照出发点Z分类
		for(int i=0;i<list.size();i++){
			Z2F z2f = list.get(i);
			String z = z2f.getZ();
			switch(z){
				case "Z1":listZ1.add(z2f);break;
				case "Z2":listZ2.add(z2f);break;
				case "Z3":listZ3.add(z2f);break;
				case "Z4":listZ4.add(z2f);break;
				case "Z5":listZ5.add(z2f);break;
				case "Z6":listZ6.add(z2f);break;
				case "Z7":listZ7.add(z2f);break;
				case "Z8":listZ8.add(z2f);break;
			}
		}
		Comparator comp1 = new ComparatorI();
		Comparator comp2 = new ComparatorII();
		//listZi中的元素按照z到f的耗时进行排序
		//Z1
		Collections.sort(listZ1,comp1);
		List<Z2F> listZ1A = new ArrayList<Z2F>();
		List<Z2F> listZ1B = new ArrayList<Z2F>();
		List<Z2F> listZ1C = new ArrayList<Z2F>();
		for(int i=0;i<listZ1.size();i++){
			Z2F z2f = listZ1.get(i);
			String type = z2f.getType();
			switch(type){
				case "A":listZ1A.add(z2f);break;
				case "B":listZ1B.add(z2f);break;
				case "C":listZ1C.add(z2f);break;
			}
		}
		Collections.sort(listZ1A,comp1);
		Collections.sort(listZ1B,comp1);
		Collections.sort(listZ1C,comp1);
		
		//Z2
		Collections.sort(listZ2,comp1);
		List<Z2F> listZ2A = new ArrayList<Z2F>();
		List<Z2F> listZ2B = new ArrayList<Z2F>();
		List<Z2F> listZ2C = new ArrayList<Z2F>();
		for(int i=0;i<listZ2.size();i++){
			Z2F z2f = listZ2.get(i);
			String type = z2f.getType();
			switch(type){
				case "A":listZ2A.add(z2f);break;
				case "B":listZ2B.add(z2f);break;
				case "C":listZ2C.add(z2f);break;
			}
		}
		Collections.sort(listZ2A,comp1);
		Collections.sort(listZ2B,comp1);
		Collections.sort(listZ2C,comp1);
		
		//Z3
		Collections.sort(listZ3,comp1);
		List<Z2F> listZ3A = new ArrayList<Z2F>();
		List<Z2F> listZ3B = new ArrayList<Z2F>();
		List<Z2F> listZ3C = new ArrayList<Z2F>();
		for(int i=0;i<listZ3.size();i++){
			Z2F z2f = listZ3.get(i);
			String type = z2f.getType();
			switch(type){
				case "A":listZ3A.add(z2f);break;
				case "B":listZ3B.add(z2f);break;
				case "C":listZ3C.add(z2f);break;
			}
		}
		Collections.sort(listZ3A,comp1);
		Collections.sort(listZ3B,comp1);
		Collections.sort(listZ3C,comp1);
		
		//Z4
		Collections.sort(listZ4,comp1);
		List<Z2F> listZ4A = new ArrayList<Z2F>();
		List<Z2F> listZ4B = new ArrayList<Z2F>();
		List<Z2F> listZ4C = new ArrayList<Z2F>();
		for(int i=0;i<listZ4.size();i++){
			Z2F z2f = listZ4.get(i);
			String type = z2f.getType();
			switch(type){
				case "A":listZ4A.add(z2f);break;
				case "B":listZ4B.add(z2f);break;
				case "C":listZ4C.add(z2f);break;
			}
		}
		Collections.sort(listZ4A,comp1);
		Collections.sort(listZ4B,comp1);
		Collections.sort(listZ4C,comp1);
		
		//Z5
		Collections.sort(listZ5,comp1);
		List<Z2F> listZ5A = new ArrayList<Z2F>();
		List<Z2F> listZ5B = new ArrayList<Z2F>();
		List<Z2F> listZ5C = new ArrayList<Z2F>();
		for(int i=0;i<listZ5.size();i++){
			Z2F z2f = listZ5.get(i);
			String type = z2f.getType();
			switch(type){
				case "A":listZ5A.add(z2f);break;
				case "B":listZ5B.add(z2f);break;
				case "C":listZ5C.add(z2f);break;
			}
		}
		Collections.sort(listZ5A,comp1);
		Collections.sort(listZ5B,comp1);
		Collections.sort(listZ5C,comp1);
		
		
		//Z6
		Collections.sort(listZ6,comp1);
		List<Z2F> listZ6A = new ArrayList<Z2F>();
		List<Z2F> listZ6B = new ArrayList<Z2F>();
		List<Z2F> listZ6C = new ArrayList<Z2F>();
		for(int i=0;i<listZ6.size();i++){
			Z2F z2f = listZ6.get(i);
			String type = z2f.getType();
			switch(type){
				case "A":listZ6A.add(z2f);break;
				case "B":listZ6B.add(z2f);break;
				case "C":listZ6C.add(z2f);break;
			}
		}
		Collections.sort(listZ6A,comp1);
		Collections.sort(listZ6B,comp1);
		Collections.sort(listZ6C,comp1);
		
		
		//Z7
		Collections.sort(listZ7,comp1);
		List<Z2F> listZ7A = new ArrayList<Z2F>();
		List<Z2F> listZ7B = new ArrayList<Z2F>();
		List<Z2F> listZ7C = new ArrayList<Z2F>();
		for(int i=0;i<listZ7.size();i++){
			Z2F z2f = listZ7.get(i);
			String type = z2f.getType();
			switch(type){
				case "A":listZ7A.add(z2f);break;
				case "B":listZ7B.add(z2f);break;
				case "C":listZ7C.add(z2f);break;
			}
		}
		Collections.sort(listZ7A,comp1);
		Collections.sort(listZ7B,comp1);
		Collections.sort(listZ7C,comp1);
		
		
		//Z8
		Collections.sort(listZ8,comp1);
		List<Z2F> listZ8A = new ArrayList<Z2F>();
		List<Z2F> listZ8B = new ArrayList<Z2F>();
		List<Z2F> listZ8C = new ArrayList<Z2F>();
		for(int i=0;i<listZ8.size();i++){
			Z2F z2f = listZ8.get(i);
			String type = z2f.getType();
			switch(type){
				case "A":listZ8A.add(z2f);break;
				case "B":listZ8B.add(z2f);break;
				case "C":listZ8C.add(z2f);break;
			}
		}
		Collections.sort(listZ8A,comp1);
		Collections.sort(listZ8B,comp1);
		Collections.sort(listZ8C,comp1);
		
		
		//根据可以离开的时间进行递减排序
		Collections.sort(z1LeftList,comp2);
		Collections.sort(z2LeftList,comp2);
		Collections.sort(z3LeftList,comp2);
		Collections.sort(z4LeftList,comp2);
		Collections.sort(z5LeftList,comp2);
		Collections.sort(z6LeftList,comp2);
		Collections.sort(z7LeftList,comp2);
		Collections.sort(z8LeftList,comp2);
		
		Map<String,String> resMap = new HashMap<String,String>();
		int z1ACount = 0;
		int z1BCount = 0;
		int z1CCount =0;
		for(int i=0;i<z1LeftList.size();i++){
			ZLeft zLeft = z1LeftList.get(i);
			String type = zLeft.getType();
			String realType = type.substring(0, 1);
			Z2F z2f = new Z2F();
			switch(realType){
				case "A":z2f = listZ1A.get(z1ACount++);resMap.put(type, z2f.getF());break;
				case "B":z2f = listZ1B.get(z1BCount++);resMap.put(type, z2f.getF());break;
				case "C":z2f = listZ1C.get(z1CCount++);resMap.put(type, z2f.getF());break;
			}
		}
		
		int z2ACount = 0;
		int z2BCount = 0;
		int z2CCount =0;
		for(int i=0;i<z2LeftList.size();i++){
			ZLeft zLeft = z2LeftList.get(i);
			String type = zLeft.getType();
			String realType = type.substring(0, 1);
			Z2F z2f = new Z2F();
			switch(realType){
				case "A":z2f = listZ2A.get(z2ACount++);resMap.put(type, z2f.getF());break;
				case "B":z2f = listZ2B.get(z2BCount++);resMap.put(type, z2f.getF());break;
				case "C":z2f = listZ2C.get(z2CCount++);resMap.put(type, z2f.getF());break;
			}
			
		}
		
		//3
		int z3ACount = 0;
		int z3BCount = 0;
		int z3CCount =0;
		for(int i=0;i<z3LeftList.size();i++){
			ZLeft zLeft = z3LeftList.get(i);
			String type = zLeft.getType();
			String realType = type.substring(0, 1);
			Z2F z2f = new Z2F();
			switch(realType){
				case "A":z2f = listZ3A.get(z3ACount++);resMap.put(type, z2f.getF());break;
				case "B":z2f = listZ3B.get(z3BCount++);resMap.put(type, z2f.getF());break;
				case "C":z2f = listZ3C.get(z3CCount++);resMap.put(type, z2f.getF());break;
			}
			
		}
		//4
		int z4ACount = 0;
		int z4BCount = 0;
		int z4CCount =0;
		for(int i=0;i<z4LeftList.size();i++){
			ZLeft zLeft = z4LeftList.get(i);
			String type = zLeft.getType();
			String realType = type.substring(0, 1);
			Z2F z2f = new Z2F();
			switch(realType){
				case "A":z2f = listZ4A.get(z4ACount++);resMap.put(type, z2f.getF());break;
				case "B":z2f = listZ4B.get(z4BCount++);resMap.put(type, z2f.getF());break;
				case "C":z2f = listZ4C.get(z4CCount++);resMap.put(type, z2f.getF());break;
			}
			
		}
		//5
		int z5ACount = 0;
		int z5BCount = 0;
		int z5CCount =0;
		for(int i=0;i<z5LeftList.size();i++){
			ZLeft zLeft = z5LeftList.get(i);
			String type = zLeft.getType();
			String realType = type.substring(0, 1);
			Z2F z2f = new Z2F();
			switch(realType){
				case "A":z2f = listZ5A.get(z5ACount++);resMap.put(type, z2f.getF());break;
				case "B":z2f = listZ5B.get(z5BCount++);resMap.put(type, z2f.getF());break;
				case "C":z2f = listZ5C.get(z5CCount++);resMap.put(type, z2f.getF());break;
			}
			
		}
		//6
		int z6ACount = 0;
		int z6BCount = 0;
		int z6CCount =0;
		for(int i=0;i<z6LeftList.size();i++){
			ZLeft zLeft = z6LeftList.get(i);
			String type = zLeft.getType();
			String realType = type.substring(0, 1);
			Z2F z2f = new Z2F();
			switch(realType){
				case "A":z2f = listZ6A.get(z6ACount++);resMap.put(type, z2f.getF());break;
				case "B":z2f = listZ6B.get(z6BCount++);resMap.put(type, z2f.getF());break;
				case "C":z2f = listZ6C.get(z6CCount++);resMap.put(type, z2f.getF());break;
			}
			
		}
		
		//7
		int z7ACount = 0;
		int z7BCount = 0;
		int z7CCount =0;
		for(int i=0;i<z7LeftList.size();i++){
			ZLeft zLeft = z7LeftList.get(i);
			String type = zLeft.getType();
			String realType = type.substring(0, 1);
			Z2F z2f = new Z2F();
			switch(realType){
				case "A":z2f = listZ7A.get(z7ACount++);resMap.put(type, z2f.getF());break;
				case "B":z2f = listZ7B.get(z7BCount++);resMap.put(type, z2f.getF());break;
				case "C":z2f = listZ7C.get(z7CCount++);resMap.put(type, z2f.getF());break;
			}
			
		}
		
		//8
		int z8ACount = 0;
		int z8BCount = 0;
		int z8CCount =0;
		for(int i=0;i<z8LeftList.size();i++){
			ZLeft zLeft = z8LeftList.get(i);
			String type = zLeft.getType();
			String realType = type.substring(0, 1);
			Z2F z2f = new Z2F();
			switch(realType){
				case "A":z2f = listZ8A.get(z8ACount++);resMap.put(type, z2f.getF());break;
				case "B":z2f = listZ8B.get(z8BCount++);resMap.put(type, z2f.getF());break;
				case "C":z2f = listZ8C.get(z8CCount++);resMap.put(type, z2f.getF());break;
			}
			
		}
		
		double longestTime = 0;
		for(String s : resMap.keySet()){
			System.out.println("key="+s+"  value="+resMap.get(s));
		}
		System.out.println();
		
		for(int i=0;i<zLeftList.size();i++){
			ZLeft zLeft = zLeftList.get(i);
			double dis1 = zLeft.getCanLeftTime();
			double dis2 = 0;
			double dis = 0;
			String type = zLeft.getType();
			String FType = resMap.get(type);
			for(int j=0;j<list.size();j++){
				if(list.get(j).getF().equals(FType)){
					dis2 = list.get(j).getDis();
				}
			}
			dis = dis1+dis2;
			if(longestTime<dis&&dis<100){
				longestTime = dis;
			}
		}
		
		for(int i=0;i<zLeftList.size();i++){
			ZLeft zLeft = zLeftList.get(i);
			double shouldLeftTime = zLeft.getShouldLeftTime();
			if(shouldLeftTime==0){
				//求出耗时，离开时间等于最长时间-耗时
				double costTime = 0;
				String type = zLeft.getType();
				String F = resMap.get(type);
				for(int j=0;j<list.size();j++){
					Z2F z2f = list.get(j);
					if(z2f.getF().equals(F)){
						costTime = z2f.getDis();
					}
				}
				//应该离开的时间
				
				zLeft.setShouldLeftTime(Math.max(longestTime-costTime,zLeft.getLoadTime()+0.16666));
				
			}
		}
		//暴露时间=max(到达时间，允许时间)+耗时
		//总耗时 = 暴露时间求和
		double sumExpTime = 0;
		for(int i=0;i<zLeftList.size();i++){
			ZLeft zLeft = zLeftList.get(i);
			double expTime = 0;
			double preExp = Math.max(zLeft.getAllowTime(),zLeft.getArrTime());
			double afterExp = 0;
			String type = zLeft.getType();
			String F = resMap.get(type);
			for(int j=0;j<list.size();j++){
				Z2F z2f = list.get(j);
				if(z2f.getF().equals(F)){
					afterExp = z2f.getDis();
				}
			}
			expTime = preExp+afterExp;
			zLeft.setAllExpTime(expTime);
		}
		
		
		//输出对应的F所用的时间
		for(int i=0;i<zLeftList.size();i++){
			ZLeft zLeft = zLeftList.get(i);
			String type = zLeft.getType();
			String F = resMap.get(type);
			System.out.println(F+" 到达时间"+zLeft.getArrTime());
			System.out.println(F+" 允许时间"+zLeft.allowTime);
			System.out.println(F+" 装载时间"+zLeft.getLoadTime());
			System.out.println(F+" 应该离开的时间"+zLeft.getShouldLeftTime());
			//max(允许时间，到达时间)
			System.out.println(F+" 从F到Z的暴露时间"+Math.max(zLeft.getAllowTime(), zLeft.getArrTime()));
			double z2fExpTime = 0;
			for(int j=0;j<list.size();j++){
				Z2F z2f = list.get(j);
				if(z2f.getF().equals(F)){
					z2fExpTime = z2f.getDis();
				}
			}
			System.out.println(F+" 从Z到F的暴露时间"+z2fExpTime);
			System.out.println(F+" 所暴露的总时间"+zLeft.getAllExpTime());
			sumExpTime+=zLeft.getAllExpTime();
			System.out.println();
		}
		
		System.out.println("F-Z-F总耗时="+sumExpTime);
		
		
		System.out.println();
	}

	public static class ComparatorI implements Comparator<Z2F> {  
	    public int compare(Z2F s1,Z2F s2) {  
	    	double dis1 = s1.getDis();  
	    	double dis2 = s2.getDis();  
	        if(dis1>dis2){  
	            return 1;  
	        }else if(dis1<dis2){  
	            return -1;  
	        }else{  
	            return 0;  
	        }  
	    }  
	}
	
	public static class ComparatorII implements Comparator<ZLeft> {  
	    public int compare(ZLeft s1,ZLeft s2) {  
	    	double dis1 = s1.canLeftTime;  
	    	double dis2 = s2.canLeftTime;  
	        if(dis1<dis2){  
	            return 1;  
	        }else if(dis1>dis2){  
	            return -1;  
	        }else{  
	        	double loadTime1 = s1.getLoadTime();
	        	double loadTime2 = s2.getLoadTime();
	            if(loadTime1<loadTime2){
	            	return 1;
	            }else if(loadTime1>loadTime2){
	            	return -1;
	            }else{
	            	return 0;
	            }
	        }  
	    }  
	}
	
	public static void getDLeftTime(){
		//该文件通过GetQueueTime生成,保存在G:/MCM/getQueueTime/queue1.txt
//		File file = new File("G:/MCM/d-lefttime.txt");
		File file = new File("G:/MCM/getQueueTime/queue10.txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            int countZ = 1;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            	if(!s.trim().equals("")){
            		String[] split = s.split("\\s");
            		ZLeft zLeft = new ZLeft();
            		if(zLeft.getLoadTime()==0){
            			zLeft.setLoadTime(zLeft.getAllowTime()+0.16666);
            		}
            		switch(countZ){
	            		case 1:zLeft.setZ("Z1");zLeft.setType(split[0]);zLeft.setCanLeftTime(Double.valueOf(split[4]));zLeft.setLoadTime(Double.valueOf(split[3]));zLeft.setAllowTime(Double.valueOf(split[2]));zLeft.setArrTime(Double.valueOf(split[1]));z1LeftList.add(zLeft);break;
	            		case 2:zLeft.setZ("Z2");zLeft.setType(split[0]);zLeft.setCanLeftTime(Double.valueOf(split[4]));zLeft.setLoadTime(Double.valueOf(split[3]));zLeft.setAllowTime(Double.valueOf(split[2]));zLeft.setArrTime(Double.valueOf(split[1]));z2LeftList.add(zLeft);break;
	            		case 3:zLeft.setZ("Z3");zLeft.setType(split[0]);zLeft.setCanLeftTime(Double.valueOf(split[4]));zLeft.setLoadTime(Double.valueOf(split[3]));zLeft.setAllowTime(Double.valueOf(split[2]));zLeft.setArrTime(Double.valueOf(split[1]));z3LeftList.add(zLeft);break;
	            		case 4:zLeft.setZ("Z4");zLeft.setType(split[0]);zLeft.setCanLeftTime(Double.valueOf(split[4]));zLeft.setLoadTime(Double.valueOf(split[3]));zLeft.setAllowTime(Double.valueOf(split[2]));zLeft.setArrTime(Double.valueOf(split[1]));z4LeftList.add(zLeft);break;
	            		case 5:zLeft.setZ("Z5");zLeft.setType(split[0]);zLeft.setCanLeftTime(Double.valueOf(split[4]));zLeft.setLoadTime(Double.valueOf(split[3]));zLeft.setAllowTime(Double.valueOf(split[2]));zLeft.setArrTime(Double.valueOf(split[1]));z5LeftList.add(zLeft);break;
	            		case 6:zLeft.setZ("Z6");zLeft.setType(split[0]);zLeft.setCanLeftTime(Double.valueOf(split[4]));zLeft.setLoadTime(Double.valueOf(split[3]));zLeft.setAllowTime(Double.valueOf(split[2]));zLeft.setArrTime(Double.valueOf(split[1]));z6LeftList.add(zLeft);break;
	            		case 7:zLeft.setZ("Z7");zLeft.setType(split[0]);zLeft.setCanLeftTime(Double.valueOf(split[4]));zLeft.setLoadTime(Double.valueOf(split[3]));zLeft.setAllowTime(Double.valueOf(split[2]));zLeft.setArrTime(Double.valueOf(split[1]));z7LeftList.add(zLeft);break;
	            		case 8:zLeft.setZ("Z8");zLeft.setType(split[0]);zLeft.setCanLeftTime(Double.valueOf(split[4]));zLeft.setLoadTime(Double.valueOf(split[3]));zLeft.setAllowTime(Double.valueOf(split[2]));zLeft.setArrTime(Double.valueOf(split[1]));z8LeftList.add(zLeft);break;
            		}
            		zLeftList.add(zLeft);
            		if(zLeft.getCanLeftTime()!=100){
            			zLeft.setShouldLeftTime(zLeft.getCanLeftTime());
            		}
            	}else{
            		countZ++;
            	}
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	static class ZLeft{
		//总暴露时间
		double allExpTime;
		//允许时间
		double allowTime;
		//离开Z的标号，z1,z2,z3....
		String Z;
		//装载时间
		double loadTime;
		//准确的离开时间
		double shouldLeftTime;
		//能够离开的时间
		double canLeftTime;
		//到达第二波发射点的时间
		double arrTime;
		//设置车型
		String type;
		
		
		
		public double getAllExpTime() {
			return allExpTime;
		}
		public void setAllExpTime(double allExpTime) {
			this.allExpTime = allExpTime;
		}
		public double getAllowTime() {
			return allowTime;
		}
		public void setAllowTime(double allowTime) {
			this.allowTime = allowTime;
		}
		public double getLoadTime() {
			return loadTime;
		}
		public void setLoadTime(double loadTime) {
			this.loadTime = loadTime;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getZ() {
			return Z;
		}
		public void setZ(String z) {
			Z = z;
		}
		public double getShouldLeftTime() {
			return shouldLeftTime;
		}
		public void setShouldLeftTime(double shouldLeftTime) {
			this.shouldLeftTime = shouldLeftTime;
		}
		public double getCanLeftTime() {
			return canLeftTime;
		}
		public void setCanLeftTime(double canLeftTime) {
			this.canLeftTime = canLeftTime;
		}
		public double getArrTime() {
			return arrTime;
		}
		public void setArrTime(double arrTime) {
			this.arrTime = arrTime;
		}
		
	}
	
	
	public static void getZ2FDis(){
		//该文件等同于D_1，文件位于G:/MCM/getD/D_n_1.txt
//		File file = new File("G:/MCM/z-f-dis.txt");
		File file = new File("G:/MCM/getD/D_n_10.txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            int countRow = -1;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            	if(!s.trim().equals("")){
            		String[] split = s.split("\\s+");
            		switch(split[0]){
            		case "A1":countRow=0;break;
            		case "A2":countRow=1;break;
            		case "A3":countRow=2;break;
            		case "A4":countRow=3;break;
            		case "A5":countRow=4;break;
            		case "A6":countRow=5;break;
            		case "A7":countRow=6;break;
            		case "A8":countRow=7;break;
            		
            		case "B1":countRow=8;break;
            		case "B2":countRow=9;break;
            		case "B3":countRow=10;break;
            		case "B4":countRow=11;break;
            		case "B5":countRow=12;break;
            		case "B6":countRow=13;break;
            		case "B7":countRow=14;break;
            		case "B8":countRow=15;break;
            		
            		case "C1":countRow=16;break;
            		case "C2":countRow=17;break;
            		case "C3":countRow=18;break;
            		case "C4":countRow=19;break;
            		case "C5":countRow=20;break;
            		case "C6":countRow=21;break;
            		case "C7":countRow=22;break;
            		case "C8":countRow=23;break;
            		
            		}
            		for(int i=1;i<split.length;i++){
            			z2fMap[countRow][i-1]=Double.valueOf(split[i]);
            		}
            		
            	}
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	
	public static void getZCarInput(){
		//该文件等同于F_1,"G:/MCM/G:/getF/F_1.txt"
//		File file = new File("G:/MCM/z-F2.txt");
		File file = new File("G:/MCM/getF/F_10.txt");
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            int countRow = -1;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            	if(!s.trim().equals("")){
            		System.out.println(s);
                	String[] split = s.split("\\s+");
                	countRow++;
                	for(int i=0;i<split.length;i++){
                		isZ2F[countRow][i]=Integer.valueOf(split[i]);
                		if(isZ2F[countRow][i]==1){
                			Z2F z2f = new Z2F();
                			switch(countRow){
                			case 0:z2f.setZ("Z1");z2f.setF(i2FMap[i]);z2f.setType("A");z2f.setDis(z2fMap[countRow][i]);break;
                			case 1:z2f.setZ("Z2");z2f.setF(i2FMap[i]);z2f.setType("A");z2f.setDis(z2fMap[countRow][i]);break;
                			case 2:z2f.setZ("Z3");z2f.setF(i2FMap[i]);z2f.setType("A");z2f.setDis(z2fMap[countRow][i]);break;
                			case 3:z2f.setZ("Z4");z2f.setF(i2FMap[i]);z2f.setType("A");z2f.setDis(z2fMap[countRow][i]);break;
                			case 4:z2f.setZ("Z5");z2f.setF(i2FMap[i]);z2f.setType("A");z2f.setDis(z2fMap[countRow][i]);break;
                			case 5:z2f.setZ("Z6");z2f.setF(i2FMap[i]);z2f.setType("A");z2f.setDis(z2fMap[countRow][i]);break;
                			case 6:z2f.setZ("Z7");z2f.setF(i2FMap[i]);z2f.setType("A");z2f.setDis(z2fMap[countRow][i]);break;
                			case 7:z2f.setZ("Z8");z2f.setF(i2FMap[i]);z2f.setType("A");z2f.setDis(z2fMap[countRow][i]);break;
                			
                			
                			case 8:z2f.setZ("Z1");z2f.setF(i2FMap[i]);z2f.setType("B");z2f.setDis(z2fMap[countRow][i]);break;
                			case 9:z2f.setZ("Z2");z2f.setF(i2FMap[i]);z2f.setType("B");z2f.setDis(z2fMap[countRow][i]);break;
                			case 10:z2f.setZ("Z3");z2f.setF(i2FMap[i]);z2f.setType("B");z2f.setDis(z2fMap[countRow][i]);break;
                			case 11:z2f.setZ("Z4");z2f.setF(i2FMap[i]);z2f.setType("B");z2f.setDis(z2fMap[countRow][i]);break;
                			case 12:z2f.setZ("Z5");z2f.setF(i2FMap[i]);z2f.setType("B");z2f.setDis(z2fMap[countRow][i]);break;
                			case 13:z2f.setZ("Z6");z2f.setF(i2FMap[i]);z2f.setType("B");z2f.setDis(z2fMap[countRow][i]);break;
                			case 14:z2f.setZ("Z7");z2f.setF(i2FMap[i]);z2f.setType("B");z2f.setDis(z2fMap[countRow][i]);break;
                			case 15:z2f.setZ("Z8");z2f.setF(i2FMap[i]);z2f.setType("B");z2f.setDis(z2fMap[countRow][i]);break;
                			
                			case 16:z2f.setZ("Z1");z2f.setF(i2FMap[i]);z2f.setType("C");z2f.setDis(z2fMap[countRow][i]);break;
                			case 17:z2f.setZ("Z2");z2f.setF(i2FMap[i]);z2f.setType("C");z2f.setDis(z2fMap[countRow][i]);break;
                			case 18:z2f.setZ("Z3");z2f.setF(i2FMap[i]);z2f.setType("C");z2f.setDis(z2fMap[countRow][i]);break;
                			case 19:z2f.setZ("Z4");z2f.setF(i2FMap[i]);z2f.setType("C");z2f.setDis(z2fMap[countRow][i]);break;
                			case 20:z2f.setZ("Z5");z2f.setF(i2FMap[i]);z2f.setType("C");z2f.setDis(z2fMap[countRow][i]);break;
                			case 21:z2f.setZ("Z6");z2f.setF(i2FMap[i]);z2f.setType("C");z2f.setDis(z2fMap[countRow][i]);break;
                			case 22:z2f.setZ("Z7");z2f.setF(i2FMap[i]);z2f.setType("C");z2f.setDis(z2fMap[countRow][i]);break;
                			case 23:z2f.setZ("Z8");z2f.setF(i2FMap[i]);z2f.setType("C");z2f.setDis(z2fMap[countRow][i]);break;
                			}
                			list.add(z2f);
                		}
                	}	
            	}
            }
            System.out.println(result.toString());
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	static class Z2F{
		//离开的Z点
		String Z;
		//去的F点
		String F;
		//车的类型
		String type;
		//从z到f的距离
		double dis;
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getZ() {
			return Z;
		}
		public void setZ(String z) {
			Z = z;
		}
		public String getF() {
			return F;
		}
		public void setF(String f) {
			F = f;
		}
		public double getDis() {
			return dis;
		}
		public void setDis(double dis) {
			this.dis = dis;
		}
		public Z2F(String z, String f, String type, double dis) {
			super();
			Z = z;
			F = f;
			this.type = type;
			this.dis = dis;
		}
		public Z2F() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
	}
	
}

