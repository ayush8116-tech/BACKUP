void setup() {
  // put your setup code here, to run once:
  pinMode(13, OUTPUT);
  Serial.begin(9600);
}
  unsigned long previous = 0;
  long interval = 1000;

  int i = 0;
void setLed(int normalState) {

  return digitalWrite(13, normalState % 2 == 1 ? HIGH : LOW);
}

void loop() {
  // put your main code here, to run repeatedly:
  unsigned long current = millis();
  
  if(current - previous >= interval) {
    previous = current;
    setLed(i);
    Serial.println("5.0 second passed");
    Serial.println(current);
    i++;
  } 
}
