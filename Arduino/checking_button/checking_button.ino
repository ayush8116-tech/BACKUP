void setup() {
  // put your setup code here, to run once:
  // pinMode(13, INPUT_PULLUP);
  // pinMode(8, INPUT_PULLUP);
  pinMode(5, OUTPUT);
  pinMode(3, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  // int input1 = digitalRead(5);
  // int input2 = digitalRead(8);
  // Serial.println("switch 1 ");
  analogWrite(5, 255);
  // Serial.println(input1);
  // Serial.println("switch 2 ");
  // Serial.println(input2);
  // delay(1000);
}
