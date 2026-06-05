class Intern {
  final private String name;
  final private int age;  
  
  Intern(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }

  public int[] result(int comparingAge) {
    int[] result = { this.age , this.age - comparingAge};
    return result;
  }
} 
