public boolean evenlySpaced(int a, int b, int c) {
  boolean ans=(a - b == b - c) || (a - c == c - b) || (a - b == c - a);
  return ans;
}
