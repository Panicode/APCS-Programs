public class QuickSort{
    public static void main(String[] args){
        int[] nums={7,12,4,8,13,7,12,7,3,5,72,6,1,4,6,5,43,4,5,56,1,61,6,1,63};
        for(int i=0;i<nums.length;i++){
            nums[i]=(int)(Math.random()*100);
        }
        System.out.println("The initial numbers are:\n");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        System.out.println("\nThe sorted numbers are:\n");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
