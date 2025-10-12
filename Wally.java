import robocode.*;
import java.awt.Color;

/**
 * Wally - a robot by Marcos
 */ 
public class Wally extends Robot
{
    /**
     * run: comportamento principal do robô
     */
    public void run() {
        // Definindo cores: corpo, canhão, radar
        setColors(Color.red, Color.black, Color.white);

        // Loop principal do robô
        while(true) {
            ahead(100);
            turnGunRight(360);
            back(100);
            turnGunRight(360);
        }
    }

    /**
     * onScannedRobot: o que fazer quando detectar outro robô
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        fire(1);
    }

    /**
     * onHitByBullet: o que fazer quando for atingido por um tiro
     */
    public void onHitByBullet(HitByBulletEvent e) {
        back(10);
    }

    /**
     * onHitWall: o que fazer quando bater na parede
     */
    public void onHitWall(HitWallEvent e) {
        back(20);
    }    
}
