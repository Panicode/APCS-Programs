public int roundSum(int a, int b, int c) {
  int out=0;
  int[] func={a,b,c};
  for(int i=0;i<func.length;i++){
    int end=func[i]%10;
    if(end<5){
      out+=func[i]-end;
    }else{
      out+=func[i]-end+10;
    }
  }
  return out;
}
