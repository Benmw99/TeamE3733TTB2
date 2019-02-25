
#define BAUD (9600)
#define Dir_Pin (4)
#define Step_Pin (3)

class Robot{
	public:
		Robot(){
			
		}
		int getSteps(){
			return steps
		}
	private:
		int steps;
		int stepsPerRot;
		
};



void setup() 
{
  Serial.begin(BAUD);
  pinMode(Dir_Pin,OUTPUT); // Step
  pinMode(Step_Pin,OUTPUT); // Dir
}

void loop() 
{
  
  digitalWrite(Dir_Pin,HIGH); // Set Dir high
//  Serial.println("Loop 200 steps (1 rev)");
  for(x = 0; x < 6000; x++) // Loop 200 times
  {
    digitalWrite(Step_Pin,HIGH); // Output high
    delay(10); // Wait
    digitalWrite(Step_Pin,LOW); // Output low
    delay(20); // Wait
  }
//  Serial.println("Pause");
  delay(1000); // pause one second
}
