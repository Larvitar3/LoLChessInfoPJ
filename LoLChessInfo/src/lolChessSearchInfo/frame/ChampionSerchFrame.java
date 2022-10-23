package lolChessSearchInfo.frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	// championBox end

	JPanel championBgBox;
	JPanel lineBgBox;
	JPanel tribeBgBox;
	JPanel priceBgBox;

	JPanel flowBox;

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

		championBgBox = new JPanel();
		lineBgBox = new JPanel();
		flowBox = new JPanel();
		tribeBgBox = new JPanel();
		priceBgBox = new JPanel();

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

			add(championImgBox);

			championBgBox.add(cName);

			cName.setText(rcCBN.getName());

			championBgBox.add(price);
			price.setText("X " + rcCBN.getPrice());

			championBgBox.add(tribeName);
			tribeName.setText(rcCBN.getTribeName());

			if (rcCBN.getTribeName2() != null) {
				championBgBox.add(tribeName2);
				tribeName2.setText("|      " + rcCBN.getTribeName2());
			}

			championBgBox.add(hp);
			hp.setText("체력  " + rcCBN.getHp());

			championBgBox.add(power);
			power.setText("     |   공격력  " + rcCBN.getPower() + "     |  ");

			championBgBox.add(dps);
			dps.setText("DPS   " + rcCBN.getDps());

			championBgBox.add(attackRange);
			attackRange.setText("공격사거리   " + rcCBN.getAttackRange());

			championBgBox.add(attackSpeed);
			attackSpeed.setText("|     공격속도   " + rcCBN.getAttackSpeed());

			championBgBox.add(defense);
			defense.setText("방어력   " + rcCBN.getDefense());

			championBgBox.add(magicResistance);
			magicResistance.setText("|     마법저항력   " + rcCBN.getMagicResistance());

			championBgBox.add(priceCoin);

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

			add(championBgBox);

			repaint();

		}
	}

	private void nameSelect() {

		add(searchBox);
		add(searchBtn);

		repaint();
	}
	// end of nameSelect ============================

	void lineSearch(String searchLineName) {

		List<ResponseLine> resList = css.selectChampionByLine(searchLineName);

		lineBgBox.add(flowBox);
		flowBox.setSize(704, 200);
		flowBox.setLocation(53, 370);
		flowBox.setLayout(null);

		int witdhMarginPlus = 0;
		int witdhMarginTextPlus = 0;
		boolean imgFlag = true;
		boolean textFlag = true;

		for (ResponseLine data : resList) {

			JLabel imgJlabel = new JLabel(new ImageIcon(data.getChampImage()));
			flowBox.add(imgJlabel);
			imgJlabel.setSize(80, 80);

			if (imgFlag) {
				imgJlabel.setLocation(50, 0);
				System.out.println("가로길이실행중");
				witdhMarginPlus = 150;

			} else {
				imgJlabel.setLocation((20 + witdhMarginPlus), 0);
				witdhMarginPlus += 130;
				int countNum = 20 + witdhMarginPlus;
				System.out.println("마진 실행중  :    " + countNum);
				if (countNum > 694) {
					imgJlabel.setLocation(50, 150);
				}

			}

			imgFlag = false;
			System.out.println("이미지 실행" + data.getChampImage());

		} // 라인 검색 이미지박스 end


		for (ResponseLine data : resList) {

			JLabel titleJlabel = new JLabel(data.getChampName());
			flowBox.add(titleJlabel);
			titleJlabel.setSize(80, 20);
			titleJlabel.setFont(new Font("sanSerif", Font.BOLD, 13));
			titleJlabel.setHorizontalAlignment(JLabel.CENTER);

			if (textFlag) {
				titleJlabel.setLocation(50, 90);
				System.out.println("가로길이실행중");
				witdhMarginTextPlus = 150;

			} else {
				titleJlabel.setLocation((20 + witdhMarginTextPlus), 90);
				witdhMarginTextPlus += 130;
				int countNum = 20 + witdhMarginTextPlus;
				System.out.println("마진 실행중  :    " + countNum);
				if (countNum > 694) {
					titleJlabel.setLocation(50, 150);
				}

			}

			textFlag = false;
			System.out.println("텍스트 실행 : " + data.getChampName());

		} // 라인 검색 텍스트 end

		add(flowBox);
		add(lineBgBox);
		repaint();

	}

	void lineSelect() {

		add(searchBox);
		add(searchBtn);

		repaint();
	}

	void tribeSearch(String searchTribeName) {

		List<ResponseChampion> resList = css.selectChampionBytribe(searchTribeName);

		tribeBgBox.add(flowBox);
		flowBox.setSize(704, 200);
		flowBox.setLocation(53, 370);
		flowBox.setLayout(null);

		int witdhMarginPlus = 0;
		int witdhMarginTextPlus = 0;
		boolean imgFlag = true;
		boolean textFlag = true;

		for (ResponseChampion data : resList) {

			JLabel imgJlabel = new JLabel(new ImageIcon(data.getImageAddress()));
			flowBox.add(imgJlabel);
			imgJlabel.setSize(80, 80);

			if (imgFlag) {
				imgJlabel.setLocation(50, 0);
				witdhMarginPlus = 150;

			} else {
				imgJlabel.setLocation((20 + witdhMarginPlus), 0);
				witdhMarginPlus += 130;
				int countNum = 20 + witdhMarginPlus;
				System.out.println("마진 실행중  :    " + countNum);
				if (countNum > 694) {
					imgJlabel.setLocation(50, 150);
				}

			}

			imgFlag = false;
			System.out.println(" 종족 이미지 실행  " + data.getImageAddress());

		} // 종족 검색 이미지박스 end


		for (ResponseChampion data : resList) {

			JLabel titleJlabel = new JLabel(data.getName());
			flowBox.add(titleJlabel);
			titleJlabel.setSize(80, 20);
			titleJlabel.setFont(new Font("sanSerif", Font.BOLD, 13));
			titleJlabel.setHorizontalAlignment(JLabel.CENTER);

			if (textFlag) {
				titleJlabel.setLocation(50, 90);
				witdhMarginTextPlus = 150;

			} else {
				titleJlabel.setLocation((20 + witdhMarginTextPlus), 90);
				witdhMarginTextPlus += 130;
				int countNum = 20 + witdhMarginTextPlus;
				System.out.println("마진 실행중  :    " + countNum);
				if (countNum > 694) {
					titleJlabel.setLocation(50, 150);
				}

			}

			textFlag = false;
			System.out.println("텍스트 실행 : " + data.getName());

		} // 종족 검색 텍스트 end

		add(flowBox);
		add(tribeBgBox);
		repaint();

	}

	void tribeSelect() {

		add(searchBox);
		add(searchBtn);

		repaint();
	}

	void priceSearch(String searchPrice) {

		List<ResponseChampion> resList = css.selectChampionByPrice(searchPrice);

		priceBgBox.add(flowBox);
		flowBox.setSize(704, 200);
		flowBox.setLocation(53, 370);
		flowBox.setLayout(new FlowLayout());

		int witdhMarginPlus = 0;
		int witdhMarginTextPlus = 0;
		boolean imgFlag = true;
		boolean textFlag = true;

		for (ResponseChampion data : resList) {

			JLabel imgJlabel = new JLabel(new ImageIcon(data.getImageAddress()));
			flowBox.add(imgJlabel);
			imgJlabel.setSize(80, 80);

			if (imgFlag) {
				imgJlabel.setLocation(50, 0);
				witdhMarginPlus = 150;

			} else {
				imgJlabel.setLocation((20 + witdhMarginPlus), 0);
				witdhMarginPlus += 130;
				int countNum = 20 + witdhMarginPlus;
				System.out.println("마진 실행중  :    " + countNum);
				if (countNum > 694) {
					imgJlabel.setLocation(50, 150);
				}

			}

			imgFlag = false;
			System.out.println(" 종족 이미지 실행  " + data.getImageAddress());

		} // 비용 검색 이미지박스 end


		for (ResponseChampion data : resList) {

			JLabel titleJlabel = new JLabel(data.getName());
			flowBox.add(titleJlabel);
			titleJlabel.setSize(80, 20);
			titleJlabel.setFont(new Font("sanSerif", Font.BOLD, 13));
			titleJlabel.setHorizontalAlignment(JLabel.CENTER);

			if (textFlag) {
				titleJlabel.setLocation(50, 90);
				witdhMarginTextPlus = 150;

			} else {
				titleJlabel.setLocation((20 + witdhMarginTextPlus), 90);
				witdhMarginTextPlus += 130;
				int countNum = 20 + witdhMarginTextPlus;
				if (countNum > 694) {
					titleJlabel.setLocation(50, 150);
				}

			}

			textFlag = false;

		} // 비용 검색 텍스트 end

		add(flowBox);
		add(priceBgBox);
		repaint();

	}

	void priceSelect() {

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
		Color whiteOp100 = new Color(225, 225, 225, 0);
		setContentPane(backgroundImg);

		championBgBox.setSize(704, 300);
		championBgBox.setLocation(53, 260);
		championBgBox.setBackground(whiteOp);

		lineBgBox.setSize(704, 300);
		lineBgBox.setLocation(53, 260);
		lineBgBox.setBackground(whiteOp);
		lineBgBox.setLayout(null);

		tribeBgBox.setSize(704, 300);
		tribeBgBox.setLocation(53, 260);
		tribeBgBox.setBackground(whiteOp);
		tribeBgBox.setLayout(null);

		priceBgBox.setSize(704, 300);
		priceBgBox.setLocation(53, 260);
		priceBgBox.setBackground(whiteOp);
		priceBgBox.setLayout(null);

		flowBox.setBackground(whiteOp100);

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
			nameSelect();
			isBtnType = NAME_SEARCH_BTN;
			
			lineBgBox.removeAll();
			tribeBgBox.removeAll();
			priceBgBox.removeAll();
			repaint();
		} else if (e.getSource() == lineBtn) {
			lineSelect();
			isBtnType = LINE_SEARCH_BTN;
			championBgBox.removeAll();
			tribeBgBox.removeAll();
			priceBgBox.removeAll();
			repaint();
		} else if (e.getSource() == tribeBtn) {
			tribeSelect();
			isBtnType = TRIBE_SEARCH_BTN;
			lineBgBox.removeAll();
			championBgBox.removeAll();
			priceBgBox.removeAll();
			repaint();
		} else if (e.getSource() == priceBtn) {
			priceSelect();
			isBtnType = PRICE_SEARCH_BTN;
			lineBgBox.removeAll();
			championBgBox.removeAll();
			tribeBgBox.removeAll();
		} else if (e.getSource() == searchBtn) {
			actionType(isBtnType);
		} else {
			System.out.println("미선택");
		}

	}

	private void actionType(int isBtnType) {

		if (isBtnType == NAME_SEARCH_BTN) {
			nameSearch(searchBox.getText().trim());

		} else if (isBtnType == LINE_SEARCH_BTN) {
			System.out.println("라인 검색");
			lineSearch(searchBox.getText().trim());

		} else if (isBtnType == TRIBE_SEARCH_BTN) {
			System.out.println("종족 검색");
			tribeSearch(searchBox.getText().trim());

		} else if (isBtnType == PRICE_SEARCH_BTN) {
			System.out.println("비용 검색");
			priceSearch(searchBox.getText().trim());

		} else {
			System.out.println("선택되지않았습니다.");
		}

	}

	public static void main(String[] args) {
		ChampionSerchFrame cf = new ChampionSerchFrame();

	}

}
