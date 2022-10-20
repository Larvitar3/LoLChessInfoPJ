package lolChessSearchInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChampionSerch extends JFrame implements ActionListener{

	JButton nameBtn;
	JButton lineBtn;
	JButton tribeBtn;
	JButton priceBtn;
	
	public ChampionSerch() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(810, 640);
		setTitle("챔피언 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nameBtn = new JButton("NAME");
		lineBtn = new JButton("LINE");
		tribeBtn = new JButton("TRIBE");
		priceBtn = new JButton("PRICE");
		
		
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		add(nameBtn);
		nameBtn.setSize(176, 40);
		nameBtn.setLocation(50, 220);
		
		add(lineBtn);
		lineBtn.setSize(176, 40);
		lineBtn.setLocation(226, 220);
		
		add(tribeBtn);
		tribeBtn.setSize(176, 40);
		tribeBtn.setLocation(402, 220);
		
		add(priceBtn);
		priceBtn.setSize(176, 40);
		priceBtn.setLocation(578, 220);
		
		
	}

	private void addEventListener() {
		nameBtn.addActionListener(this);
		lineBtn.addActionListener(this);
		tribeBtn.addActionListener(this);
		priceBtn.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == nameBtn) {
			System.out.println("이름이 선택되었습니다.");
		}else if(e.getSource() == lineBtn) {
			System.out.println("계열이 선택되었습니다.");
		}else if (e.getSource() == tribeBtn) {
			System.out.println("종족이 선택되었습니다.");
		}else if(e.getSource() == priceBtn) {
			System.out.println("비용이 선택되었습니다.");
		}
		
	}
	public static void main(String[] args) {
		new ChampionSerch();
	}
	
}
