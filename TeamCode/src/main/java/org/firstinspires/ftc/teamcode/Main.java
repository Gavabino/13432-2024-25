package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Main")
public class Main extends LinearOpMode {

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "front right");
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "front left");
        DcMotor rightRear = hardwareMap.get(DcMotor.class, "back right");
        DcMotor leftRear = hardwareMap.get(DcMotor.class, "back left");
        DcMotorEx launcher = hardwareMap.get(DcMotorEx.class, "launcher");
        CRServo servo1 = hardwareMap.get(CRServo.class, "battery side");
        CRServo servo2 = hardwareMap.get(CRServo.class, "opposide");

        // Reverse the right side.
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.FORWARD);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
        // This makes the robot BRAKE when power becomes zero. The other
        // mode, FLOAT, makes the robot go in neutral and will drift.
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.

            while (opModeIsActive()) {
                if (gamepad1.left_stick_y > 0.5 && gamepad1.left_stick_x > 0.5) {
                    rightFront.setPower(-0.75);
                    leftFront.setPower(0);
                    rightRear.setPower(0);
                    leftRear.setPower(-0.75);
                } else if (gamepad1.left_stick_y > 0.5 && gamepad1.left_stick_x < -0.5) {
                    rightFront.setPower(0);
                    leftFront.setPower(-0.75);
                    rightRear.setPower(-0.75);
                    leftRear.setPower(0);
                } else if (gamepad1.left_stick_y < -0.5 && gamepad1.left_stick_x < -0.5) {
                    rightFront.setPower(0.75);
                    leftFront.setPower(0);
                    rightRear.setPower(0);
                    leftRear.setPower(0.75);
                } else if (gamepad1.left_stick_y < -0.5 && gamepad1.left_stick_x > 0.5) {
                    rightFront.setPower(0);
                    leftFront.setPower(0.75);
                    rightRear.setPower(0.75);
                    leftRear.setPower(0);
                } else if (gamepad1.left_stick_y > 0.5) {
                    rightFront.setPower(-0.75);
                    leftFront.setPower(-0.75);
                    rightRear.setPower(-0.75);
                    leftRear.setPower(-0.75);
                } else if (gamepad1.left_stick_y < -0.5) {
                    rightFront.setPower(0.75);
                    leftFront.setPower(0.75);
                    rightRear.setPower(0.75);
                    leftRear.setPower(0.75);
                } else if (gamepad1.left_stick_x > 0.5) {
                    rightFront.setPower(-0.75);
                    leftFront.setPower(0.75);
                    rightRear.setPower(0.75);
                    leftRear.setPower(-0.75);
                } else if (gamepad1.left_stick_x < -0.5) {
                    rightFront.setPower(0.75);
                    leftFront.setPower(-0.75);
                    rightRear.setPower(-0.75);
                    leftRear.setPower(0.75);
                } else {
                    rightFront.setPower(0);
                    leftFront.setPower(0);
                    rightRear.setPower(0);
                    leftRear.setPower(0);
                }
                if (gamepad1.right_stick_x > 0.5) {
                    rightFront.setPower(-1);
                    leftFront.setPower(-1);
                    rightRear.setPower(1);
                    leftRear.setPower(1);
                } else if (gamepad1.right_stick_x < -0.5) {
                    rightFront.setPower(1);
                    leftFront.setPower(1);
                    rightRear.setPower(-1);
                    leftRear.setPower(-1);
                }

                if (gamepad2.right_bumper) {
                    servo2.setPower(-0.5);
                    servo1.setPower(0.5);
                } else if (gamepad2.left_bumper) {
                    servo2.setPower(0.5);
                    servo1.setPower(-0.5);
                } else {
                    servo2.setPower(0);
                    servo1.setPower(0);
                }

                if (gamepad2.a) {
                    launcher.setVelocity(1600);
                    telemetry.addData("Current speed:", launcher.getVelocity());
                } else {
                    launcher.setVelocity(0);
                }

                telemetry.update();




            }
        }
    }
}







