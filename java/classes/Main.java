class Main {
  public static void main() {
    Intern ayush = new Intern("ayush", 19);
    Intern himanshu = new Intern("himanshu", 20);
    int[] age = himanshu.result(Math.max(ayush.getAge(), himanshu.getAge()));

    System.out.printf("%d %d",age[0], age[1]);
  }
}

