package zx.leetcode.chicken.july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 609. Find Duplicate File in System
 * @author Carl_Hugo
 * @date 2017年7月7日
 */
public class Test10 {
	
	/**
	 * Input:
     * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
     * Output:  
     * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
	 * @param paths
	 * @return
	 */
	public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> resultList = new ArrayList<List<String>>();
		//key:content value:directory
		Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		for(int i=0;i<paths.length;i++){
			String temp = paths[i];
			String[] split = paths[i].split("\\s");
			//root/a 1.txt(abcd) 2.txt(efgh)
			String rootPath=split[0];
			for(int j=1;j<split.length;j++){
				String file = split[j];
				int startIndex = file.indexOf("(");
				int endIndex = file.indexOf(")");
				String content = file.substring(startIndex+1, endIndex);
				String endPath = file.substring(0,startIndex);
				String fullPath = rootPath+"/"+endPath;
				if(map.containsKey(content)){
					ArrayList<String> subList = map.get(content);
					subList.add(fullPath);
				}else{
					ArrayList<String> subList = new ArrayList<String>();
					subList.add(fullPath);
					map.put(content, subList);
				}
			}
		}
		Set<Entry<String,ArrayList<String>>> entrySet = map.entrySet();
		Iterator<Entry<String, ArrayList<String>>> iterator = entrySet.iterator();
		while(iterator.hasNext()){
			Entry<String, ArrayList<String>> entry = iterator.next();
			ArrayList list = entry.getValue();
			if(list.size()>1){
				resultList.add(entry.getValue());
			}		
		}
		return resultList;
    }
	
	public static void main(String[] args) {
		new Test10().findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"});
	}

}
