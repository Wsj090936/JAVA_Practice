package algorithms;
/**
 *  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	You are given a target value to search. If found in the array return its index, otherwise return -1.
	
	You may assume no duplicate exists in the array.
 * @author wushijia
 *����һ���Ѿ��ź��������  ��������ܰ��������е�ĳһ����������ת
 *���ڸ���һ���������жϸ����Ƿ������������
 *û�����-1
 *����������±�
 *���ֲ���
 */
public class Search_in_Rotated_Sorted_Array_33 {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = (l + r)/2;
            if(target == nums[mid]) return mid;
            if(nums[l] <= nums[r]){//���һ[0,1,2,4,5,6,7]
                if(target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            }else if( nums[l] <= nums[mid] ){//�����[5,6,7,0,1,2,4]
                if(target < nums[mid] && target > nums[r]) r = mid - 1;
                else l = mid + 1;
            }else if( nums[l] >= nums[mid]){//�����[4,5,6,7,1,2,4]
                if(target > nums[mid] && target < nums[l]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}
