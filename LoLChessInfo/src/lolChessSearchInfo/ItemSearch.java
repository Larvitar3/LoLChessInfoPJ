package lolChessSearchInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ItemSearch extends JFrame implements ActionListener{

	JButton nameBtn;
	JButton meteridlBtn;
	JButton effectBtn;
	
	public ItemSearch() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(810, 640);
		setTitle("아이템 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nameBtn = new JButton("Name");
		meteridlBtn =  new JButton("Meteridl");
		effectBtn = new JButton("Effect");
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		add(nameBtn);
		nameBtn.setSize(234, 40);
		nameBtn.setLocation(50, 220);
		
		add(meteridlBtn);
		meteridlBtn.setSize(234, 40);
		meteridlBtn.setLocation(284, 220);
		
		
		add(effectBtn);
		effectBtn.setSize(234, 40);
		effectBtn.setLocation(518, 220);
		
		
	}

	private void addEventListener() {
		nameBtn.addActionListener(this);
		meteridlBtn.addActionListener(this);
		effectBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nameBtn) {
			System.out.println("이름이 선택되었습니다.");
		} else if(e.getSource() == meteridlBtn) {
			System.out.println("재료가 선택되었습니다.");
		} else if (e.getSource() == effectBtn) {
			System.out.println("효과가 선택되었습니다.");
		}
		
	}
	public static void main(String[] args) {
		new ItemSearch();
	}

	
	
}
