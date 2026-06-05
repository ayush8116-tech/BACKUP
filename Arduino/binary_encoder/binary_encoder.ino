int bit;
int red = 3;
int blue = 11;
int voltage = 255;

int binaryLength (int num) {
  int len = 0;
  if(num == 0) {
    return 0;
  }
  while(num != 1) {
  len++;
  num = num / 2;
  }
  len++;
  return len;
}


int calculator (int a, int b) {
    return a + b;
}

void output (int result) {
  int digitLength = binaryLength(result);
  if(digitLength == 0) {
    analogWrite(red, voltage);
    delay(1000);
    analogWrite(red, 0);
    return;
  }
  for(int j = digitLength - 1; j >= 0 ; j--){
  bit = result >> j & 1;
  analogWrite(bit ? blue : red , voltage);
  analogWrite(bit ? red : blue , 0);
  Serial.println(bit);
  delay(1000);
  }

  analogWrite(bit ? blue  : red , 0);
}

void setup() {
  // put your setup code here, to run once:
  pinMode(11, OUTPUT);
  pinMode(3, OUTPUT);
  Serial.begin(9600);
  int a = 256;
  int b = 0;
  int result = calculator(a, b);
  Serial.println(result);
  output(result);
}

void loop() {

}
