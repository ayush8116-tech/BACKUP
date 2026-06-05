void setup() {
  // put your setup code here, to run once:
  pinMode(13, INPUT);
  pinMode(9, OUTPUT);
  Serial.begin(9600);
}
int voltage = 0;
bool isPressed = false;
int number = 0;
void loop() {
   int i = digitalRead(13);
  if (i == 0 && !isPressed) {
  number = number + 1;
  Serial.println("pressed");
  voltage = voltage == 0 ? 255 : 0;
  analogWrite(9, voltage);
  isPressed = true;
  }
if(i == 1) {
isPressed = false;
  Serial.println("not pressed");
}
  Serial.println(number);
}
