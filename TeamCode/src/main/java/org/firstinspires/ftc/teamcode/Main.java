package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.annotations.ServoType;

@TeleOp(name = "Main")
public class Main extends LinearOpMode {

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        DcMotor rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        DcMotor leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        DcMotor arm1 = hardwareMap.get(DcMotor.class, "arm1");
        DcMotor arm2 = hardwareMap.get(DcMotor.class, "arm2");
        DcMotor armHinge = hardwareMap.get(DcMotor.class, "armHinge");
        CRServo right = hardwareMap.get(CRServo.class, "right");


        double ticks = 28;
        double newTarget;

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
        arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armHinge.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
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
                if (gamepad2.y) {
                    arm1.setPower(-0.75);
                } else if (gamepad2.a) {
                    arm1.setPower(1);
                } else if (gamepad2.left_bumper) {
                    arm1.setPower(0);

                }
                if (gamepad2.x) {
                    arm2.setPower(-1);
                } else if (gamepad2.b) {
                    arm2.setPower(1);
                } else {
                    arm2.setPower(0);
                }



                if (gamepad2.dpad_down) {
                    armHinge.setPower(0.05);
                } else if (gamepad2.dpad_up) {
                    armHinge.setPower(-0.25);
                } else if (gamepad2.right_bumper) {
                    armHinge.setPower(0.25);
                }
                 else if (gamepad2.right_stick_button) {
                armHinge.setPower(-1);
                }
                 else {
                    armHinge.setPower(-0.1125);
                }

                if (gamepad2.dpad_right) {
                    right.setPower(-0.9999);
                } else if (gamepad2.dpad_left) {
                    right.setPower(0.9999);
                } else if (gamepad2.left_stick_button) {
                    right.setPower(0);


                if (arm2.getCurrentPosition()<-512)
                    armHinge.setPower(-0.5);
                if (arm2.getCurrentPosition()>3900)
                    armHinge.setPower(-0.5);






                telemetry.addData("Right power:", right.getPower());
                telemetry.addData("Linear Slider position", arm1.getCurrentPosition());
                telemetry.addData("armPosition", armHinge.getCurrentPosition());
                telemetry.addData("armPower", armHinge.getPower());
                telemetry.addData("TurretPosition", arm2.getCurrentPosition());
                telemetry.update();



            }
        }
    }
}}