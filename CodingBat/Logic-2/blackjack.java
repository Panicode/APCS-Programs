public int blackjack(int a, int b) {
  int max=0;
  if(a<=21)max=a;
  if(b<=21){
    if(b>max)max=b;
    return max;
  }
  return max;
}
