import robocode.*;
import java.awt.Color;

/**
 * Wally - Robô melhorado com scanner
 */
public class Wally extends Robot {

    /**
     * run: comportamento principal
     */
    public void run() {
        // Cores do robô
        setColors(Color.red, Color.black, Color.white);

        // Giro infinito do radar para escanear inimigos
        while (true) {
            turnRadarRight(360); // Gira o radar completamente
        }
    }

    /**
     * onScannedRobot: o que fazer quando detectar outro robô
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Mira no inimigo
        double anguloParaInimigo = e.getBearing();

        // Gira o corpo do robô para o inimigo
        turnRight(anguloParaInimigo);

        // Gira o canhão para o inimigo
        turnGunRight(anguloParaInimigo);

        // Atira com potência proporcional à distância (mais perto, mais forte)
        if (e.getDistance() > 200) {
            fire(1); // inimigo distante
        } else if (e.getDistance() > 100) {
            fire(2); // médio
        } else {
            fire(3); // perto
        }
    }

    /**
     * onHitByBullet: recuar um pouco ao ser atingido
     */
    public void onHitByBullet(HitByBulletEvent e) {
        back(20);
    }

    /**
     * onHitWall: recuar e virar ao bater em parede
     */
    public void onHitWall(HitWallEvent e) {
        back(400);
        turnRight(450);
    }
}

