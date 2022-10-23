package lolChessSearchInfo.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lolChessSearchInfo.dto.ResponseItem;
import lolChessSearchInfo.service.ItemSearchService;

public class ItemSearchFrame extends JFrame implements ActionListener {

	ItemSearchService iss;   
	JLabel backgroundImg;

	JTextField searchBox;
	JButton searchBtn;

	JLabel itemImgBox;
	String imgAddress;
	JLabel itemName;
	JLabel plusIcon;
	JLabel mtd1Img;
	JLabel mtd2Img;
	JLabel mtd1Name;
	JLabel mtd2Name;
	
	JLabel mtdCollabo;

	JLabel border;
	
	JTextArea itemEffectText;

	JButton nameBtn;
	JButton meteridlBtn;
	JButton effectBtn;

	JPanel nameBgBox;
	JPanel meteridlBgBox;
	JPanel effectBgBox;
	JPanel flowBox;
	

	Color whiteOp = new Color(225, 225, 225, 150);
	Color whiteOp100 = new Color(225, 225, 225, 0);

	public ItemSearchFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(810, 640);
		setTitle("아이템 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backgroundImg = new JLabel(new ImageIcon("Images/itemBg.jpg"));

		nameBtn = new JButton("Name");
		effectBtn = new JButton("Effect");
		meteridlBtn = new JButton("Meteridl");

		itemImgBox = new JLabel();

		itemName = new JLabel();
		plusIcon = new JLabel("+");

		mtd1Img = new JLabel();

		mtd2Img = new JLabel();

		mtd1Name = new JLabel();
		mtd2Name = new JLabel();
		itemEffectText = new JTextArea();

		searchBox = new JTextField();
		searchBtn = new JButton("검색");
		// searchBox end

		nameBgBox = new JPanel();
		effectBgBox = new JPanel();
		meteridlBgBox = new JPanel();
		flowBox = new JPanel();
		
		mtdCollabo = new JLabel("조합 가능 아이템 ▼");

		border = new JLabel();
		
		iss = new ItemSearchService();
		

	}

	void nameSearch(String searchItemName) {

		ResponseItem rpi = iss.selectItemByName(searchItemName);

		nameBgBox.setSize(702, 300);
		nameBgBox.setLocation(50, 260);
		nameBgBox.setBackground(whiteOp);
		nameBgBox.setLayout(null);
		
		System.out.println(rpi.getImageAddress());

		ImageIcon imageAddress = new ImageIcon(rpi.getImageAddress());
		itemImgBox.setIcon(imageAddress);

		add(itemImgBox);

		itemImgBox.setSize(120, 120);
		itemImgBox.setLocation(130, 370);

		nameBgBox.add(itemName);
		itemName.setText(rpi.getName());

		itemName.setSize(120, 20);
		itemName.setFont(new Font("sanSerif", Font.BOLD, 16));
		itemName.setLocation(80, 240);
		itemName.setHorizontalAlignment(JLabel.CENTER);

		nameBgBox.add(plusIcon);
		plusIcon.setSize(80, 120);
		plusIcon.setFont(new Font("sanSerif", Font.BOLD, 70));
		plusIcon.setLocation(400, 80);

		nameBgBox.add(mtd1Img);
		mtd1Img.setSize(80, 80);
		mtd1Img.setLocation(300, 110);

		ImageIcon imageAddress1 = new ImageIcon(rpi.getMtd1imgAddress());
		mtd1Img.setIcon(imageAddress1);

		nameBgBox.add(mtd2Img);
		mtd2Img.setSize(80, 80);
		mtd2Img.setLocation(460, 110);

		ImageIcon imageAddress2 = new ImageIcon(rpi.getMtd2imgAddress());
		mtd2Img.setIcon(imageAddress2);

		nameBgBox.add(mtd1Name);
		mtd1Name.setSize(80, 20);
		mtd1Name.setText(rpi.getMaterialName1());
		mtd1Name.setFont(new Font("sanSerif", Font.BOLD, 14));
		mtd1Name.setLocation(300, 200);
		mtd1Name.setHorizontalAlignment(JLabel.CENTER);

		nameBgBox.add(mtd2Name);
		mtd2Name.setSize(80, 20);
		mtd2Name.setText(rpi.getMaterialName2());
		mtd2Name.setFont(new Font("sanSerif", Font.BOLD, 14));
		mtd2Name.setLocation(460, 200);
		mtd2Name.setHorizontalAlignment(JLabel.CENTER);

		nameBgBox.add(itemEffectText);
		itemEffectText.setSize(400, 60);
		itemEffectText.setFont(new Font("sanSerif", Font.BOLD, 14));
		itemEffectText.setLocation(220, 230);
		itemEffectText.setLineWrap(true);
		itemEffectText.setWrapStyleWord(true);
		itemEffectText.setEditable(false);
		itemEffectText.setText(rpi.getItemEffect());

		add(itemImgBox);
		add(nameBgBox);

		repaint();
	}

