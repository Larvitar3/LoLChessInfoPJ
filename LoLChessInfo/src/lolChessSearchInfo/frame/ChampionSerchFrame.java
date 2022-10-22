package lolChessSearchInfo.frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.dto.ResponseLine;
import lolChessSearchInfo.service.ChampionSearchService;

public class ChampionSerchFrame extends JFrame implements ActionListener {

	ChampionSearchService css;
	JLabel backgroundImg;

	JButton nameBtn;
	JButton lineBtn;
	JButton tribeBtn;
	JButton priceBtn;
	// Btn end

	JTextField searchBox;
	JButton searchBtn;
	// searchBox end

	JPanel bgBox;
	JLabel championImgBox;
	String imgAddress;
	JLabel cName;
	JLabel price;
	JLabel priceCoin;
	JLabel tribeName;
	JLabel tribeName2;
	JLabel hp;
	JLabel power;
	JLabel dps;
	JLabel attackRange;
	JLabel attackSpeed;
	JLabel defense;
	JLabel magicResistance;

	ImageIcon[] star = new ImageIcon[5];
	ImageIcon[] dragonHunter = new ImageIcon[4];

	public ChampionSerchFrame() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setSize(810, 640);
		setTitle("챔피언 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backgroundImg = new JLabel(new ImageIcon("Images/selectBg.jpg"));

		nameBtn = new JButton("NAME");
		lineBtn = new JButton("LINE");
		tribeBtn = new JButton("TRIBE");
		priceBtn = new JButton("PRICE");
		// Btn End

		searchBox = new JTextField();
		searchBtn = new JButton("검색");
		// searchBox end

		bgBox = new JPanel();

		// 데이터 연결 ▼
//		ImageIcon championImg = new ImageIcon(img);
		championImgBox = new JLabel();

		cName = new JLabel();
		price = new JLabel();
		tribeName = new JLabel();
		tribeName2 = new JLabel();
		hp = new JLabel();
		power = new JLabel();
		dps = new JLabel();
		attackRange = new JLabel();
		attackSpeed = new JLabel();
		defense = new JLabel();
		magicResistance = new JLabel();

		ImageIcon coinImg = new ImageIcon("Images/coin.png");
		priceCoin = new JLabel(coinImg);

		css = new ChampionSearchService();
	}

	void nameSearch(String searchName) {

		ResponseChampion rcCBN = css.selectChampionByName(searchName);

		if (rcCBN.getName() == null) {
			System.out.println("없는 챔피언 입니다.");
		} else {

			ImageIcon imageAddress = new ImageIcon(rcCBN.getImageAddress());
			championImgBox.setIcon(imageAddress);

			System.out.println(rcCBN.toString());

			imgAddress = rcCBN.getImageAddress();
			add(championImgBox);
			System.out.println(rcCBN.getImageAddress());

			bgBox.add(cName);

			cName.setText(rcCBN.getName());

			bgBox.add(price);
			price.setText("X " + rcCBN.getPrice());

			bgBox.add(tribeName);
			tribeName.setText(rcCBN.getTribeName());

			bgBox.add(tribeName2);
			tribeName2.setText("|      " + rcCBN.getTribeName2());

			bgBox.add(hp);
			hp.setText("체력  " + rcCBN.getHp());

			bgBox.add(power);
			power.setText("     |   공격력  " + rcCBN.getPower() + "     |  ");

			bgBox.add(dps);
			dps.setText("DPS   " + rcCBN.getDps());

			bgBox.add(attackRange);
			attackRange.setText("공격사거리   " + rcCBN.getAttackRange());

			bgBox.add(attackSpeed);
			attackSpeed.setText("|     공격속도   " + rcCBN.getAttackSpeed());

			bgBox.add(defense);
			defense.setText("방어력   " + rcCBN.getDefense());

			bgBox.add(magicResistance);
			magicResistance.setText("|     마법저항력   " + rcCBN.getMagicResistance());

			bgBox.add(priceCoin);

			add(bgBox);

			repaint();

		}
	}

	private void nameSelect() {

		System.out.println("네임이 시작됨미다");

		add(searchBox);
		add(searchBtn);

		repaint();
	}

	// end of nameSelect ============================

