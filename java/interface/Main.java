class Main {
  public static void main() {
    Day d = Day.SATURDAY;
    Day day = Day.SUNDAY;
    
    System.out.println(day.isWeekend);
    System.out.println(day.hash() == d.hash());
  }
}
