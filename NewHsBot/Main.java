import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.sun.jna.platform.WindowUtils;
import com.sun.jna.platform.DesktopWindow;

public class Main {

	public void launchHearthStone() {
		File file = new File("D:\\Andrey\\Files\\Battle.net\\Battle.net Launcher.exe");
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Robot bot = null;
		try {
			bot = new Robot();
		} catch (Exception failed) {
			System.err.println("Failed instantiating Robot: " + failed);
		}
		int mask = InputEvent.BUTTON1_DOWN_MASK;
		bot.mouseMove(100, 900);
		bot.mousePress(mask);
		bot.mouseRelease(mask);
	}
	
	public int[] launchMerc() {
		int [] xAy = new int[4];
		List<DesktopWindow> windows = WindowUtils.getAllWindows(true);
		for(DesktopWindow wa : windows) {
			if (wa.getTitle().equals(new String("Hearthstone"))) {
				xAy[0] = wa.getLocAndSize().x;
				xAy[1] = wa.getLocAndSize().y;
				xAy[2] = wa.getLocAndSize().height;
				xAy[3] = wa.getLocAndSize().width;
			}
		}
		return xAy;
	}
	
	public void play(int x, int y, int h, int w) {
		Robot bot = null;
		try {
			bot = new Robot();
		} catch (Exception failed) {
			System.err.println("Failed instantiating Robot: " + failed);
		}
		int mask = InputEvent.BUTTON1_DOWN_MASK;
		bot.mouseMove(h-x / 2, w-y/ 2);
		bot.mousePress(mask);
		bot.mouseRelease(mask);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.launchHearthStone();
		int [] xAy = m.launchMerc();
		m.play(xAy[0], xAy[1], xAy[2], xAy[3]);
	}
}
