import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Main {

    static String text = "miguelgeneralmenteestamuyocupadoelnotienemuchotiempolibrevaalaescueladesdeochoporlamananahastatresporlatardedespuesdelasclaseshaymuchasactividadesloslunesvaalgimnasioparajugarbaloncestolosmartesvaaltrabajoenelcafelosmiercolesmiguelestudiaenlabibliotecalosjuevesvaalalecciondepianolosviernesaveceselvaalcineparaverunapeliculaconsusamigoslosfinesdesemanamiguelysushermanosvanalparqueolaplayalosdomingoslafamiliademiguelvaalaiglesiaydespuessequedaencasaunsabadomiguelnotienesumochilaqueascoelnecesitalamochilaparahacerlatareaperodondeestaadondevaparabuscarlaprimeroelvaalaescuelaperolamochilanoestadespueselvaalgimnasioperolamochilanoestaentonces,elvaalcafeperolamochilanoestaluego,elvaalabibliotecaperolamochilanoestaproximoelvaalcineperolamochilanoestadespuesdetodo,elvaasumamamamabuscomimochilanopuedoencontrarlalamamarespondenomedigasmipobrecitomiguelitonotepreocupeseselveranononecesitastumochila";

    static void logIn(Robot robot) {

        int waittime = 500;

        moveMouse(1006,423,10, robot);
        robot.delay(waittime);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(waittime);
        sendKeys(robot, "LacieMoore");
        robot.delay(waittime);

        moveMouse(922,533,5,robot);
        robot.delay(waittime);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(waittime);
        sendKeys(robot, "harper136");
        robot.delay(waittime);

        // Move to color dropdown
        moveMouse(835,711,5,robot);
        robot.delay(waittime);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(waittime);

        // Move to Azul
        moveMouse(830,359,5,robot);
        robot.delay(waittime);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(waittime);

        // Log in button
        moveMouse(1112,840,5,robot);
        robot.delay(waittime);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(waittime);

        // Select main thing
        moveMouse(929,452,5,robot);
        robot.delay(waittime);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(waittime + 1000);

        // Select game
        moveMouse(263,949,5,robot);
        robot.delay(waittime);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(waittime);

        // Arrow down
        for(int i = 0; i < 5; i++) {
            robot.keyPress(40);
            robot.delay(15);
            robot.keyRelease(40);
            robot.delay(15);
        }

        moveMouse(260,949,5,robot);
        robot.delay(waittime);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
    }

    static void sendKeys(Robot robot, String keys) {
        for (char c : keys.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException(
                        "Key code not found for character '" + c + "'");
            }
            robot.keyPress(keyCode);
            robot.delay(3);
            robot.keyRelease(keyCode);
            robot.delay(3);
        }
    }

    public static void moveMouse(int x, int y, int maxTimes, Robot screenWin) {
        for(int count = 0;(MouseInfo.getPointerInfo().getLocation().getX() != x ||
                MouseInfo.getPointerInfo().getLocation().getY() != y) &&
                count < maxTimes; count++) {
            screenWin.mouseMove(x, y);
        }
    }

    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        robot.delay(5000);
        while(true) {
            if (robot.getPixelColor(987, 307).getBlue() == 255) {
                    sendKeys(robot, text);

                    moveMouse(1785, 969, 5, robot);
                    robot.delay(1000);

                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    robot.delay(20);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    robot.delay(2000);
            }
            System.out.println(robot.getPixelColor(987, 307).getBlue());
            if (robot.getPixelColor(987, 307).getBlue() != 255) {
                logIn(robot);
            }
        }
    }
}
