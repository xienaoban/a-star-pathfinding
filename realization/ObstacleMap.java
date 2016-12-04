
package realization;

import java.awt.*;
import java.awt.Graphics;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JOptionPane;

import realization.Window_Paint.RectCanvas;

import java.util.LinkedList;

public class ObstacleMap {

	public int SleepTime;
	public int x, y;
	public int sx, sy, ex, ey;
	public boolean[][] vect;
	public int[][] rt;
	public Stack<XYT> st;

	ObstacleMap(boolean[][] bb, int xx, int yy, int xx1, int yy1, int xx2, int yy2) {
		System.out.println("Debug>> Start to build Obstacle Map.");
		x = xx;
		y = yy;
		sx = xx1;
		sy = yy1;
		ex = xx2;
		ey = yy2;
		vect = new boolean[xx + 2][yy + 2];
		for (int i = 0; i < xx + 2; ++i)
			vect[i][0] = vect[i][yy + 1] = true;
		for (int j = 0; j < yy + 2; ++j)
			vect[0][j] = vect[xx + 1][j] = true;
		for (int i = 1; i <= xx; ++i)
			for (int j = 1; j <= yy; ++j)
				vect[i][j] = bb[i - 1][j - 1];
		rt = new int[xx + 2][yy + 2];
	}

	ObstacleMap(ObstacleMap ob) {
		x = ob.x;
		y = ob.y;
		sx = ob.sx;
		sy = ob.sy;
		ex = ob.ex;
		ey = ob.ey;
		vect = new boolean[x + 2][y + 2];
		for (int i = 0; i < x + 2; ++i)
			for (int j = 0; j < y + 2; ++j)
				vect[i][j] = ob.vect[i][j];
		rt = new int[x + 2][y + 2];
		st = new Stack<XYT>();
		SleepTime = Integer.parseInt(Entrance.WD_Console.TF_SleepTime.getText());
	}

	void AlgoDijkstra(RectCanvas canvas) {
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < x + 2; ++i)
					for (int j = 0; j < y + 2; ++j)
						rt[i][j] = 2147483647;
				canvas.repaint();
				Queue<XYT> que = new LinkedList<XYT>();
				int layer = 0;
				que.offer(new XYT(sx, sy, 0));
				XYT p = new XYT(sx, sy, 0);