	void lineSearch(String searchLineName) {

		List<ResponseLine> resList = css.selectChampionByLine(searchLineName);

		bgBox.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));
		repaint();
		int tempCount = 2;
		for (ResponseLine data : resList) {

			JLabel imgJlabel = new JLabel(new ImageIcon(data.getChampImage()));
			bgBox.add(imgJlabel);
			imgJlabel.setSize(100, 100);
			imgJlabel.setLocation(50 * tempCount, 100);
			tempCount++;
			System.out.println("이미지 실행" + data.getChampImage());
			// imgJlabel.setLocation(0,0);
		}
		System.out.println("라인검색 실행");
		add(bgBox);
		repaint();

	}

	void lineSelect() {

		System.out.println("계열 검색이 시작됨미다");

		add(searchBox);
		add(searchBtn);

		repaint();
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		Color whiteOp = new Color(225, 225, 225, 150);
		setContentPane(backgroundImg);

		bgBox.setSize(704, 300);
		bgBox.setLocation(53, 260);
		bgBox.setBackground(whiteOp);

		add(nameBtn);
		nameBtn.setSize(176, 40);
		nameBtn.setLocation(53, 220);

		add(lineBtn);
		lineBtn.setSize(176, 40);
		lineBtn.setLocation(229, 220);

		add(tribeBtn);
		tribeBtn.setSize(176, 40);
		tribeBtn.setLocation(405, 220);

		add(priceBtn);
		priceBtn.setSize(176, 40);
		priceBtn.setLocation(581, 220);

		searchBox.setSize(480, 35);
		searchBox.setLocation(130, 300);

		searchBtn.setSize(70, 35);
		searchBtn.setLocation(610, 300);

		championImgBox.setSize(120, 120);
		championImgBox.setLocation(130, 370);

		cName.setSize(120, 20);
		cName.setFont(new Font("sanSerif", Font.BOLD, 16));
		cName.setLocation(105, 240);

		tribeName.setSize(200, 25);
		tribeName.setFont(new Font("sanSerif", Font.BOLD, 18));
		tribeName.setLocation(225, 105);

		tribeName2.setSize(200, 25);
		tribeName2.setFont(new Font("sanSerif", Font.BOLD, 18));
		tribeName2.setLocation(325, 105);

		hp.setSize(100, 25);
		hp.setFont(new Font("sanSerif", Font.BOLD, 18));
		hp.setLocation(225, 140);

		power.setSize(180, 25);
		power.setFont(new Font("sanSerif", Font.BOLD, 18));
		power.setLocation(300, 140);

		dps.setSize(100, 25);
		dps.setFont(new Font("sanSerif", Font.BOLD, 18));
		dps.setLocation(475, 140);

		attackRange.setSize(200, 25);
		attackRange.setFont(new Font("sanSerif", Font.BOLD, 18));
		attackRange.setLocation(225, 180);

		attackSpeed.setSize(200, 25);
		attackSpeed.setFont(new Font("sanSerif", Font.BOLD, 18));
		attackSpeed.setLocation(425, 180);

		defense.setSize(200, 25);
		defense.setFont(new Font("sanSerif", Font.BOLD, 18));
		defense.setLocation(225, 220);

		magicResistance.setSize(200, 25);
		magicResistance.setFont(new Font("sanSerif", Font.BOLD, 18));
		magicResistance.setLocation(345, 220);

		price.setSize(150, 35);
		price.setFont(new Font("sanSerif", Font.BOLD, 20));
		price.setLocation(650, 250);

		priceCoin.setSize(50, 40);
		priceCoin.setLocation(600, 245);

	}

	private void addEventListener() {
		nameBtn.addActionListener(this);
		lineBtn.addActionListener(this);
		tribeBtn.addActionListener(this);
		priceBtn.addActionListener(this);
		searchBtn.addActionListener(this);

	}

	int isBtnType;
	final int NAME_SEARCH_BTN = 1;
	final int LINE_SEARCH_BTN = 2;
	final int TRIBE_SEARCH_BTN = 3;
	final int PRICE_SEARCH_BTN = 4;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == nameBtn) {
			System.out.println("이름이 선택되었습니다.");
			nameSelect();
			isBtnType = NAME_SEARCH_BTN;
		} else if (e.getSource() == lineBtn) {
			lineSelect();
			System.out.println("계열이 선택되었습니다.");
			isBtnType = LINE_SEARCH_BTN;
		} else if (e.getSource() == tribeBtn) {
			System.out.println("종족이 선택되었습니다.");
			isBtnType = TRIBE_SEARCH_BTN;
		} else if (e.getSource() == priceBtn) {
			System.out.println("비용이 선택되었습니다.");
			isBtnType = PRICE_SEARCH_BTN;
		} else if (e.getSource() == searchBtn) {
			System.out.println("검색버튼 타입" + isBtnType);
			actionType(isBtnType);
		} else {
			System.out.println("선택되지않았습니다.");
		}

	}

	private void actionType(int isBtnType) {

		if (isBtnType == NAME_SEARCH_BTN) {
			nameSearch(searchBox.getText().trim());

		} else if (isBtnType == LINE_SEARCH_BTN) {
			System.out.println("라인 검색");
			lineSearch(searchBox.getText().trim());
			bgBox.removeAll();
			repaint();
		} else if (isBtnType == TRIBE_SEARCH_BTN) {
			System.out.println("종족 검색");
			lineSearch(searchBox.getText().trim());
		} else if (isBtnType == PRICE_SEARCH_BTN) {
			System.out.println("비용 검색");
			lineSearch(searchBox.getText().trim());
		} else {
			System.out.println("선택되지않았습니다.");
		}

	}

	public static void main(String[] args) {
		ChampionSerchFrame cf = new ChampionSerchFrame();

	}

}
