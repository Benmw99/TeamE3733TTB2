
#define BAUD (9600)
#define Dir_Pin (4)
#define Step_Pin (3)
#define MAX_STEPS (1024)
#define cup_0_pin (A0)
int pos = 0;
int target = 0;
String s = "";
String mode = "";
String value = "";
boolean cup_0_present = false;
/* moves so many steps counterclockwise
 *  
 * int steps: you want to go to in the direction
 * int millisPerStep: time between steps
 * 
 */
 
void stepCW(int steps, int millisPerStep)  {
  digitalWrite(Dir_Pin,HIGH); // Set Dir high
  
  for(int i = 0; i < steps; i++){
    
    digitalWrite(Step_Pin,HIGH); // Output high
    delay(10); // Wait
    digitalWrite(Step_Pin,LOW); // Output low
    delay(millisPerStep-10); // Wait
    
    pos = (pos+1+MAX_STEPS)%MAX_STEPS;
  }
}


/* moves so many steps counterclockwise
 * 
 * int steps: you want to go to in the direction
 * int millisPerStep: time between steps
 * 
 */
 
void stepCCW(int steps, int millisPerStep)  {
  digitalWrite(Dir_Pin,LOW); // Set Dir high
  
  for(int i = 0; i < steps; i++){
    
    digitalWrite(Step_Pin,HIGH); // Output high
    delay(10); // Wait
    digitalWrite(Step_Pin,LOW); // Output low
    delay(millisPerStep-10); // Wait
    
    pos = (pos-1+MAX_STEPS)%MAX_STEPS;
  }
}
/* moves closer to a pos
 * 
 * int targetPos: you want to go to
 * int millisPerStep: time between steps
 * 
 */
void stepCloserTo(int targetPos, int millisPerStep){
  if(targetPos>pos){
    stepCW((targetPos-pos)%15,millisPerStep);
  }
  else{
    stepCCW((pos-targetPos)%15,millisPerStep);
  }
}
/*
 * Zeroes Step Count at current position
 */
void zero(){
  pos = MAX_STEPS/2;
}

/*
 * Initialize
 */
void setup() 
{
  Serial.begin(BAUD);
  pinMode(Dir_Pin,OUTPUT); // Step
  pinMode(Step_Pin,OUTPUT); // Dir
  pinMode(Step_Pin,OUTPUT); // Dir
  Serial.println("Hi, I'm Winebot")
}
/*
 * main loop
 */
void loop() 
{


///////////////////////////////////////////////////////
///             Parsing Serial Commands             ///
///////////////////////////////////////////////////////
  if(Serial){
    if(Serial.available()){
      s = Serial.readStringUntil('.');
      mode = s.substring(0,4);
      value = s.substring(5);

      if(mode.equals("move")){
        
        target = (value.toInt()+MAX_STEPS+target)%MAX_STEPS;
      }
      else if(mode.equals("goto")){
        target = (value.toInt()+MAX_STEPS)%MAX_STEPS;
      }
      else if(mode.equals("zero")){
        zero();
        target = MAX_STEPS/2;
      }
      else if(mode.equals("stat")){
        
      }
    Serial.print("Current position is now: ");
    Serial.println(String(pos));
    Serial.print("Target position is now: ");
    Serial.println(String(target));
    }
  }
  
///////////////////////////////////////////////////////
///                 Move Turntable                  ///
///////////////////////////////////////////////////////
  stepCloserTo(target,40);

///////////////////////////////////////////////////////
///                     Bartend                     ///
///////////////////////////////////////////////////////

  if(analogRead(cup_0_pin)>450){
    cup_0_present = true;
  }
  else {
    cup_0_present = false;  
  }
//  pour drink until full or moved

  
}
