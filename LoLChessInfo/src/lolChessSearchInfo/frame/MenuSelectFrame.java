package lolChessSearchInfo.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lolChessSearchInfo.dto.ResponseChampion;

public class MenuSelectFrame extends JFrame implements ActionListener{

	JLabel backgroundImg;
	JButton championSearch;
	JButton itemSearch;
	JButton synergySearch;
	
	public MenuSelectFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(810, 640);
		setTitle("롤체 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		backgroundImg = new JLabel(new ImageIcon("Images/menuBackground.jpg"));
		championSearch = new JButton("챔피언 검색");
		itemSearch = new JButton("아이템 검색");
		synergySearch = new JButton("시너지 검색");
		
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setContentPane(backgroundImg);
		
		
		add(championSearch);
		championSearch.setSize(328, 52);
		championSearch.setLocation(230, 328);
		
		add(itemSearch);
		itemSearch.setSize(328, 52);
		itemSearch.setLocation(230, 400);
		
		add(synergySearch);
		synergySearch.setSize(328, 52);
		synergySearch.setLocation(230, 472);
		
		
	}

	private void addEventListener() {
		championSearch.addActionListener(this);
		itemSearch.addActionListener(this);
		synergySearch.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == championSearch) {
			System.out.println("챔피온 검색이 선택되었습니다.");
		}else if(e.getSource() == itemSearch) {
			System.out.println("아이템 검색이 선택되었습니다.");
		}else if(e.getSource() == synergySearch) {
			System.out.println("시너지 검색이 선택되었습니다.");
		}
		
	}
	
	public static void main(String[] args) {
		new MenuSelectFrame();
	}

	


	
}
