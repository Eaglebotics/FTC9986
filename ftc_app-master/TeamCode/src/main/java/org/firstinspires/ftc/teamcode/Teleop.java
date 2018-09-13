package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


/**
 * Created by Sheila on 9/27/2017.
 */

@TeleOp(name = "TankDrive", group="Teleop")
public class Teleop extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor motorLeft, motorRight, motorArm;
    private DigitalChannel digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servoLeft, servoRight, servoUp1, servoUp2, servoC, servoR;
    private ColorSensor CS;


    @Override
    public void runOpMode() {

        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");

        CS = hardwareMap.colorSensor.get("color");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        double tgtPowerLeft = 0;
        double tgtPowerRight = 0;
        //position of extend servo
        double currentPosition = 0.5;
        ElapsedTime runtime = new ElapsedTime();
        while (opModeIsActive()) {

                tgtPowerLeft = this.gamepad1.left_stick_y;
                tgtPowerRight = this.gamepad1.right_stick_y;
                // motorLeft.setPower(tgtPowerLeft+tgtPowerRight); //one joystick to control
                // motorRight.setPower(tgtPowerRight-tgtPowerLeft);
                motorLeft.setPower(tgtPowerLeft);
                motorRight.setPower(tgtPowerRight);
            //motorTest.setPower(.5);
            telemetry.addData("Target Power Left", tgtPowerLeft);
            telemetry.addData("Motor Power Left", motorLeft.getPower());
            telemetry.addData("Target Power Right", tgtPowerRight);
            telemetry.addData("Motor Power Right", motorRight.getPower());
            telemetry.addData("CS Red:", CS.red());
            telemetry.addData("CS Blue:", CS.blue());
            telemetry.addData("Arm encoder Value", motorArm.getCurrentPosition());
            telemetry.update();
            boolean test = true;

            //  if(runtime.time()-time1>0.11) { //literally a terrible way to work it
            //     time1=runtime.time();

            //   if ((this.gamepad2.y  || (testMode && this.gamepad1.y))&& servoE.getPosition() < 0.85) {
            //     servoE.setPosition(servoE.getPosition() + 0.01);
            //   test = true;
            // }
            //   if ((this.gamepad2.a || (testMode && this.gamepad1.a)) && servoE.getPosition() > 0) {
            //  servoE.setPosition(servoE.getPosition() - 0.01);
            //test = true;
            // }




        }

        //   if (test) {
        //       currentPosition = servoE.getPosition();
        //   }
        //   if (!this.gamepad2.a && !this.gamepad2.y) {
        //      test = false;
        //     servoE.setPosition(currentPosition);
        // }


    }

    //  if(test3){
    //        time2 = runtime.time();
    //       test3=false;
    ///   }

    //  if(gamepad1.a && gamepad1.b){
    ///      testMode= true;
    //   }



          /*  if(this.gamepad2.x){
                servoUp1.setPosition(1);
                servoUp2.setPosition(1);
            }
            else if(this.gamepad2.y){
                servoUp1.setPosition(.5);
                servoUp2.setPosition(.5);
            }
            if(this.gamepad2.right_bumper){
                servoE.setPosition(1);

            }
            else if(this.gamepad2.left_bumper){
                servoE.setPosition(0);

            }
            */




}

