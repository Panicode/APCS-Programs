public boolean endsLy(String str) {
  if(str.length()>1){
    if(str.charAt(str.length()-1)=='y'&&str.charAt(str.length()-2)=='l'){
      return true;
    }
  }
  return false;
}
