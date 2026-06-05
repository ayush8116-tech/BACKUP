int time;

void setup() {
  // put your setup code here, to run once:
  pinMode(4, INPUT);
  pinMode(12, INPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  Serial.begin(9600);
}

  int isS1Sensed = false;
  int isS2Sensed = false;
void loop() {
  int sensor1 = digitalRead(4);
  int sensor2 = digitalRead(12);
  unsigned long t1, t2;
  // time = millis();

  Serial.println(isS1Sensed);
  if(sensor1 == 0 && isS1Sensed == false) {
    analogWrite(9, 5);
    t1 = millis();
    isS1Sensed = true;
    Serial.println("s1time");
    Serial.println(t1);
  }
  if(sensor1 == 1) {
    isS1Sensed = false;
  }

  if(sensor2 == 0 && isS2Sensed == false) {
    analogWrite(10, 200);
    analogWrite(9, 0);
    t2 = millis();
    isS2Sensed = true;
    Serial.println("s2time");
    Serial.println(t2);
    // Serial.println("speed");
    int dt = t2 - t1;
    float dts = dt / 1000;
    // Serial.println("difference");
    // Serial.println(dts);
    float speed = 4 / dts;
    Serial.println("speed in cm/s");
    Serial.println(speed);
    delay(2000);
  }
  if(sensor2 == 1){
    isS2Sensed = false;
  }
    // delay(500);
    analogWrite(10, 0);
    analogWrite(9, 0);
    // delay(50);
  // put your main code here, to run repeatedly:
}
