public int makeChocolate(int small, int big, int goal) {
  int result = goal % 5;  
  if(result > 0){
    if((small + big*5) >= goal){
      if(goal-big*5 < 0){
        if((goal % 5) > small){
          return -1;
        }else{
          return goal % 5;
        }
      }else{
        return goal-big*5;
      }
    }else{
      return -1;
    }
  }else{
    if(big*5 + small < goal){
      return -1;
    }
    if((goal - big*5) <= 0){
      return 0;
    }else{
      return goal - big*5;
    }   
  }
}
