package lolChessSearchInfo;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SynergySearch extends JFrame implements ActionListener{

	JButton lineBtn;
	JButton tribeBtn;
	JButton effectBtn;
	JLabel test;
	
	public SynergySearch() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setSize(810, 640);
		setTitle("아이템 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lineBtn = new JButton("Line");
		tribeBtn =  new JButton("Tribe");
		effectBtn = new JButton("Effect");
		
		ImageIcon testImage = new ImageIcon("C:\\LoLChessPJ\\Images\\Bard.png");
		test = new JLabel(testImage);
		
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		add(test);
		test.setSize(200,200);
		test.setLocation(0,0);
		
		add(lineBtn);
		lineBtn.setSize(234, 40);
		lineBtn.setLocation(50, 220);

		
		add(tribeBtn);
		tribeBtn.setSize(234, 40);
		tribeBtn.setLocation(284, 220);
		
		
		add(effectBtn);
		effectBtn.setSize(234, 40);
		effectBtn.setLocation(518, 220);
	}
	
	

	
	// C:\\LoLChessPJ\\Images\\Bard.png
	

	private void addEventListener() {
		lineBtn.addActionListener(this);
		tribeBtn.addActionListener(this);
		effectBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == lineBtn) {
			System.out.println("계열이 선택되었습니다.");
		} else if(e.getSource() == tribeBtn) {
			System.out.println("종족이 선택되었습니다.");
		} else if (e.getSource() == effectBtn) {
			System.out.println("효과가 선택되었습니다.");
		}
		
	}
	
	public static void main(String[] args) {
		new SynergySearch();
	}
	
}
