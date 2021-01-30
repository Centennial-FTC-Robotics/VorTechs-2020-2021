package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class EncodersTest extends VortechsMethods {
    public void runOpMode() throws InterruptedException {
        resetDriveMotors();
        setBasicTolerance(4);

        telemetry.addData("frontLeftPosition:",frontLeft.getCurrentPosition());
        telemetry.addData("frontRightPosition:",frontRight.getCurrentPosition());
        telemetry.addData("backLeftPosition:",backLeft.getCurrentPosition());
        telemetry.addData("backRightPosition:",backRight.getCurrentPosition());
    }
}
