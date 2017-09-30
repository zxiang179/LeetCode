package zx.leetcode.Sep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 690. Employee Importance
 * @author Carl_Hugo
 * 2017年9月30日 上午10:28:07
 */
public class Employee_Importance {
	
	/*class MyComparator implements Comparator<Employee>{
		@Override
		public int compare(Employee a, Employee b) {
			if(a.importance>b.importance){
				return -1;
			}else{
				return 1;
			}
		}
	}*/
	
	public int getImportance(List<Employee> employees, int id) {
		int sumValue = 0;
		List<Integer> sub = null;
		for(int i=0;i<employees.size();i++){
			Employee employee = employees.get(i);
			if(id==employee.id){
				sumValue +=employee.importance;
				sub = new ArrayList(employee.subordinates);
			}
		}
		for(int i=0;i<sub.size();i++){
			int subId = sub.get(i);
			Employee employee = employees.get(subId-1);
			sumValue += employee.importance;
		}
		return sumValue;
    }

	class Employee{
		//unique id
		public int id;
		//importance value
		public int importance;
		//the id of direct subordinates
		public List<Integer> subordinates;
	}

}
