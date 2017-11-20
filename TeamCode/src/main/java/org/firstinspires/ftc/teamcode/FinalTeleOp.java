package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.HardwareK9bot;

@TeleOp(name="Telop Final", group="K9bot")
public class FinalTeleOp extends OpModeBase {
    HardwareK9bot   robot           = new HardwareK9bot();
    private static boolean useSingleController = true;

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        robot.leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "haha justin is an idi0t");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            double turn = getGamepad(1).left_stick_x;
            double lateral = getGamepad(1).right_stick_x;
            double forward = -getGamepad(1).right_stick_y;

            double leftDrive, leftBack, rightDrive, rightBack;

            leftDrive = forward + lateral + turn;
            leftBack = forward - lateral +  turn;
            rightDrive = forward - lateral - turn;
            rightBack = forward + lateral - turn;
            if(getGamepad(1).x) {
                leftDrive /= 2.0;
                leftBack /= 2.0;
                rightDrive /= 2.0;
                rightBack /= 2.0;
            }
            robot.shaftController.setPower(getGamepad(2).right_trigger - getGamepad(2).left_trigger);
            robot.leftDrive.setPower(leftDrive);
            robot.leftBack.setPower(leftBack);
            robot.rightDrive.setPower(rightDrive);
            robot.rightBack.setPower(rightBack);

            if(getGamepad(2).a){//A is grab
                robot.grabberL.setPosition(.25);
                robot.grabberR.setPosition(1);
            } else if (getGamepad(2).b){//B is release
                robot.grabberL.setPosition(0);
                robot.grabberR.setPosition(1.25);
            }

            if(getGamepad(2).right_bumper) {
                robot.tail.setPosition(0);
            } else if (getGamepad(2).left_bumper) {
                robot.tail.setPosition(1);
            } else {
                robot.tail.setPosition(.5);
            }
            telemetry.update();

            // Pause for 40 mS each cycle = update 25 times a second.
            sleep(20);
        }
    }

    private Gamepad getGamepad(int number) {
        if(useSingleController) return gamepad1;
        if(number == 1) return gamepad1;
        else return gamepad2;
    }
}