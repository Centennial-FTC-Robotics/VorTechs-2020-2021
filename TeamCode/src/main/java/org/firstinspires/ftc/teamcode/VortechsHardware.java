package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


public class VortechsHardware extends LinearOpMode {

    //initialize motors and servos here
    public DcMotorEx frontRight = null;
    public DcMotorEx frontLeft = null;
    public DcMotorEx backRight = null;
    public DcMotorEx backLeft = null;
    public DcMotorEx leftOutTake = null;
    public DcMotorEx rightOutTake = null;
    public DcMotorEx intakeWheel = null;
    public DcMotorEx conveyor = null;
    public Servo grabberArm;
    public Servo grabberHand;
    public BNO055IMU imu;


    @Override
    public void runOpMode() throws InterruptedException {

        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        leftOutTake = hardwareMap.get(DcMotorEx.class, "leftOutTake");
        rightOutTake = hardwareMap.get(DcMotorEx.class, "rightOutTake");
        intakeWheel = hardwareMap.get(DcMotorEx.class, "intakeWheel");
        conveyor = hardwareMap.get(DcMotorEx.class, "conveyor");
        grabberArm = hardwareMap.get(Servo.class, "grabberArm");
        grabberHand = hardwareMap.get(Servo.class, "grabberHand");
        imu = hardwareMap.get(BNO055IMU.class, "imu");

        frontRight.setDirection(DcMotorEx.Direction.REVERSE);
        backRight.setDirection(DcMotorEx.Direction.REVERSE);
        leftOutTake.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        rightOutTake.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }
    public void resetDriveMotors() {
        final DcMotorEx[] driveMotors = {frontLeft, frontRight, backLeft, backRight};
        for(DcMotorEx motor : driveMotors) {
            motor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }
    public void resetOutTake(){
        leftOutTake.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        leftOutTake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    public void stopDriveMotors() {
        final DcMotorEx[] driveMotors = {frontLeft, frontRight, backLeft, backRight};
        for(DcMotorEx motor : driveMotors) {
            motor.setPower(0);
        }
    }
    public void setRunToPosition(){
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
