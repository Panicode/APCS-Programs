public String comboString(String a, String b) {
  if(a.length()<b.length())return a+b+a;
  if(a.length()>b.length())return b+a+b;
  return "";
}
