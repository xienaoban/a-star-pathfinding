package realization;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.StringBufferInputStream;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import realization.ObstacleMap.XYT;

public class Window_Paint extends JFrame {
	private static final long serialVersionUID = 233;

	private int size;
	private static final int width = 1200, hight = 800;
	public static final int PO = 23333333, PS = 23333334, PE = 23333335, PW = 23333336;// obst
																						// start
																						// end
	public ObstacleMap obst;
	public RectCanvas canvas;

	Window_Paint(String title, ObstacleMap ob) {
		setTitle(title);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(310, 0, width + 36, hight + 67);
		setResizable(false);
		setResizable(false);

		canvas = new RectCanvas(15, 15, width, hight);
		obst = new ObstacleMap(ob);
		size = Math.min(hight / (obst.x + 2), width / (obst.y + 2));
		getContentPane().add(canvas);

		setVisible(true);

		System.out.println("Debug>> Window_Paint builded.");

	}

	public class RectCanvas extends Canvas {
		private static final long serialVersionUID = 5070517776553228277L;

		private Image iBuffer;
		private Graphics gBuffer;

		public RectCanvas(int x, int y, int w, int h) {
			setLocation(x, y);
			setSize(w, h);
		}

		public void paint(Graphics g) {
			// Do not use "super.paint(g);" here as it would make the screen
			// twinkle.

			// Using Double Buffer
			if (iBuffer == null) {
				iBuffer = createImage((int) this.getSize().getWidth(), (int) this.getSize().getHeight());
				gBuffer = iBuffer.getGraphics();
			}

			// Paint Framework
			gBuffer.setColor(Color.WHITE);
			gBuffer.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
			gBuffer.setColor(Color.BLACK);
			gBuffer.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			for (int i = 1; i <= Window_Paint.width / size; ++i)
				gBuffer.drawLine(i * size, 0, i * size, Window_Paint.hight);
			for (int i = 1; i <= Window_Paint.hight / size; ++i)
				gBuffer.drawLine(0, i * size, Window_Paint.width, i * size);

			// Paint Map
			for (int i = 0; i < obst.x + 2; ++i)
				for (int j = 0; j < obst.y + 2; ++j)
					if (obst.vect[i][j])
						fillSqu(gBuffer, i, j, PO);
			for (int i = 1; i <= obst.x; ++i)
				for (int j = 1; j <= obst.y; ++j)
					if (obst.rt[i][j] != 2147483647)
						fillDegree(gBuffer, i, j, obst.rt[i][j]);
			fillSqu(gBuffer, obst.sx, obst.sy, PS);
			fillSqu(gBuffer, obst.ex, obst.ey, PE);

			g.drawImage(iBuffer, 0, 0, this);
		}

		public void update(Graphics g) {
			paint(g);
		}

		void fillSqu(Graphics g, int x, int y, int flag) {
			switch (flag) {
			case PO:
				g.setColor(new Color(65, 65, 65));
				g.fillRect(y * size + 1, x * size + 1, size - 1, size - 1);
				g.setColor(Color.WHITE);
				if (size > 35)
					g.drawString("WALL", y * size + size / 2 - 15, x * size + size / 2 + 5);
				else if (size > 15)
					g.drawString("W", y * size + size / 2 - 4, x * size + size / 2 + 5);
				break;
			case PS:
				g.setColor(new Color(44, 198, 89));
				g.fillRect(y * size + 1, x * size + 1, size - 1, size - 1);
				g.setColor(Color.BLACK);
				if (size > 35)
					g.drawString("START", y * size + size / 2 - 19, x * size + size / 2 + 5);
				else if (size > 15)
					g.drawString("S", y * size + size / 2 - 4, x * size + size / 2 + 5);
				break;
			case PE:
				g.setColor(new Color(246, 61, 68));
				g.fillRect(y * size + 1, x * size + 1, size - 1, size - 1);
				g.setColor(Color.BLACK);
				if (size > 35)
					g.drawString("END", y * size + size / 2 - 12, x * size + size / 2 + 5);
				else if (size > 15)
					g.drawString("E", y * size + size / 2 - 4, x * size + size / 2 + 5);
				break;
			default:
				System.out.println("Debug>> Error Code: 0x00001.");
				break;
			}
		}

		void fillDegree(Graphics g, int x, int y, int dgr) {
			if (dgr > PW) {
				dgr -= PW;
				int R = 255 - 25490 / (dgr + 100);
				int G = 255 - 25400 / (dgr + 200);
				int B = 255;
				g.setColor(new Color(R, G, B));
				g.fillRect(y * size + 1, x * size + 1, size - 1, size - 1);
				g.setColor(Color.BLACK);
				g.drawString(Integer.toString(dgr), y * size + size / 2 - 8, x * size + size / 2 + 5);
			} else {
				int R = 255;
				int G = 255;
				int B = 255 - 2549 / (dgr + 10);
				g.setColor(new Color(R, G, B));
				g.fillRect(y * size + 1, x * size + 1, size - 1, size - 1);
				g.setColor(Color.BLACK);
				g.drawString(Integer.toString(dgr), y * size + size / 2 - 8, x * size + size / 2 + 5);
			}
		}
	}
}