void setup() {
  pinMode(11,OUTPUT); 
}

void loop() {
for( int i = 0; i < 5; i++) {
  analogWrite(11, 255);
  delay(100);
  analogWrite(11, 0);
  delay(1000);
}

analogWrite(11, 5);
delay(5000);
analogWrite(11, 0);
}
