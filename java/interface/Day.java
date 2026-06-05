public enum Day{
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY,
  SUNDAY;

  boolean isWeekend;
  Day() {
    this.isWeekend = this.name().equals("SATURDAY") || this.name().equals("SUNDAY");
  }

  public Day nextDay() {
    return values()[(this.ordinal() + 1) % values().length];
  }
  
  public int hash() {
    return this.hashCode();
  }
}
