package zx.leetcode.restart;

public class Remove_Element {
	
	 public int removeElement(int[] nums, int val) {
        int length=nums.length;
        //考虑除去数组长度为0的情况
        if(length==0){
            return 0;
        }

        int[] array=new int[length];
        int count=0;
        //将不含特定元素的数组重新赋给一个新的数组
        for(int i=0;i<length;i++){
            if(nums[i]!=val){
                array[count++]=nums[i];
            }
        }
        //重新将数组的元素赋值到原数组中
        for(int i=0;i<count;i++){
            nums[i]=array[i];
        }
        return count;
    }

}
