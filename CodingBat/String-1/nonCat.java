public String conCat(String a, String b) {
  if((!b.equals(""))&&(!a.equals(""))){
    if(a.charAt(a.length()-1)==b.charAt(0))return a+b.substring(1);
  }
  return a+b;
}
