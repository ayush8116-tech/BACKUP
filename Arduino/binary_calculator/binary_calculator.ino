int number = 0;
int operatorButtonCounter = 0;
bool isPressed = false;
int op1 = 0;
int op2 = 0;

int bit;
int red = 3;
int blue = 5;
// int voltage = 255;

void setup() {
  // put your setup code here, to run once:
  pinMode(8, INPUT_PULLUP);
  pinMode(13, INPUT_PULLUP);
  pinMode(blue, OUTPUT);
  pinMode(red, OUTPUT);
  Serial.begin(9600);
}

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
  delay(300);
  int digitLength = binaryLength(result);
  if(digitLength == 0) {
    analogWrite(red, 255);
    delay(1000);
    analogWrite(red, 0);
    return;
  }
  for(int j = digitLength - 1; j >= 0 ; j--){
  bit = result >> j & 1;
  analogWrite(bit ? blue : red , 255);
  delay(300);
  analogWrite(bit ? blue : red , 0);
  delay(300);
  analogWrite(bit ? red : blue , 0);
  // delay(100);
  Serial.println(bit);
  delay(700);
  }

  analogWrite(bit ? blue  : red , 0);
}

void loop() {
  // put your main code here, to run repeatedly:
   int operandButton = digitalRead(8);
   int operatorButton = digitalRead(13);
  if (operandButton == 0 && !isPressed) {
  number = number + 1;
  Serial.println("pressed");
  delay(1000);
  isPressed = true;
  }

if(operandButton == 1) {
  isPressed = false;
  Serial.println("not pressed");
}

if(operatorButton == 0){
operatorButtonCounter = operatorButtonCounter + 1;
if(operatorButtonCounter == 1) {
op1 = number;
number = 0;
Serial.println("op1");
Serial.println(op1);
delay(2000);
}
if(operatorButtonCounter == 2) {
op2 = number;
int result = op1 + op2;
Serial.println("op2");
Serial.println(op2);
Serial.println(result);
output(result);
delay(300);
// analogWrite(3, 255);
operatorButtonCounter = 0;
number = 0;
op1 = 0;
op2 = 0;
}
}
}

