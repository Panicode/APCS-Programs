public String extraFront(String str) {
  if(str.length()<2){
    return str+str+str;
  }
  String front=str.substring(0,2);
  return front+front+front;
}
