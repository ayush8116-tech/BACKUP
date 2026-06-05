int n = 0;
int m = 1;
int next;
void setup() {
  // put your setup code here, to run once:
  pinMode(11, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
for(int i = 0; i <= 5; i++) {
  next = n + m;
  n = m;
  m = next;
  for(int j = 0; j < next; j++) {
  Serial.println(next);
  digitalWrite(11, HIGH);
  delay(100);
  digitalWrite(11, LOW);
  delay(1000);
  }
  digitalWrite(11, HIGH);
  delay(3000);
}
n = 0;
m = 1;
next = 0;
}
