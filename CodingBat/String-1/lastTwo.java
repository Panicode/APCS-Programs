public String lastTwo(String str) {
  if(str.length()<1)return "";
  if(str.length()<2)return str;
  return str.substring(0,str.length()-2)+str.substring(str.length()-1)+str.substring(str.length()-2,str.length()-1);
}
