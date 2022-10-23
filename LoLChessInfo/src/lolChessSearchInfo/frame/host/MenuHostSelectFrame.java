package lolChessSearchInfo.frame.host;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import lombok.Data;
import lombok.Getter;

public class MenuHostSelectFrame extends JFrame implements ActionListener {

    private JLabel backgroundImg;
    private JButton champion;
    private JButton item;

    private JTextField name;
    private JTextField tribe;
    private JTextField line;
    private JTextField price;
    private JButton host;
    
    

	public MenuHostSelectFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(810, 640);
		setTitle("관리자 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backgroundImg = new JLabel(new ImageIcon("Images/subBg.jpg"));
		champion = new JButton("CHAMPION");
		item = new JButton("ITEM");
		name = new JTextField("NAME");
		tribe = new JTextField("TRIBE");
		line = new JTextField("LINE");
		price = new JTextField("PRICE");
		host = new JButton("HOST");

	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setContentPane(backgroundImg);

		add(champion);
		champion.setSize(200, 50);
		champion.setLocation(190, 200);

		add(item);
		item.setSize(200, 50);
		item.setLocation(420, 200);

		add(name);
		name.setSize(200, 30);
		name.setLocation(170, 300);

		add(tribe);
		tribe.setSize(200, 30);
		tribe.setLocation(440, 300);

		add(line);
		line.setSize(200, 30);
		line.setLocation(170, 400);

		add(price);
		price.setSize(200, 30);
		price.setLocation(440, 400);

		add(host);
		host.setSize(100, 40);
		host.setLocation(650, 530);
	}

	private void addEventListener() {
		champion.addActionListener(this);
		item.addActionListener(this);
		name.addActionListener(this);
		tribe.addActionListener(this);
		line.addActionListener(this);
		price.addActionListener(this);
		host.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == champion) {
			System.out.println("챔피온버튼");
		} else if (e.getSource() == item) {
			System.out.println("아이테번튼.");
		} else if (e.getSource() == host) {
			System.out.println("host");
			host.setText("???");
		}
	}

	public static void main(String[] args) {
		new MenuHostSelectFrame();
	}

}
