public String minCat(String a, String b) {
  if(a.length()>b.length()){
    a=a.substring(a.length()-b.length());
  }
  if(a.length()<b.length()){
    b=b.substring(b.length()-a.length());
  }
  return a+b;
}
