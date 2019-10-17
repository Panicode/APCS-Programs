public String seeColor(String str) {
  if(str.length()>=3){
    if(str.substring(0,3).contains("red")){
      return "red";
    }
  }
  if(str.length()>=4){
    if(str.substring(0,4).contains("blue")){
      return "blue";
    }
  }
  return "";
}
