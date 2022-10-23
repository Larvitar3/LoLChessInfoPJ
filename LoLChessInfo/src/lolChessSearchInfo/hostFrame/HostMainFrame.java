package lolChessSearchInfo.hostFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lolChessSearchInfo.dto.ResponseChampion;

public class HostMainFrame extends JFrame implements ActionListener {
	
	private JLabel backgroundImg;
	private JButton insert;
	private JButton delete;
	private JButton update;
	private JButton hostButton; 

	public HostMainFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(810, 640);
		setTitle("롤체 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backgroundImg = new JLabel(new ImageIcon("Images/menuBackground.jpg"));
		insert = new JButton("INSERT");
		delete = new JButton("DELETE");
		update = new JButton("UPDATE");
		hostButton = new JButton("관리자1"); // 승원
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setContentPane(backgroundImg);

		add(insert);
		insert.setSize(328, 52);
		insert.setLocation(230, 328);

		add(delete);
		delete.setSize(328, 52);
		delete.setLocation(230, 400);

		add(update);
		update.setSize(328, 52);
		update.setLocation(230, 472);

		add(hostButton);
		hostButton.setSize(100, 40);
		hostButton.setLocation(650, 530);
	}

	private void addEventListener() {
		insert.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
		hostButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//JButton targetButton = (JButton)e.getSource();

		if (e.getSource() == insert) {
			System.out.println("인설트x버튼.");
			new HostSelectFrame();
			this.setVisible(false);
		} else if (e.getSource() == delete) {
			System.out.println("딜리트버튼.");
			new HostSelectFrame();
			this.setVisible(false);
		} else if (e.getSource() == update) {
			System.out.println("업데이트버튼.");
			new HostSelectFrame();
			this.setVisible(false);
		} else if (e.getSource() == hostButton) {
			System.out.println("관리자실행되었습니다");
			new HostSelectFrame();
			this.setVisible(false);
			
		}
	}

	public static void main(String[] args) {
		new HostMainFrame();
	}

}