				while (!que.isEmpty()) {
					p = que.poll();
					if (rt[p.x][p.y] <= p.t)
						continue;
					rt[p.x][p.y] = p.t;
					if (p.x == ex && p.y == ey) {
						canvas.repaint();
						break;
					}

					// if (p.t != layer) {
					// ++layer;
					try {
						Thread.sleep(SleepTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					canvas.repaint();
					// }

					if (JudgeOffer(p, 1, 0))
						que.offer(new XYT(p.x + 1, p.y, p.t + 1));
					if (JudgeOffer(p, -1, 0))
						que.offer(new XYT(p.x - 1, p.y, p.t + 1));
					if (JudgeOffer(p, 0, 1))
						que.offer(new XYT(p.x, p.y + 1, p.t + 1));
					if (JudgeOffer(p, 0, -1))
						que.offer(new XYT(p.x, p.y - 1, p.t + 1));
				}

				System.out.println("Debug>> Loop of map finished.");
				if (que.isEmpty() && p.x != ex && p.y != ey)
					JOptionPane.showMessageDialog(null, "There is no way to the destination!");
				else {
					while (p.t != 1) {
						int distx = ex - p.x;
						int disty = ey - p.y;
						int a, b;
						if (disty == 0 || Math.abs(distx / disty) >= 1) {
							a = 1;
							b = 0;
						} else {
							a = 0;
							b = 1;
						}
						if (distx < 0)
							a = -a;
						if (disty < 0)
							b = -b;
						if (rt[p.x + a][p.y + b] < (p.t))
							st.add(new XYT(p.x += a, p.y += b, p.t -= 1));
						if (rt[p.x + b][p.y + a] < (p.t))
							st.add(new XYT(p.x += b, p.y += a, p.t -= 1));
						if (rt[p.x - b][p.y - a] < (p.t))
							st.add(new XYT(p.x -= b, p.y -= a, p.t -= 1));
						if (rt[p.x - a][p.y - b] < (p.t))
							st.add(new XYT(p.x -= a, p.y -= b, p.t -= 1));
					}

					while (!st.isEmpty()) {
						p = st.pop();
						rt[p.x][p.y] = Window_Paint.PW + p.t;
						canvas.repaint();
						try {
							Thread.sleep(SleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(null, "The Shortest Path Is " + (p.t + 1) + ".");
				}
			}
		}).start();

	}

	void AlgoGreedy1(RectCanvas canvas) {
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < x + 2; ++i)
					for (int j = 0; j < y + 2; ++j)
						rt[i][j] = 2147483647;
				canvas.repaint();
				Stack<XYT> st = new Stack<XYT>();
				boolean flg = false;
				XYT p = new XYT(sx, sy, 0);
				st.add(p);
				rt[sx][sy] = 0;
				XYT dir = new XYT(1, 0, 0);
				while (!st.isEmpty() && (p.x != ex || p.y != ey)) {
					int distx = ex - p.x;
					int disty = ey - p.y;
					int a, b;
					if (disty == 0 || Math.abs(distx / disty) >= 1) {
						a = 1;
						b = 0;
					} else {
						a = 0;
						b = 1;
					}
					if (distx < 0)
						a = -a;
					if (disty < 0)
						b = -b;

					if (JudgeOffer(p, a, b)) {
						rt[p.x += a][p.y += b] = (p.t += 1);
						dir.x = a;
						dir.y = b;
						flg = true;
					} else if (JudgeOffer(p, b, a)) {
						rt[p.x += b][p.y += a] = +(p.t += 1);
						dir.x = b;
						dir.y = a;
						flg = true;
					} else if (JudgeOffer(p, -b, -a)) {
						rt[p.x -= b][p.y -= a] = +(p.t += 1);
						dir.x = -b;
						dir.y = -a;
						flg = true;
					} else if (JudgeOffer(p, -a, -b)) {
						rt[p.x -= a][p.y -= b] = +(p.t += 1);
						dir.x = -a;
						dir.y = -b;
						flg = true;
					}
					
					st.add(new XYT(p.x, p.y, p.t));
					if (!flg) {
						st.pop();
						p = st.pop();
					}
					flg = false;
					try {
						Thread.sleep(SleepTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					canvas.repaint();
				}
				canvas.repaint();

				if (st.isEmpty() && (p.x != ex || p.y != ey))
					JOptionPane.showMessageDialog(null, "There is no way to the destination!");
				else{
					Stack<XYT> stt = new Stack<XYT>();
					while (p.t != 1) {
						int distx = sx - p.x;
						int disty = sy - p.y;
						int a, b;
						if (disty == 0 || Math.abs(distx / disty) >= 1) {
							a = 1;
							b = 0;
						} else {
							a = 0;
							b = 1;
						}
						if (distx < 0)
							a = -a;
						if (disty < 0)
							b = -b;
						if (rt[p.x + a][p.y + b] < (p.t))
							stt.add(new XYT(p.x += a, p.y += b, p.t = rt[p.x][p.y]));
						else if (rt[p.x + b][p.y + a] < (p.t))
							stt.add(new XYT(p.x += b, p.y += a, p.t = rt[p.x][p.y]));
						else if (rt[p.x - b][p.y - a] < (p.t))
							stt.add(new XYT(p.x -= b, p.y -= a, p.t = rt[p.x][p.y]));
						else if (rt[p.x - a][p.y - b] < (p.t))
							stt.add(new XYT(p.x -= a, p.y -= b, p.t = rt[p.x][p.y]));
						System.out.println(" " + p.x + " " +p.y + " " + p.t);
					}

					while (!stt.isEmpty()) {
						p = stt.pop();
						rt[p.x][p.y] = Window_Paint.PW + p.t;
						canvas.repaint();
						try {
							Thread.sleep(SleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(null, "The Shortest Path Is " + (p.t + 1) + ".");
				}
				System.out.println("Debug>> Greedy finished.");
			}
		}).start();
	}
	
	void AlgoGreedy2(RectCanvas canvas) {
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < x + 2; ++i)
					for (int j = 0; j < y + 2; ++j)
						rt[i][j] = 2147483647;
				canvas.repaint();
				Stack<XYT> st = new Stack<XYT>();
				boolean flg = false;
				XYT p = new XYT(sx, sy, 0);
				st.add(p);
				rt[sx][sy] = 0;
				XYT dir = new XYT(1, 0, 0);
				while (!st.isEmpty() && (p.x != ex || p.y != ey)) {
					int distx = ex - p.x;
					int disty = ey - p.y;
					int a, b;
					if (disty == 0 || Math.abs(distx / disty) >= 1) {
						a = 1;
						b = 0;
					} else {
						a = 0;
						b = 1;
					}
					if (distx < 0)
						a = -a;
					if (disty < 0)
						b = -b;

					int c, d;
					if (disty == 0 || Math.abs(distx / disty) >= 1) {
						c = 0;
						d = 1;
					} else {
						c = 1;
						d = 0;
					}
					if (distx < 0)
						c = -c;
					if (disty < 0)
						d = -d;

					if (JudgeOffer(p, a, b)) {
						rt[p.x += a][p.y += b] = (p.t += 1);
						dir.x = a;
						dir.y = b;
						flg = true;
					} else if (JudgeOffer(p, c, d)) {
						rt[p.x += c][p.y += d] = +(p.t += 1);
						dir.x = c;
						dir.y = d;
						flg = true;
					} else if (JudgeOffer(p, dir.x, dir.y)) {
						rt[p.x += dir.x][p.y += dir.y] = +(p.t += 1);
						flg = true;
					} else if (JudgeOffer(p, b, a)) {
						rt[p.x += b][p.y += a] = +(p.t += 1);
						dir.x = b;
						dir.y = a;
						flg = true;
					} else if (JudgeOffer(p, -b, -a)) {
						rt[p.x -= b][p.y -= a] = +(p.t += 1);
						dir.x = -b;
						dir.y = -a;
						flg = true;
					} else if (JudgeOffer(p, -a, -b)) {
						rt[p.x -= a][p.y -= b] = +(p.t += 1);
						dir.x = -a;
						dir.y = -b;
						flg = true;
					}
					
					st.add(new XYT(p.x, p.y, p.t));
					if (!flg) {
						st.pop();
						p = st.pop();
					}
					flg = false;
					try {
						Thread.sleep(SleepTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					canvas.repaint();
				}
				canvas.repaint();

				if (st.isEmpty() && (p.x != ex || p.y != ey))
					JOptionPane.showMessageDialog(null, "There is no way to the destination!");
				else {
					Stack<XYT> stt = new Stack<XYT>();
					while (p.t != 1) {
						int distx = ex - p.x;
						int disty = ey - p.y;
						int a, b;
						if (disty == 0 || Math.abs(distx / disty) >= 1) {
							a = 1;
							b = 0;
						} else {
							a = 0;
							b = 1;
						}
						if (distx < 0)
							a = -a;
						if (disty < 0)
							b = -b;
						if (rt[p.x + a][p.y + b] < (p.t))
							stt.add(new XYT(p.x += a, p.y += b, p.t = rt[p.x][p.y]));
						else if (rt[p.x + b][p.y + a] < (p.t))
							stt.add(new XYT(p.x += b, p.y += a, p.t = rt[p.x][p.y]));
						else if (rt[p.x - b][p.y - a] < (p.t))
							stt.add(new XYT(p.x -= b, p.y -= a, p.t = rt[p.x][p.y]));
						else if (rt[p.x - a][p.y - b] < (p.t))
							stt.add(new XYT(p.x -= a, p.y -= b, p.t = rt[p.x][p.y]));
					}

					while (!stt.isEmpty()) {
						p = stt.pop();
						rt[p.x][p.y] = Window_Paint.PW + p.t;
						canvas.repaint();
						try {
							Thread.sleep(SleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(null, "The Shortest Path Is " + (p.t + 1) + ".");
				}
				System.out.println("Debug>> Greedy finished.");
			}
		}).start();
	}

	void AlgoAStar(RectCanvas canvas) {
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < x + 2; ++i)
					for (int j = 0; j < y + 2; ++j)
						rt[i][j] = 2147483647;
				canvas.repaint();
				
				
				
				
				
				System.out.println("Debug>> Dijkstra loop finished.");
				JOptionPane.showMessageDialog(null, "There is no algo here yet!");
				System.out.println("Debug>> Greedy finished.");
			}
		}).start();
	}

	private boolean JudgeOffer(XYT p, int xx, int yy) {
		xx += p.x;
		yy += p.y;
		if (rt[xx][yy] == 2147483647 && !vect[xx][yy])
			return true;
		return false;
	}

	void debugShow() {
		for (int i = 1; i <= x; ++i) {
			for (int j = 1; j <= y; ++j) {
				char c = (vect[i][j] ? '@' : '-');
				if (sx == i && sy == j)
					c = 'S';
				else if (ex == i && ey == j)
					c = 'E';
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}

	public class XYT {
		int x, y, t;

		XYT(int xx, int yy, int tt) {
			x = xx;
			y = yy;
			t = tt;
		}
	}

}
