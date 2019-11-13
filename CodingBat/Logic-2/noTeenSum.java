public int noTeenSum(int a, int b, int c) {
  return fixTeen(a)+fixTeen(b)+fixTeen(c);
}
public int fixTeen(int a){
  if((a>=13&&a<=14)||(a>=17&&a<=19))return 0;
  return a;
}
