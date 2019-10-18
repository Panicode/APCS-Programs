public boolean hasBad(String str) {
  if(str.length()>=3){
    if(str.substring(0,3).equals("bad")){
     return true;
    }
    if(str.length()>=4){
      if(str.substring(1,4).equals("bad")){
       return true;
      }
    }
  }
  return false;
}
