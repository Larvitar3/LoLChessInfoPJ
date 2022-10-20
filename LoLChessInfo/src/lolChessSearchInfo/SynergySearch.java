package lolChessSearchInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SynergySearch extends JFrame implements ActionListener{

	JButton lineBtn;
	JButton tribeBtn;
	JButton effectBtn;
	
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
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
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
