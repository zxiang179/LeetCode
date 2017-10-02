package zx.leetcode.Sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 690. Employee Importance
 * @author Carl_Hugo
 * 2017年9月30日 上午10:28:07
 */
public class Employee_Importance {
	
	
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer,Employee> map = new HashMap<>();
		for(Employee employee:employees){
			map.put(employee.id, employee);
		}
		return getImportanceHelper(map,id);
	}
	
	private int getImportanceHelper(Map<Integer,Employee> map,int rootId){
		Employee root = map.get(rootId);
		int total = root.importance;
		for(int subordinate:root.subordinates){
			total+=getImportanceHelper(map, subordinate);
		}
		return total;
	}
	
	/*int sumValue = 0;
	
	public int getImportance(List<Employee> employees, int id) {
		Set<Integer> subEmpSet = new HashSet<Integer>();
		getSubEmpId(employees, subEmpSet, id);
		sumValue+=employees.get(id-1).importance;
		for(Integer i:subEmpSet){
			Employee employee = employees.get(i-1);
			sumValue += employee.importance;
		}	
		return sumValue;
    }
	
	public void getSubEmpId(List<Employee> employees,Set<Integer> subEmpSet,int id){
		Employee employee = employees.get(id-1);
		if(employee.subordinates==null||employee.subordinates.size()==0){
			subEmpSet.add(id);
			return;
		}
		List<Integer> subEmpList = employee.subordinates;
		for(int i=0;i<subEmpList.size();i++){
			subEmpSet.add(subEmpList.get(i));
		}
		return;
	}*/
	
	public static void main(String[] args) {
		// [[1,5,[2,3]],[2,3,[4]],[3,4,[]],[4,1,[]]]
		// 1
		List<Employee> inputList = new ArrayList<Employee>();
		
		int[] arr1 = new int[]{2,3};
		List<Integer> list1 = new ArrayList<Integer>();
		for(int i : arr1){
			list1.add(i);
		}
		int[] arr2 = new int[]{4};
		List<Integer> list2 = new ArrayList<Integer>();
		for(int i : arr2){
			list2.add(i);
		}
//		Employee e1 = new Employee();
		
		
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
