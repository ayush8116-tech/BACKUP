class Main{
  public static void main() {
    String a = "abc";
    String b = new String("abc");
    String c = new String("bc");
  System.out.println(b.intern());
    // System.out.println(a.concat("d"));
    // System.out.println(b.substring(1,3));
    // System.out.println(b.toUpperCase());
  }
}
