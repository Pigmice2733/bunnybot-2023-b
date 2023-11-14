// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  CANSparkMax motor;
  double motorSpeed;
  XboxController controller;
  double targetAngle;

  /** Creates a new ExampleSubsystem. */
  public Arm() {
    motor = new CANSparkMax(3, MotorType.kBrushless);
    motorSpeed = 0;
    controller = new XboxController(1);
    motor.getEncoder().setPosition(0);
     
  }

  @Override
  public void periodic() {
    double motorAngle = motor.getEncoder().getPosition(); 
    double difference = targetAngle - motorAngle; 
    
    targetAngle = controller.getLeftY();
    motor.set(difference*0.1);
    
    if(controller.getAButtonPressed()){
      targetAngle = 11;
    }
    if(controller.getBButtonPressed()){
      targetAngle = 20;
    }

    System.out.println(motorAngle);
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed) {
    motorSpeed = speed;
  }

  public double getSpeed() {
    return motorSpeed;
  }
}
