package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

@Autonomous(name="Left Red Autonomous", group="K9bot")
public class CraterAuto extends AutonomousBase {

    public CraterAuto() {
        super(true);
    }

    @Override
    public void runOpModeImpl() {
        double fastness = 0.2; //make this value BIG
        helper.drive(fastness, FOOT_SQRT_2);
        Position place = Position.LEFT;
        switch(place) {
            case LEFT:
                helper.rotate(-45, fastness, false);
                helper.drive(fastness, 36);
                //helper.diaganolDrive(fastness, 2, 'l');
                helper.rotate(90, fastness, false);
                helper.drive(fastness, 24);
                dropTrophy();
                helper.drive(fastness, 96);
                break;
            case MIDDLE:
                helper.drive(fastness, 2 * FOOT_SQRT_2);
                dropTrophy();
                helper.drive(fastness, FOOT_SQRT_2);
                helper.rotate(-135, fastness, false);
                helper.drive(fastness, 108);
                break;
            case RIGHT:
                helper.rotate(45, fastness, false);
                helper.drive(fastness, 24);
                helper.rotate(-90, fastness, false);
                helper.drive(fastness, 24);
                helper.rotate(45, fastness, false);
                dropTrophy();
                helper.drive(fastness, FOOT_SQRT_2);
                helper.rotate(-135, fastness, false);
                helper.drive(fastness, 108);
                break;
        }
    }
}
