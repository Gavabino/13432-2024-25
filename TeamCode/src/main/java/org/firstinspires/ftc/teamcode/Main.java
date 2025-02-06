package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

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
        DcMotor slider = hardwareMap.get(DcMotor.class, "linear slider");
        Servo arm = hardwareMap.get(Servo.class, "arm");
        CRServo claw = hardwareMap.get(CRServo.class, "claw");

        // Reverse the right side.
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);

        rightRear.setDirection(DcMotorSimple.Direction.FORWARD);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
        // This makes the robot BRAKE when power becomes zero. The other
        // mode, FLOAT, makes the robot go in neutral and will drift.
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            // Game pad 1

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
                } else if (gamepad1.right_bumper) {
                    rightFront.setPower(0.75);
                    leftFront.setPower(-0.75);
                    rightRear.setPower(0.75);
                    leftRear.setPower(-0.75);
                } else if (gamepad1.left_bumper) {
                    rightFront.setPower(-0.75);
                    leftFront.setPower(0.75);
                    rightRear.setPower(-0.75);
                    leftRear.setPower(0.75);
                } else {
                    rightFront.setPower(0);
                    leftFront.setPower(0);
                    rightRear.setPower(0);
                    leftRear.setPower(0);
                }
                if (gamepad1.right_stick_x > 0.5) {
                    rightFront.setPower(1);
                    leftFront.setPower(-1);
                    rightRear.setPower(1);
                    leftRear.setPower(-1);
                } else if (gamepad1.right_stick_x < -0.5) {
                    rightFront.setPower(-1);
                    leftFront.setPower(1);
                    rightRear.setPower(-1);
                    leftRear.setPower(1);
                }

                // Game pad 2

                3if (gamepad2.dpad_up) {
                    slider.setPower(-1);
                } else if (gamepad2.dpad_down) {
                    slider.setPower(1);
                } else {
                    slider.setPower(0);
                }
                if (gamepad2.right_bumper) {
                    claw.setPower(1);
                } else if (gamepad2.left_bumper) {
                    claw.setPower(-1);
                } else {
                    claw.setPower(0);
                }
                if (gamepad2.y) {
                    arm.setPosition(0.0);
                } else if (gamepad2.b) {
                    arm.setPosition(0.1);
                } else if (gamepad2.a) {
                    arm.setPosition(0.23);
                }

                telemetry.addData("Arm position: ", arm.getPosition());
                telemetry.addData("slider position: ", slider.getCurrentPosition());
                telemetry.update();

            }
        }
    }
}