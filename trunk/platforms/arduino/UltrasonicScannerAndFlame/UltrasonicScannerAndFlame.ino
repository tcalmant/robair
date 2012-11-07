/*
 * UltraSonic Scanner + Flame
 * see
 * http://air.imag.fr/mediawiki/index.php/135038_Arduino_Flame_Detection_Sensor_Module
 * http://air.imag.fr/mediawiki/index.php/133696_HC-SR04_Ultrasonic_Sensor_Distance_Measuring_Module
 * TODO calculate checksum
 */
 
 
#include "Ultrasonic.h"
#include <Servo.h> 
 

Servo myservo;  // create servo object to control a servo 
                // a maximum of eight servo objects can be created 
Ultrasonic ultrasonicCenter(12,13);
Ultrasonic ultrasonicRight(10,11);
Ultrasonic ultrasonicLeft(6,7);

int servoPos = 90;    // variable to store the servo position 
int servoIncr = 10;    // variable to store the servo increment 
const int MINSERVOPOS=55;
const int MAXSERVOPOS=125;

/* Select the input pin for the flame detectors analogue output. */
#define FLAME_DETECT_ANA A0                                       
/* Select the input pin for the flame detectors digital output. */
#define FLAME_DETC_DIO 4       
                                  
void setup() {
  Serial.begin(4800);
  myservo.attach(3);  // attaches the servo on pin 9 to the servo object 
  
  /* Configure the DIO pin the sensors digital output will be connected to */
  pinMode(FLAME_DETC_DIO, INPUT); 
}

void loop() {

// SCANNER SECTION
  
    myservo.write(servoPos);              // tell servo to go to position in variable 'pos' 


    Serial.print("$USDIS,");
    Serial.print(ultrasonicLeft.Ranging(CM));
    Serial.print(",");
    Serial.print(ultrasonicCenter.Ranging(CM));
    Serial.print(",");
    Serial.print(ultrasonicRight.Ranging(CM));
    Serial.print(",");
    Serial.print(servoPos);
    Serial.print("*");
    Serial.print("00");
    Serial.print("\r\n");

    servoPos=servoPos+servoIncr;
    if(servoPos<MINSERVOPOS || servoPos>MAXSERVOPOS) servoIncr=-servoIncr;        
    
  delay(50);        


// FLAME DETECTOR SECTION

  Serial.print("$FLAME,");
  Serial.print(analogRead(FLAME_DETECT_ANA));
  
  /* Read the status of the sensors digital output and if it is high 
     then send an alert to the UART */
        Serial.print(",");
  if (digitalRead(FLAME_DETC_DIO)==HIGH)
  {
    Serial.print("1");
  }else
  {
    Serial.print("0");
  }

  Serial.print("*");
  Serial.print("00");
  Serial.print("\r\n");

  delay(50);        
}

byte calcChecksumBuf(byte checksum,  byte buf[], int i, int len){
  for(;i<len; i++){
    checksum=calcChecksum(checksum,buf[i]);
  }
  return checksum;
}


byte calcChecksum(byte checksum,  byte c){
        if ( c == '$' ) return 0;
        if ( c != '\r'  &&  c != '\n'  &&  c != '*' ) {
                checksum ^= c;
        }
        return checksum;
}
