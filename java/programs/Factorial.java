class Factorial {
  public static void main() {
    int factorial = factorial(5);
    display(factorial);
  }

  public static int factorial(int number) {
    int fact = number;

    for(int i = number - 1; i > 1; i--) {
      fact = i * fact;
    }
    
    return fact;
  }

  public static void display(int number) {
    System.out.println(number);
  }
}