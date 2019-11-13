public int luckySum(int a, int b, int c) {
  if(a!=13){
    if(b!=13){
      if(c!=13){
        return a+b+c;
      }
      return a+b;
    }
    return a;
  }
  return 0;
}
