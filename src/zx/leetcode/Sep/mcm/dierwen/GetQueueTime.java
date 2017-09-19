package zx.leetcode.Sep.mcm.dierwen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetQueueTime {
	
	public static List<Z2F> arr1 = new ArrayList<Z2F>();
	public static List<Z2F> arr2 = new ArrayList<Z2F>();
	public static List<Z2F> arr3 = new ArrayList<Z2F>();
	public static List<Z2F> arr4 = new ArrayList<Z2F>();
	public static List<Z2F> arr5 = new ArrayList<Z2F>();
	public static List<Z2F> arr6 = new ArrayList<Z2F>();
	public static List<Z2F> arr7 = new ArrayList<Z2F>();
	public static List<Z2F> arr8 = new ArrayList<Z2F>();
	
	public static void main(String[] args) {
		double[][] z2f = new double[18][60];
		//各个z的聚类结果
		getZCarInput();		
		//根据各个发射点到Zi的距离进行排序
		Comparator comp = new ComparatorImpl();  
		Collections.sort(arr1,comp);
		Collections.sort(arr2,comp);
		Collections.sort(arr3,comp);
		Collections.sort(arr4,comp);
		Collections.sort(arr5,comp);
		Collections.sort(arr6,comp);
		Collections.sort(arr7,comp);
		Collections.sort(arr8,comp);
		//调度 到达时间初始化
		
		//第一列为到达时间 第二列为允许时间 第三列为装载时间 第四列为离开时间
		double[][] diaodu1 = new double[arr1.size()][4];
		double[][] diaodu2 = new double[arr2.size()][4];
		double[][] diaodu3 = new double[arr3.size()][4];
		double[][] diaodu4 = new double[arr4.size()][4];
		double[][] diaodu5 = new double[arr5.size()][4];
		double[][] diaodu6 = new double[arr6.size()][4];
		double[][] diaodu7 = new double[arr7.size()][4];
		double[][] diaodu8 = new double[arr8.size()][4];
		for(int i=0;i<arr1.size();i++){
			diaodu1[i][0] = arr1.get(i).getDis();
		}
		for(int i=0;i<arr2.size();i++){
			diaodu2[i][0] = arr2.get(i).getDis();
		}
		for(int i=0;i<arr3.size();i++){
			diaodu3[i][0] = arr3.get(i).getDis();
		}
		for(int i=0;i<arr4.size();i++){
			diaodu4[i][0] = arr4.get(i).getDis();
		}
		for(int i=0;i<arr5.size();i++){
			diaodu5[i][0] = arr5.get(i).getDis();
		}
		for(int i=0;i<arr6.size();i++){
			diaodu6[i][0] = arr6.get(i).getDis();
		}
		for(int i=0;i<arr7.size();i++){
			diaodu7[i][0] = arr7.get(i).getDis();
		}
		for(int i=0;i<arr8.size();i++){
			diaodu8[i][0] = arr8.get(i).getDis();
		}
		
		//arr1
		//第一列为到达时间 第二列为允许时间 第三列为装载时间 第四列为离开时间
		for(int i=0;i<arr1.size();i++){
			if(i==0){
				//第一个到达的装载时间和允许时间相同
				diaodu1[i][1] =diaodu1[i][0];
				diaodu1[i][2] =diaodu1[i][0];
				if(arr1.size()<=2){
					diaodu1[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu1[i][3] = diaodu1[i][2]+0.166666; 
				}
			}else if(i==1){
				//第二个到达 允许时间为到达时间
				diaodu1[i][1] = diaodu1[i][0];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu1[i][2] = Math.max(diaodu1[i-1][3],diaodu1[i][1]);
				diaodu1[i][2] = Math.max(diaodu1[i][2],diaodu1[i][0]);
				if(diaodu1[i][2]==100){
					diaodu1[i][2] = diaodu1[i-1][2] + 0.166666*2; 
					diaodu1[i][2] = Math.max(diaodu1[i][2], diaodu1[i][0]);
				}
				if(arr1.size()<=2){
					diaodu1[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu1[i][3] = diaodu1[i][2]+0.166666; 
				}
			}else{
				//允许时间为上上辆车的离开时间
				diaodu1[i][1] = diaodu1[i-2][3];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu1[i][2] = Math.max(diaodu1[i-1][3],diaodu1[i][1]);
				diaodu1[i][2] = Math.max(diaodu1[i][2],diaodu1[i][0]);
				if(diaodu1[i][2]==100){
					diaodu1[i][2] = diaodu1[i-1][2] + 0.166666*2; 
					diaodu1[i][2] = Math.max(diaodu1[i][2], diaodu1[i][0]);
				}
				//
				if(arr1.size()-i<=2){
					diaodu1[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu1[i][3] = diaodu1[i][2]+0.166666; 
				}
			}
		}
		
		//2
		for(int i=0;i<arr2.size();i++){
			if(i==0){
				//第一个到达的装载时间和允许时间相同
				diaodu2[i][1] =diaodu2[i][0];
				diaodu2[i][2] =diaodu2[i][0];
				if(arr2.size()<=2){
					diaodu2[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu2[i][3] = diaodu2[i][2]+0.166666; 
				}
			}else if(i==1){
				//第二个到达 允许时间为到达时间
				diaodu2[i][1] = diaodu2[i][0];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu2[i][2] = Math.max(diaodu2[i-1][3],diaodu2[i][1]);
				diaodu2[i][2] = Math.max(diaodu2[i][2],diaodu2[i][0]);
				if(diaodu2[i][2]==100){
					diaodu2[i][2] = diaodu2[i-1][2] + 0.166666*2; 
					diaodu2[i][2] = Math.max(diaodu2[i][2], diaodu2[i][0]);
				}
				if(arr2.size()<=2){
					diaodu2[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu2[i][3] = diaodu2[i][2]+0.166666; 
				}
			}else{
				//允许时间为上上辆车的离开时间
				diaodu2[i][1] = diaodu2[i-2][3];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu2[i][2] = Math.max(diaodu2[i-1][3],diaodu2[i][1]);
				diaodu2[i][2] = Math.max(diaodu2[i][2],diaodu2[i][0]);
				if(diaodu2[i][2]==100){
					diaodu2[i][2] = diaodu2[i-1][2] + 0.166666*2; 
					diaodu2[i][2] = Math.max(diaodu2[i][2], diaodu2[i][0]);
				}
				//
				if(arr2.size()-i<=2){
					diaodu2[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu2[i][3] = diaodu2[i][2]+0.166666; 
				}
			}
		}
		
		
		//3
		for(int i=0;i<arr3.size();i++){
			if(i==0){
				//第一个到达的装载时间和允许时间相同
				diaodu3[i][1] =diaodu3[i][0];
				diaodu3[i][2] =diaodu3[i][0];
				if(arr3.size()<=2){
					diaodu3[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu3[i][3] = diaodu3[i][2]+0.166666; 
				}
			}else if(i==1){
				//第二个到达 允许时间为到达时间
				diaodu3[i][1] = diaodu3[i][0];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu3[i][2] = Math.max(diaodu3[i-1][3],diaodu3[i][1]);
				diaodu3[i][2] = Math.max(diaodu3[i][2],diaodu3[i][0]);
				if(diaodu3[i][2]==100){
					diaodu3[i][2] = diaodu3[i-1][2] + 0.166666*2; 
					diaodu3[i][2] = Math.max(diaodu3[i][2], diaodu3[i][0]);
				}
				if(arr3.size()<=2){
					diaodu3[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu3[i][3] = diaodu3[i][2]+0.166666; 
				}
			}else{
				//允许时间为上上辆车的离开时间
				diaodu3[i][1] = diaodu3[i-2][3];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu3[i][2] = Math.max(diaodu3[i-1][3],diaodu3[i][1]);
				diaodu3[i][2] = Math.max(diaodu3[i][2],diaodu3[i][0]);
				if(diaodu3[i][2]==100){
					diaodu3[i][2] = diaodu3[i-1][2] + 0.166666*2; 
					diaodu3[i][2] = Math.max(diaodu3[i][2], diaodu3[i][0]);
				}
				//
				if(arr3.size()-i<=2){
					diaodu3[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu3[i][3] = diaodu3[i][2]+0.166666; 
				}
			}
		}		
		
		
		//4
		for(int i=0;i<arr4.size();i++){
			if(i==0){
				//第一个到达的装载时间和允许时间相同
				diaodu4[i][1] =diaodu4[i][0];
				diaodu4[i][2] =diaodu4[i][0];
				if(arr4.size()<=2){
					diaodu4[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu4[i][3] = diaodu4[i][2]+0.166666; 
				}
			}else if(i==1){
				//第二个到达 允许时间为到达时间
				diaodu4[i][1] = diaodu4[i][0];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu4[i][2] = Math.max(diaodu4[i-1][3],diaodu4[i][1]);
				diaodu4[i][2] = Math.max(diaodu4[i][2],diaodu4[i][0]);
				if(diaodu4[i][2]==100){
					diaodu4[i][2] = diaodu4[i-1][2] + 0.166666*2; 
					diaodu4[i][2] = Math.max(diaodu4[i][2], diaodu4[i][0]);
				}
				if(arr4.size()<=2){
					diaodu4[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu4[i][3] = diaodu4[i][2]+0.166666; 
				}
			}else{
				//允许时间为上上辆车的离开时间
				diaodu4[i][1] = diaodu4[i-2][3];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu4[i][2] = Math.max(diaodu4[i-1][3],diaodu4[i][1]);
				diaodu4[i][2] = Math.max(diaodu4[i][2],diaodu4[i][0]);
				if(diaodu4[i][2]==100){
					diaodu4[i][2] = diaodu4[i-1][2] + 0.166666*2; 
					diaodu4[i][2] = Math.max(diaodu4[i][2], diaodu4[i][0]);
				}
				//
				if(arr4.size()-i<=2){
					diaodu4[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu4[i][3] = diaodu4[i][2]+0.166666; 
				}
			}
		}	
		
		//5
		for(int i=0;i<arr5.size();i++){
			if(i==0){
				//第一个到达的装载时间和允许时间相同
				diaodu5[i][1] =diaodu5[i][0];
				diaodu5[i][2] =diaodu5[i][0];
				if(arr5.size()<=2){
					diaodu5[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu5[i][3] = diaodu5[i][2]+0.166666; 
				}
			}else if(i==1){
				//第二个到达 允许时间为到达时间
				diaodu5[i][1] = diaodu5[i][0];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu5[i][2] = Math.max(diaodu5[i-1][3],diaodu5[i][1]);
				diaodu5[i][2] = Math.max(diaodu5[i][2],diaodu5[i][0]);
				if(diaodu5[i][2]==100){
					diaodu5[i][2] = diaodu5[i-1][2] + 0.166666*2; 
					diaodu5[i][2] = Math.max(diaodu5[i][2], diaodu5[i][0]);
				}
				if(arr5.size()<=2){
					diaodu5[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu5[i][3] = diaodu5[i][2]+0.166666; 
				}
			}else{
				//允许时间为上上辆车的离开时间
				diaodu5[i][1] = diaodu5[i-2][3];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu5[i][2] = Math.max(diaodu5[i-1][3],diaodu5[i][1]);
				diaodu5[i][2] = Math.max(diaodu5[i][2],diaodu5[i][0]);
				if(diaodu5[i][2]==100){
					diaodu5[i][2] = diaodu5[i-1][2] + 0.166666*2; 
					diaodu5[i][2] = Math.max(diaodu5[i][2], diaodu5[i][0]);
				}
				//
				if(arr5.size()-i<=2){
					diaodu5[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu5[i][3] = diaodu5[i][2]+0.166666; 
				}
			}
		}
		
		//6
		for(int i=0;i<arr6.size();i++){
			if(i==0){
				//第一个到达的装载时间和允许时间相同
				diaodu6[i][1] =diaodu6[i][0];
				diaodu6[i][2] =diaodu6[i][0];
				if(arr6.size()<=2){
					diaodu6[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu6[i][3] = diaodu6[i][2]+0.166666; 
				}
			}else if(i==1){
				//第二个到达 允许时间为到达时间
				diaodu6[i][1] = diaodu6[i][0];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu6[i][2] = Math.max(diaodu6[i-1][3],diaodu6[i][1]);
				diaodu6[i][2] = Math.max(diaodu6[i][2],diaodu6[i][0]);
				if(diaodu6[i][2]==100){
					diaodu6[i][2] = diaodu6[i-1][2] + 0.166666*2; 
					diaodu6[i][2] = Math.max(diaodu6[i][2], diaodu6[i][0]);
				}
				if(arr6.size()<=2){
					diaodu6[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu6[i][3] = diaodu6[i][2]+0.166666; 
				}
			}else{
				//允许时间为上上辆车的离开时间
				diaodu6[i][1] = diaodu6[i-2][3];
				//装载时间为Max(允许时间,上一辆的离开时间)
				diaodu6[i][2] = Math.max(diaodu6[i-1][3],diaodu6[i][1]);
				diaodu6[i][2] = Math.max(diaodu6[i][2],diaodu6[i][0]);
				if(diaodu6[i][2]==100){
					diaodu6[i][2] = diaodu6[i-1][2] + 0.166666*2; 
					diaodu6[i][2] = Math.max(diaodu6[i][2], diaodu6[i][0]);
				}
				//
				if(arr6.size()-i<=2){
					diaodu6[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu6[i][3] = diaodu6[i][2]+0.166666; 
				}
			}
		}
		
		//7
		for(int i=0;i<arr7.size();i++){
			if(i==0){
				//第一个到达的装载时间和允许时间相同
				diaodu7[i][1] =diaodu7[i][0];
				diaodu7[i][2] =diaodu7[i][0];
				if(arr7.size()<=2){
					diaodu7[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu7[i][3] = diaodu7[i][2]+0.166666; 
				}
			}else if(i==1){
				//第二个到达 允许时间为到达时间
				diaodu7[i][1] = diaodu7[i][0];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu7[i][2] = Math.max(diaodu7[i-1][3],diaodu7[i][1]);
				diaodu7[i][2] = Math.max(diaodu7[i][2],diaodu7[i][0]);
				if(diaodu7[i][2]==100){
					diaodu7[i][2] = diaodu7[i-1][2] + 0.166666*2; 
					diaodu7[i][2] = Math.max(diaodu7[i][2], diaodu7[i][0]);
				}
				if(arr7.size()<=2){
					diaodu7[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu7[i][3] = diaodu7[i][2]+0.166666; 
				}
			}else{
				//允许时间为上上辆车的离开时间
				diaodu7[i][1] = diaodu7[i-2][3];
				//装载时间为Max(允许时间,上一辆的离开时间)
				diaodu7[i][2] = Math.max(diaodu7[i-1][3],diaodu7[i][1]);
				diaodu7[i][2] = Math.max(diaodu7[i][2],diaodu7[i][0]);
				if(diaodu7[i][2]==100){
					diaodu7[i][2] = diaodu7[i-1][2] + 0.166666*2; 
					diaodu7[i][2] = Math.max(diaodu7[i][2], diaodu7[i][0]);
				}
				//
				if(arr7.size()-i<=2){
					diaodu7[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu7[i][3] = diaodu7[i][2]+0.166666; 
				}
			}
		}
		
		//8
		for(int i=0;i<arr8.size();i++){
			if(i==0){
				//第一个到达的装载时间和允许时间相同
				diaodu8[i][1] =diaodu8[i][0];
				diaodu8[i][2] =diaodu8[i][0];
				if(arr8.size()<=2){
					diaodu8[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu8[i][3] = diaodu8[i][2]+0.166666; 
				}
			}else if(i==1){
				//第二个到达 允许时间为到达时间
				diaodu8[i][1] = diaodu8[i][0];
				//装载时间为Max(允许时间,上一辆的离开时间,到达时间)
				diaodu8[i][2] = Math.max(diaodu8[i-1][3],diaodu8[i][1]);
				diaodu8[i][2] = Math.max(diaodu8[i][2],diaodu8[i][0]);
				if(diaodu8[i][2]==100){
					diaodu8[i][2] = diaodu8[i-1][2] + 0.166666*2; 
					diaodu8[i][2] = Math.max(diaodu8[i][2], diaodu8[i][0]);
				}
				if(arr8.size()<=2){
					diaodu8[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu8[i][3] = diaodu8[i][2]+0.166666; 
				}
			}else{
				//允许时间为上上辆车的离开时间
				diaodu8[i][1] = diaodu8[i-2][3];
				//装载时间为Max(允许时间,上一辆的离开时间)
				diaodu8[i][2] = Math.max(diaodu8[i-1][3],diaodu8[i][1]);
				diaodu8[i][2] = Math.max(diaodu8[i][2],diaodu8[i][0]);
				if(diaodu8[i][2]==100){
					diaodu8[i][2] = diaodu8[i-1][2] + 0.166666*2; 
					diaodu8[i][2] = Math.max(diaodu8[i][2], diaodu8[i][0]);
				}
				//
				if(arr8.size()-i<=2){
					diaodu8[i][3] = 100d;
				}else{
					//离开时间为装载时间+0.166666
					diaodu8[i][3] = diaodu8[i][2]+0.166666; 
				}
			}
		}
		
		
		
		//print arr1
		//第一列为到达时间 第二列为允许时间 第三列为装载时间 第四列为离开时间
		System.out.println("            "+"到达时间"+"          允许时间"+"          装载时间"+"          离开时间");
		for(int i=0;i<arr1.size();i++){
			System.out.print(arr1.get(i).getName()+" ");
			for(int j=0;j<4;j++){
				System.out.print(diaodu1[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=0;i<arr2.size();i++){
			System.out.print(arr2.get(i).getName()+" ");
			for(int j=0;j<4;j++){
				System.out.print(diaodu2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=0;i<arr3.size();i++){
			System.out.print(arr3.get(i).getName()+" ");
			for(int j=0;j<4;j++){
				System.out.print(diaodu3[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=0;i<arr4.size();i++){
			System.out.print(arr4.get(i).getName()+" ");
			for(int j=0;j<4;j++){
				System.out.print(diaodu4[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=0;i<arr5.size();i++){
			System.out.print(arr5.get(i).getName()+" ");
			for(int j=0;j<4;j++){
				System.out.print(diaodu5[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=0;i<arr6.size();i++){
			System.out.print(arr6.get(i).getName()+" ");
			for(int j=0;j<4;j++){
				System.out.print(diaodu6[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<arr7.size();i++){
			System.out.print(arr7.get(i).getName()+" ");
			for(int j=0;j<4;j++){
				System.out.print(diaodu7[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<arr8.size();i++){
			System.out.print(arr8.get(i).getName()+" ");
			for(int j=0;j<4;j++){
				System.out.print(diaodu8[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	
	public static void getZCarInput(){
		//从out中选取部分 等同于out1.txt
//		File file = new File("G:/MCM/zCar.txt");
		File file = new File("G:/MCM/getOut/out10.txt");
        StringBuilder result = new StringBuilder();
        double[] resDou = new double[360];
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            int countLine = 0;
            int count = 0;
            int ZIndex = 1;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            	int countAllCar = 0;
            	
            	if(s.trim()!=null||!"".equals(s.trim())){
            		if(s.startsWith("Z")){
            			ZIndex = Integer.valueOf(s.substring(1, 3));
                		String countStr = s.substring(4);
                		String[] split = countStr.split("\\s");
                		countAllCar = Integer.valueOf(split[1])+ Integer.valueOf(split[3])+Integer.valueOf(split[5]);
                		for(int i=0;i<countAllCar;i++){
                			String temp = br.readLine();
                			String[] split2 = temp.split("\\s");
                			double dis = Double.valueOf(split2[1]);
                			String type = String.valueOf(split2[0].charAt(0));
                			String name = split2[0];
                			Z2F z2f = new Z2F(dis,type,name);
                			switch(ZIndex){
    	            			case 1:arr1.add(z2f);break;
    	            			case 2:arr2.add(z2f);break;
    	            			case 3:arr3.add(z2f);break;
    	            			case 4:arr4.add(z2f);break;
    	            			case 5:arr5.add(z2f);break;
    	            			case 6:arr6.add(z2f);break;
    	            			case 7:arr7.add(z2f);break;
    	            			case 8:arr8.add(z2f);break;
                			}
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
	
	
	public static class Z2F{
		//z到f的最短距离
		double dis;
		//车的种类
		String type;
		//车的名字
		String name;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public double getDis() {
			return dis;
		}

		public void setDis(int dis) {
			this.dis = dis;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Z2F(double dis, String type, String name) {
			super();
			this.dis = dis;
			this.type = type;
			this.name = name;
		}
		
	}
	
	public static class ComparatorImpl implements Comparator<Z2F> {  
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

}
