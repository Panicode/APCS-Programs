public String lastChars(String a, String b) {
  if(a.length()<1)a="@";
  if(b.length()<1)b="@";
  return a.substring(0,1)+b.substring(b.length()-1);
}
