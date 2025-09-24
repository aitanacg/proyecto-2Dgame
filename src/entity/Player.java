package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
         
        try {
            System.out.println("Image loading started");
            System.out.println(getClass().getResource("/player/girl_up_1.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/girl_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/girl_right_2.png"));
            System.out.println("Image loading ended");

        } catch (Exception e) {
            e.printStackTrace();
        }
            

    }
/*
    private void getPlayerImage() { //CHAT
    System.out.println("Image loading started");
    up1    = loadCP("/player/girl_up_1.png");
    up2    = loadCP("/player/girl_up_2.png");
    down1  = loadCP("/player/girl_down_1.png");
    down2  = loadCP("/player/girl_down_2.png");
    left1  = loadCP("/player/girl_left_1.png");
    left2  = loadCP("/player/girl_left_2.png");
    right1 = loadCP("/player/girl_right_1.png");
    right2 = loadCP("/player/girl_right_2.png");
    System.out.println("Image loading ended");
}

private java.awt.image.BufferedImage loadCP(String cpPath) { //CHAT
    try (var is = getClass().getResourceAsStream(cpPath)) {
        System.out.println("→ " + cpPath + " = " + getClass().getResource(cpPath));
        if (is == null) throw new java.io.IOException("Recurso no encontrado: " + cpPath);
        return javax.imageio.ImageIO.read(is);
    } catch (java.io.IOException e) {
        throw new RuntimeException(e);
    }
}
*/

    public void update() {

        if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
        } else if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;

        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}
