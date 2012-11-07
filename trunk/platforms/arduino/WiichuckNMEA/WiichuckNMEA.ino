/*
 * WiiChuckNMEA
 *
 * output wii nunckuck values in a NMEA 0183 formatted message
 *
 * $WICHK,JOYX,JOYY,ACCX,ACCY,ACCZ,ZBUT,CBUT*CHECKSUM[CR][LF]
 *
 * TODO Calcutate checksum (always 00)
 */

#include <Wire.h>
#include "nunchuck_funcs.h"

int loop_cnt=0;

byte joyx,joyy,accx,accy,accz,zbut,cbut;
//const int LEDPIN = 13;
const int BAUD = 19200;

void setup()
{
    Serial.begin(BAUD);
    nunchuck_setpowerpins();
    nunchuck_init(); // send the initilization handshake    
    loop_cnt = 0;
}

void loop()
{
//    if( loop_cnt > 100 ) { // every 100 msecs get new data

        nunchuck_get_data();

        joyx = nunchuck_joyx();
        joyy = nunchuck_joyy(); 
        accx = nunchuck_accelx(); // ranges from approx 70 - 182
        accy = nunchuck_accely(); // ranges from approx 65 - 173
        accz = nunchuck_accelz(); // ranges from approx 65 - 173
        zbut = nunchuck_zbutton();
        cbut = nunchuck_cbutton(); 
        
        // FOR DEBUG nunchuck_print_data();
                
        Serial.print("$WICHK,");
        Serial.print(joyx,DEC);
        Serial.print(",");
        Serial.print(joyy,DEC);
        Serial.print(",");
        Serial.print((byte)accx,DEC);
        Serial.print(",");
        Serial.print((byte)accx,DEC);
        Serial.print(",");
        Serial.print((byte)accz,DEC);
        Serial.print(",");
        Serial.print((byte)zbut,DEC);
        Serial.print(",");
        Serial.print((byte)cbut,DEC);
        Serial.print("*");
        Serial.print("00");
        Serial.print("\r\n");
//    }
    loop_cnt++;
    delay(10);
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
