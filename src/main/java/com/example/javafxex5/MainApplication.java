package com.example.javafxex5;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class MainApplication extends Application {
    Image space = new Image( "file:images/fondo.png" );
    private GraphicsContext gc;
    int puntos = 0;
    int vidas = 3;
    int nivel = 1;
    ArrayList<Sprite> disparosList = new ArrayList<Sprite>();
    Sprite disparo;
    ArrayList<Sprite> enemigoNivel1List = new ArrayList<Sprite>();
    Sprite enemigoNivel1;
    ArrayList<Sprite> enemigoNivel2List = new ArrayList<Sprite>();
    Sprite enemigoNivel2;
    ArrayList<Sprite> enemigoNivel3List = new ArrayList<Sprite>();
    Sprite enemigoNivel3;
    ArrayList<Sprite> meteoritosList = new ArrayList<Sprite>();
    Sprite meteorito;



    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Space Invaders");

        Canvas canvas = new Canvas(900, 600);
        root.getChildren().add(canvas);

        Sprite nave = new Sprite();
        nave.setImage("file:images/nau.png");


        nave.setX(400);
        nave.setY(450);

        ArrayList<String> input = new ArrayList<String>();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                if (!input.contains(code))
                    input.add(code);
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                input.remove(code);
            }
        });


        new AnimationTimer(){
            @Override
            public void handle(long time) {

                if (vidas > 0){
                    if (puntos < 10){
                        nivel = 1;
                        if (time % 8000 == 0){
                            enemigoNivel1 = new Sprite();
                            enemigoNivel1.setImage("file:images/invader1.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            enemigoNivel1.setX(px);
                            enemigoNivel1.setY(py);
                            enemigoNivel1List.add(enemigoNivel1);
                        }

                    } else if (puntos >= 10 && puntos < 20){
                        nivel = 2;
                        if (time % 8000 == 0){
                            enemigoNivel1 = new Sprite();
                            enemigoNivel1.setImage("file:images/invader1.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            enemigoNivel1.setX(px);
                            enemigoNivel1.setY(py);
                            enemigoNivel1List.add(enemigoNivel1);
                        }

                        if (time % 12000 == 0){
                            enemigoNivel2 = new Sprite();
                            enemigoNivel2.setImage("file:images/invader2.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            enemigoNivel2.setX(px);
                            enemigoNivel2.setY(py);
                            enemigoNivel2List.add(enemigoNivel2);
                        }

                    } else if (puntos >= 20 && puntos < 40){
                        nivel = 3;
                        if (time % 6000 == 0){
                            enemigoNivel1 = new Sprite();
                            enemigoNivel1.setImage("file:images/invader1.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            enemigoNivel1.setX(px);
                            enemigoNivel1.setY(py);
                            enemigoNivel1List.add(enemigoNivel1);
                        }

                        if (time % 10000 == 0){
                            enemigoNivel2 = new Sprite();
                            enemigoNivel2.setImage("file:images/invader2.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            enemigoNivel2.setX(px);
                            enemigoNivel2.setY(py);
                            enemigoNivel2List.add(enemigoNivel2);
                        }

                        if (time % 12000 == 0){
                            meteorito = new Sprite();
                            meteorito.setImage("file:images/meteorito.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            meteorito.setX(px);
                            meteorito.setY(py);
                            meteoritosList.add(meteorito);
                        }

                    } else if (puntos >= 40 && puntos < 60) {
                        nivel = 4;
                        if (time % 5000 == 0) {
                            enemigoNivel1 = new Sprite();
                            enemigoNivel1.setImage("file:images/invader1.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            enemigoNivel1.setX(px);
                            enemigoNivel1.setY(py);
                            enemigoNivel1List.add(enemigoNivel1);
                        }

                        if (time % 7000 == 0) {
                            enemigoNivel2 = new Sprite();
                            enemigoNivel2.setImage("file:images/invader2.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            enemigoNivel2.setX(px);
                            enemigoNivel2.setY(py);
                            enemigoNivel2List.add(enemigoNivel2);
                        }

                        if (time % 12000 == 0) {
                            enemigoNivel3 = new Sprite();
                            enemigoNivel3.setImage("file:images/invader3.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            enemigoNivel3.setX(px);
                            enemigoNivel3.setY(py);
                            enemigoNivel3List.add(enemigoNivel3);
                        }

                        if (time % 10000 == 0){
                            meteorito = new Sprite();
                            meteorito.setImage("file:images/meteorito.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            meteorito.setX(px);
                            meteorito.setY(py);
                            meteoritosList.add(meteorito);
                        }

                    }  else if (puntos >= 60) {
                        nivel = 5;
                        if (time % 5000 == 0) {
                            enemigoNivel1 = new Sprite();
                            enemigoNivel1.setImage("file:images/invader1.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            enemigoNivel1.setX(px);
                            enemigoNivel1.setY(py);
                            enemigoNivel1List.add(enemigoNivel1);
                        }

                        if (time % 6000 == 0) {
                            enemigoNivel2 = new Sprite();
                            enemigoNivel2.setImage("file:images/invader2.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            enemigoNivel2.setX(px);
                            enemigoNivel2.setY(py);
                            enemigoNivel2List.add(enemigoNivel2);
                        }

                        if (time % 10000 == 0) {
                            enemigoNivel3 = new Sprite();
                            enemigoNivel3.setImage("file:images/invader3.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            enemigoNivel3.setX(px);
                            enemigoNivel3.setY(py);
                            enemigoNivel3List.add(enemigoNivel3);
                        }

                        if (time % 8000 == 0){
                            meteorito = new Sprite();
                            meteorito.setImage("file:images/meteoritoFuego.png");
                            double px = 900 * Math.random();
                            double py = 0;
                            meteorito.setX(px);
                            meteorito.setY(py);
                            meteoritosList.add(meteorito);
                        }
                    }


                    for (Sprite sprite : enemigoNivel1List) {
                    int vx = 0;
                    int vy = 50;
                    sprite.setVelocity(vx, vy);
                    sprite.update(000000.010);
                    if (puntos > 30){
                        sprite.update(000000.030);
                        }
                    }

                    for (Sprite sprite : enemigoNivel2List) {
                        int vx = 0;
                        int vy = 50;
                        sprite.setVelocity(vx, vy);
                        sprite.update(00000.030);
                        if (puntos > 45){
                            sprite.update(00000.040);
                        }
                    }

                    for (Sprite sprite : enemigoNivel3List) {
                        int vx = (int) (Math.random() * 50 + 1);
                        int vy = (int) (Math.random() * 300 + 1);
                        sprite.setVelocity(vx, vy);
                        sprite.update(00000.055);
                        if (puntos > 80){
                            sprite.update(00000.060);
                        }
                    }

                    for (Sprite sprite : meteoritosList) {
                        int vx = 0;
                        int vy = 50;
                        sprite.setVelocity(vx, vy);
                        sprite.update(00000.030);
                        if (puntos >= 60){
                            sprite.update(00000.055);
                            sprite.setImage("file:images/meteoritoFuego.png");
                        }
                    }


                    if (vidas == 3){
                        nave.setImage("file:images/nau.png");
                    }
                    if (vidas < 3){
                        nave.setImage("file:images/nauTocada.png");
                     }
                    if (vidas < 2){
                        nave.setImage("file:images/nauTocada2.png");
                    }





                    nave.setVelocity(0,0);
                    if (input.contains("LEFT"))
                        nave.addVelocity(-200, 0);
                    if (input.contains("RIGHT"))
                        nave.addVelocity(200, 0);
                    if (input.contains("UP"))
                        nave.addVelocity(0, -200);
                    if (input.contains("DOWN"))
                        nave.addVelocity(0, 200);
                    if (input.contains("SPACE")){
                            if (time % 800 == 0){
                                disparo = new Sprite();
                                disparo.setImage("file:images/misil.png");
                                disparo.setY(nave.getPositionY());
                                disparo.setX(nave.getPositionX() + 10);
                                disparosList.add(disparo);
                            }

                    }
                    nave.update(000000000000.011);



                    for (Sprite sprite : disparosList) {
                        int vx = -50;
                        int vy = 0;
                        sprite.setVelocity(vy, vx);
                        sprite.update(0.1);

                        Iterator<Sprite> naveEnemiga1 = enemigoNivel1List.iterator();
                        while (naveEnemiga1.hasNext()) {
                            Sprite nave1 = naveEnemiga1.next();
                            if (disparo.intersects(nave1)) {
                                naveEnemiga1.remove();
                                puntos++;
                            }
                            if (nave1.getPositionX() == 600 || nave1.getPositionY() == 600){
                                naveEnemiga1.remove();
                            }
                        }

                        Iterator<Sprite> naveEnemiga2 = enemigoNivel2List.iterator();
                        while (naveEnemiga2.hasNext()) {
                            Sprite nave2 = naveEnemiga2.next();
                            if (disparo.intersects(nave2)) {
                                naveEnemiga2.remove();
                                puntos+=2;
                            }
                            if (nave2.getPositionX() == 600 || nave2.getPositionY() == 600){
                                naveEnemiga2.remove();
                            }
                        }

                        Iterator<Sprite> naveEnemiga3 = enemigoNivel3List.iterator();
                        while (naveEnemiga3.hasNext()) {
                            Sprite nave3 = naveEnemiga3.next();
                            if (disparo.intersects(nave3)) {
                                naveEnemiga3.remove();
                                puntos+=5;
                            }
                            if (nave3.getPositionX() == 600 || nave3.getPositionY() == 600){
                                naveEnemiga2.remove();
                            }
                        }

                    }

                    Iterator<Sprite> naveEnemiga1 = enemigoNivel1List.iterator();
                    while (naveEnemiga1.hasNext()) {
                        Sprite nave1 = naveEnemiga1.next();
                        if (nave.intersects(nave1)) {
                            naveEnemiga1.remove();
                            vidas--;
                            puntos++;
                        }
                        if (nave1.getPositionX() == 600 || nave1.getPositionY() == 600){
                            naveEnemiga1.remove();
                        }
                    }

                    Iterator<Sprite> naveEnemiga2 = enemigoNivel2List.iterator();
                    while (naveEnemiga2.hasNext()) {
                        Sprite nave2 = naveEnemiga2.next();
                        if (nave.intersects(nave2)) {
                            naveEnemiga2.remove();
                            vidas--;
                            puntos+=2;
                        }
                        if (nave2.getPositionX() == 600 || nave2.getPositionY() == 600){
                            naveEnemiga2.remove();
                        }
                    }

                    Iterator<Sprite> naveEnemiga3 = enemigoNivel3List.iterator();
                    while (naveEnemiga3.hasNext()) {
                        Sprite nave3 = naveEnemiga3.next();
                        if (nave.intersects(nave3)) {
                            naveEnemiga3.remove();
                            vidas--;
                            puntos+= 5;
                        }
                        if (nave3.getPositionX() == 600 || nave3.getPositionY() == 600){
                            naveEnemiga2.remove();
                        }
                    }

                    Iterator<Sprite> meteoritos = meteoritosList.iterator();
                    while (meteoritos.hasNext()) {
                        Sprite meteorito = meteoritos.next();
                        if (nave.intersects(meteorito)) {
                            meteoritos.remove();
                            vidas--;
                        }
                        if (meteorito.getPositionX() == 600 || meteorito.getPositionY() == 600){
                            meteoritos.remove();
                        }
                    }



                    gc = canvas.getGraphicsContext2D();
                    gc.drawImage(space,0,0);
                    nave.render(gc);

                    for (Sprite disparo : disparosList){
                        disparo.render(gc);
                    }

                    for (Sprite enemigo1 : enemigoNivel1List){
                        enemigo1.render(gc);
                    }

                    for (Sprite enemigo2 : enemigoNivel2List){
                        enemigo2.render(gc);
                    }

                    for (Sprite enemigo3 : enemigoNivel3List){
                        enemigo3.render(gc);
                    }

                    for (Sprite meteorito : meteoritosList){
                        meteorito.render(gc);
                    }



                    Font font = Font.font( "Times New Roman", FontWeight.SEMI_BOLD, 30 );
                    gc.setFont(font);
                    gc.setFill(Color.WHITE);
                    gc.setStroke(Color.WHITE);

                    String puntosJugador = "Puntos: " + puntos;
                    gc.fillText(puntosJugador, 20, 30);
                    gc.strokeText(puntosJugador, 20, 30);

                    String vidaJugador = "Vidas: " + vidas;
                    gc.fillText(vidaJugador, 20, 60);
                    gc.strokeText(vidaJugador, 20, 60);

                    String nivelPartida = "Nivel: " + nivel ;
                    gc.fillText(nivelPartida, 20, 90);
                    gc.strokeText(nivelPartida, 20, 90);


                } else if (vidas == 0){
                        Font fontPartidaPerdida = Font.font( "Times New Roman", FontWeight.SEMI_BOLD, 70 );
                        gc.setFont(fontPartidaPerdida);
                        gc.setFill(Color.RED);
                        gc.setStroke(Color.WHITE);


                        String partidaPerdida = "HAS MUERTO" ;
                        gc.fillText(partidaPerdida, 220, 320);
                        gc.strokeText(partidaPerdida, 220, 320);

                        Font fontVolverAJugar= Font.font( "Times New Roman", FontWeight.SEMI_BOLD, 45 );
                        gc.setFont(fontVolverAJugar);
                        gc.setFill(Color.RED);
                        gc.setStroke(Color.WHITE);

                        String volverAJugar = "Pulsa Enter para volver a jugar" ;
                        gc.fillText(volverAJugar, 220, 380);
                        gc.strokeText(volverAJugar, 220, 380);

                        String salir = "Pulsa Q para salir a jugar" ;
                        gc.fillText(salir, 220, 420);
                        gc.strokeText(salir, 220, 420);

                        if (input.contains("ENTER")){
                            puntos = 0;
                            vidas = 3;
                            nivel = 1;
                        } else if (input.contains("Q")){
                            System.exit(0);
                        }

                    }

                }
                
        }.start();


        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}