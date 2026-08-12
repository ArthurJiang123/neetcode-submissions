class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length+nums2.length];
        int i1 = 0, i2 = 0, im = 0;
        while(i1 < nums1.length && i2 < nums2.length){
            if(nums1[i1] <= nums2[i2]){
                merge[im] = nums1[i1];
                i1++;
            } else {
                merge[im] = nums2[i2];
                i2++;
            }
            im++;
        }
        while(i1 < nums1.length) merge[im++] = nums1[i1++];
        while(i2 < nums2.length) merge[im++] = nums2[i2++];

        int left = 0, right = merge.length-1;
        int mid = (left + right / 2);
        if (merge.length % 2 == 0){
            return (double) (merge[mid] + merge[mid+1]) / 2;
        }else{
            return merge[mid];
        }

    }
}
