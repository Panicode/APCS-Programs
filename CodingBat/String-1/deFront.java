public String deFront(String str){
  String out=str;
  if(str.charAt(0)!='a'&&str.charAt(1)!='b')return str.substring(2);
  if(str.charAt(0)!='a')out=str.substring(1);
  if(str.charAt(1)!='b')out=str.substring(0,1)+str.substring(2);
  return out;
}
