public int loneSum(int a, int b, int c) {
  int[] nums ={a,b,c};
  int out=0;
  for(int i=0;i<nums.length;i++){
    boolean checked=true;
    for(int j=0;j<nums.length;j++){
      if(i!=j&&nums[i]==nums[j])checked=false;
    }
    if(checked){out+=nums[i];}
  }
  return out;
}
