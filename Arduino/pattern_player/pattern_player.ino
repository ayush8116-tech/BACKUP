void setup() {
  // put your setup code here, to run once:
  pinMode(13, OUTPUT);
  Serial.begin(9600);
}
  unsigned long previous = 0;
  long interval = 80;

  int i = 0;
void setLed(int normalState) {
  if(normalState % 4 == 0) {
    interval = 800;
    return digitalWrite(13, LOW);
  }
  interval = 80;
  return digitalWrite(13, normalState % 2 == 1 ? HIGH : LOW);
}

void loop() {
  // put your main code here, to run repeatedly:
  unsigned long current = millis();
  
  if(current - previous >= interval) {
    previous = current;
    setLed(i);
    i++;
  } 
}
