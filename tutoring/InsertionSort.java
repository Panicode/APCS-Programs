public class InsertionSort{
    public static void main(String[] args){
        int[] nums=new int[10]; //how many variables i want
        for(int i=0;i<nums.length;i++){
            nums[i]=(int)(Math.random()*100);
        }
        System.out.println("The initial numbers are:\n");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        for(int i=1;i<nums.length;i++){
            int key = nums[i];  
            int j = i - 1;
            while (j >= 0 && nums[j] > key){  
                nums[j+1] = nums[j];  
                j=j-1;  
            }  
            nums[j+1] = key;  
        }
        System.out.println("\nThe sorted numbers are:\n");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
