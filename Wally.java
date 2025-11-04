import robocode.*;
import java.awt.Color;

/**
 * Wally - a robot by Marcos
 */
public class Wally extends Robot {

    /**
     * run: comportamento principal do robô
     */
    public void run() {
        // Definindo cores: corpo, canhão e radar
        setColors(Color.red, Color.black, Color.white);

        // Variável para contar quantos quadrados completos o robô percorreu
        int voltas = 0;

        // Enquanto o robô tiver energia suficiente, ele continua o movimento
        while (true) {
            // Movimenta em formato de quadrado
            for (int i = 0; i < 4; i++) {
                ahead(150);       // Anda 150 pixels para frente
                turnRight(90);    // Vira 90 graus à direita (forma o canto do quadrado)
            }

            voltas++; // Conta uma volta completa (um quadrado completo)

            // Estratégia de parada:
            // Se o robô fizer 5 voltas ou a energia ficar muito baixa, ele para.
            if (voltas >= 5 || getEnergy() < 20) {
                out.println("Finalizando movimento: energia baixa ou 5 voltas completas.");
                break; // Sai do loop principal
            }
        }

        // Após sair do loop, o robô para e imprime mensagem no console
        out.println("Wally parou após completar o padrão em quadrado.");
    }

    /**
     * onScannedRobot: o que fazer quando detectar outro robô
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Estratégia simples: atira quando detectar um inimigo
        fire(3);
    }

    /**
     * onHitByBullet: o que fazer quando for atingido por um tiro
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Ao ser atingido, recua um pouco
        back(450);
    }

    /**
     * onHitWall: o que fazer quando bater na parede
     */
    public void onHitWall(HitWallEvent e) {
        // Ao colidir com uma parede, recua e vira para não ficar preso
        back(450);
        turnRight(200);
    }    
}