	private void nameSelect() {

		add(searchBox);
		add(searchBtn);

		repaint();
	}
	// end of nameSelect ============================

	void effectSearch(String searchEffectName) {

		List<ResponseItem> itemList = iss.selectItemByEffect(searchEffectName);

		effectBgBox.setSize(702, 300);
		effectBgBox.setLocation(50, 260);
		effectBgBox.setBackground(whiteOp);
		effectBgBox.setLayout(null);
		
		effectBgBox.add(flowBox);
		flowBox.setSize(702, 200);
		flowBox.setLocation(50, 370);
		flowBox.setLayout(null);

		int witdhMarginPlus = 0;
		int witdhMarginTextPlus = 0;
		boolean imgFlag = true;
		boolean textFlag = true;

		for (ResponseItem data : itemList) {
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
				if (countNum > 694) {
					imgJlabel.setLocation(50, 150);
				}

			}

			imgFlag = false;

		} // 효과 검색 이미지박스 end

		for (ResponseItem data : itemList) {
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

		} // 효과 검색 텍스트 end

		add(flowBox);
		add(effectBgBox);
		repaint();
	}

	private void effectSelect() {

		add(searchBox);
		add(searchBtn);

		repaint();
	}
	// end of effectSelect ============================

	void meteridlSearch(String searchMeteridlName) {
		
		List<ResponseItem> metList = iss.selectItemByMaterial(searchMeteridlName);

		meteridlBgBox.setSize(702, 300);
		meteridlBgBox.setLocation(50, 260);
		meteridlBgBox.setBackground(whiteOp);
		meteridlBgBox.setLayout(null);
		
		meteridlBgBox.add(flowBox);
		flowBox.setSize(702, 200);
		flowBox.setLocation(50, 370);
		flowBox.setLayout(null);
		
		
		JLabel mtdImg = new JLabel(new ImageIcon(metList.get(1).getMtd1imgAddress()));
		flowBox.add(mtdImg);
		mtdImg.setSize(80, 80);
		mtdImg.setLocation(50, 30);
		
		JLabel mtdName = new JLabel(metList.get(1).getMaterialName1());
		flowBox.add(mtdName);
		mtdName.setSize(80, 20);
		mtdName.setLocation(50, 110);
		mtdName.setFont(new Font("sanSerif", Font.BOLD, 14));
		mtdName.setHorizontalAlignment(JLabel.CENTER);
				
		int witdhMarginPlus = 0;
		int witdhMarginTextPlus = 0;
		boolean imgFlag = true;
		boolean textFlag = true;
		
		for (ResponseItem data : metList) {

			JLabel imgJlabel = new JLabel(new ImageIcon(data.getImageAddress()));
			flowBox.add(imgJlabel);
			imgJlabel.setSize(70, 70);

			if (imgFlag) {
				imgJlabel.setLocation(180, 30);
				witdhMarginPlus = 280;

			} else {
				imgJlabel.setLocation((20 + witdhMarginPlus), 30);
				witdhMarginPlus += 120;
				int countNum = 20 + witdhMarginPlus;
				if (countNum > 694) {
					imgJlabel.setLocation(50, 150);
				}

			}

			imgFlag = false;

		} // 아이템 이미지박스 end
		
		for (ResponseItem data : metList) {

			JLabel titleJlabel = new JLabel(data.getName());
			flowBox.add(titleJlabel);
			titleJlabel.setSize(70, 20);
			titleJlabel.setFont(new Font("sanSerif", Font.BOLD, 13));
			titleJlabel.setHorizontalAlignment(JLabel.CENTER);

			if (textFlag) {
				titleJlabel.setLocation(180, 100);
				witdhMarginTextPlus = 280;

			} else {
				titleJlabel.setLocation((20 + witdhMarginTextPlus), 100);
				witdhMarginTextPlus += 120;
				int countNum = 20 + witdhMarginTextPlus;
				if (countNum > 694) {
					titleJlabel.setLocation(50, 150);
				}

			}

			textFlag = false;

		} // 아이템 텍스트 end
		
		JLabel eftImg = new JLabel("재료 효과   |   " + metList.get(1).getMaterialEffect1());
		flowBox.add(eftImg);
		eftImg.setSize(500, 50);
		eftImg.setLocation(100, 130);
		eftImg.setFont(new Font("sanSerif", Font.BOLD, 20));
		eftImg.setHorizontalAlignment(JLabel.CENTER);

		add(mtdCollabo);
		mtdCollabo.setSize(200, 20);
		mtdCollabo.setLocation(160, 350);
		mtdCollabo.setFont(new Font("sanSerif", Font.BOLD, 12));
		mtdCollabo.setHorizontalAlignment(JLabel.CENTER);
		


		border.setSize(480, 120);
		border.setLocation(205, 380);
		border.setBorder(new TitledBorder(new LineBorder(Color.black)));
		border.setOpaque(true);
		border.setBackground(Color.white);



		add(flowBox);
		add(border);
		add(meteridlBgBox);
		repaint();

	}

	private void meteridlSelect() {

		add(searchBox);
		add(searchBtn);

		repaint();
	}
	// end of meteridlSelect ============================

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		setContentPane(backgroundImg);

		flowBox.setBackground(whiteOp100);

		add(nameBtn);
		nameBtn.setSize(234, 40);
		nameBtn.setLocation(50, 220);

		add(effectBtn);
		effectBtn.setSize(234, 40);
		effectBtn.setLocation(284, 220);

		add(meteridlBtn);
		meteridlBtn.setSize(234, 40);
		meteridlBtn.setLocation(518, 220);

		itemEffectText.setOpaque(true);
		itemEffectText.setBackground(whiteOp100);

		searchBox.setSize(480, 35);
		searchBox.setLocation(130, 300);

		searchBtn.setSize(70, 35);
		searchBtn.setLocation(610, 300);

	}

	private void addEventListener() {
		nameBtn.addActionListener(this);
		effectBtn.addActionListener(this);
		meteridlBtn.addActionListener(this);
		searchBtn.addActionListener(this);
	}

	int isBtnType;
	final int NAME_SEARCH_BTN = 1;
	final int EFFECT_SEARCH_BTN = 2;
	final int METERIDL_SEARCH_BTN = 3;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nameBtn) {
			nameSelect();
			isBtnType = NAME_SEARCH_BTN;
			effectBgBox.removeAll();
			meteridlBgBox.removeAll();
			flowBox.removeAll();
			remove(effectBgBox);
			remove(meteridlBgBox);
			remove(border);
			remove(mtdCollabo);
			
		} else if (e.getSource() == effectBtn) {
			effectSelect();
			isBtnType = EFFECT_SEARCH_BTN;
			nameBgBox.removeAll();
			meteridlBgBox.removeAll();
			flowBox.removeAll();
			remove(nameBgBox);
			remove(meteridlBgBox);
			remove(border);
			remove(mtdCollabo);
			remove(itemImgBox);

		} else if (e.getSource() == meteridlBtn) {
			meteridlSelect();
			isBtnType = METERIDL_SEARCH_BTN;
			
			nameBgBox.removeAll();
			effectBgBox.removeAll();
			flowBox.removeAll();
			remove(nameBgBox);
			remove(effectBgBox);
			remove(itemImgBox);

		} else if (e.getSource() == searchBtn) {
			actionType(isBtnType);
		} else {
			System.out.println("미선택");
		}

	}

	private void actionType(int isBtnType) {

		if (isBtnType == NAME_SEARCH_BTN) {
			nameSearch(searchBox.getText().trim());
			
		} else if (isBtnType == EFFECT_SEARCH_BTN) {
			effectSearch(searchBox.getText().trim());

		} else if (isBtnType == METERIDL_SEARCH_BTN) {
			meteridlSearch(searchBox.getText().trim());

		} else {
			System.out.println("선택되지않았습니다.");
		}

	}


}
