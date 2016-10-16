package org.usfirst.frc.team4915.stronghold.subsystems;
 
 import org.usfirst.frc.team4915.stronghold.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
 
 
 public class Portcullis extends Subsystem {
     public static final double PERCENT_POWER_UP = 0.8;
     public static final double PERCENT_POWER_DOWN = -0.6;


     // Put methods for controlling this subsystem
     // here. Call these from Commands.
 
     public void initDefaultCommand() {
         // Set the default command for a subsystem here.
         //setDefaultCommand(new MySpecialCommand());
         RobotMap.portcullisLeftMotor.setSafetyEnabled(false);
         RobotMap.portcullisRightMotor.setSafetyEnabled(false);
         RobotMap.portcullisBarMotor.setSafetyEnabled(false);

     }
     
     public static boolean isLeftPortcullisAtTop(){
         return RobotMap.portcullisLeftMotor.isFwdLimitSwitchClosed();
     }
     public boolean isLeftPortcullisAtBottom(){
         return RobotMap.portcullisLeftMotor.isRevLimitSwitchClosed();
     }
     public static boolean isRightPortcullisAtTop(){
         return RobotMap.portcullisRightMotor.isFwdLimitSwitchClosed();
     }
     public boolean isRightPortcullisAtBottom(){
         return RobotMap.portcullisRightMotor.isRevLimitSwitchClosed();
     }
     
     public static void PortcullisMoveUp(boolean isRight){ //right is true and left is false
         if (isRight)
         { 
             RobotMap.portcullisRightMotor.set(PERCENT_POWER_UP);    
             if (isRightPortcullisAtTop())
             {
                 RobotMap.portcullisRightMotor.set(0);
                 System.out.println("Right Portcullis reached top");
             }
         }
         if (!isRight)
         {
             RobotMap.portcullisLeftMotor.set(PERCENT_POWER_UP);    
             if (isLeftPortcullisAtTop())
             {
                 RobotMap.portcullisLeftMotor.set(0);
                 System.out.println("Left Portcullis reached top");
             }
         }
     }
        
     
     public void PortcullisMoveDown(boolean isRight){
         if (isRight)
         {
             RobotMap.portcullisRightMotor.set(PERCENT_POWER_DOWN);    
             if (isRightPortcullisAtBottom())
             {
                 RobotMap.portcullisRightMotor.set(0);
                 System.out.println("Right Portcullis reached bottom");
             }
         }
         if (!isRight)
         {
             RobotMap.portcullisLeftMotor.set(PERCENT_POWER_DOWN);    
             if (isLeftPortcullisAtBottom())
             {
                 RobotMap.portcullisLeftMotor.set(0);
                 System.out.println("Left Portcullis reached bottom");
             }
         }
     }
     
     // may need to be reversed
         
     public void PortcullisBarIn(){
         if (isLeftPortcullisAtBottom() && isRightPortcullisAtBottom())
         {
             RobotMap.portcullisBarMotor.set(-PERCENT_POWER_UP);
         }
         else 
             RobotMap.portcullisBarMotor.set(0);
     }
     
     public void stopLeftMotor() {
         RobotMap.portcullisLeftMotor.set(0);
     }
     
     public void stopRightMotor() {
         RobotMap.portcullisRightMotor.set(0);
     }
     
     public static void PortcullisBarOut(){
         RobotMap.portcullisBarMotor.set(PERCENT_POWER_UP);
     }
 }
 