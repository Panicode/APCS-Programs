public boolean makeBricks(int small, int big, int goal) {
  if(small > goal)
    return true;
  if(goal - (big*5) <= small && goal - (big*5) >= 0 )
    return true;
  else if(big* 5 > goal){
    if( goal/5 < big && goal%5 <= small)
      return true;
    }
  return false;
}
