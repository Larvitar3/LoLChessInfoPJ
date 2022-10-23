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

import lolChessSearchInfo.dto.ResponseChampion;
import lolChessSearchInfo.service.SynergySearchService;

public class SynergySearchFrame extends JFrame implements ActionListener{

	SynergySearchService sss;
	JLabel backgroundImg;
	JButton lineBtn;
	JButton tribeBtn;
	
	JTextField searchBox;
	JButton searchBtn;
	
	JPanel lineBgBox;
	JPanel tribeBgBox;
	JPanel flowBox;
	
	JTextArea lineEffectText;
	JTextArea lineCharText;
	
	JLabel chmpInfo;
	
	public SynergySearchFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setSize(810, 640);
		setTitle("아이템 검색");  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		backgroundImg = new JLabel(new ImageIcon("Images/synergyBg.jpg"));
		
		lineBtn = new JButton("Line");
		tribeBtn =  new JButton("Tribe");
		
		searchBox = new JTextField();
		searchBtn = new JButton("검색");
		
		lineBgBox = new JPanel();
		flowBox = new JPanel();
		tribeBgBox = new JPanel();
		lineEffectText = new JTextArea();
		lineCharText = new JTextArea();
		
		chmpInfo = new JLabel("계열 챔피언     |    ");
		
		sss = new SynergySearchService();
		
	}
	void lineSearch(String searchLineName) {

		List<ResponseChampion> resList = sss.selectSynergyByLine(searchLineName);

		lineBgBox.add(flowBox);
		flowBox.setSize(704, 200);
		flowBox.setLocation(53, 370);
		flowBox.setLayout(null);
		
		JLabel mtdName = new JLabel(resList.get(1).getLineName());
		flowBox.add(mtdName);
		mtdName.setSize(100, 50);
		mtdName.setLocation(20, 30);
		mtdName.setFont(new Font("sanSerif", Font.BOLD, 24));
		mtdName.setHorizontalAlignment(JLabel.CENTER);

		flowBox.add(lineEffectText);
		lineEffectText.setSize(430, 60);
		lineEffectText.setFont(new Font("sanSerif", Font.BOLD, 16));
		lineEffectText.setLocation(160, 0);
		lineEffectText.setLineWrap(true);
		lineEffectText.setWrapStyleWord(true);
		lineEffectText.setEditable(false);
		lineEffectText.setText(resList.get(1).getLineSynergyEffect());
		
		System.out.println(resList.get(1).getLineSynergyCharacteristic());
		
		if(resList.get(1).getLineSynergyCharacteristic() != null) {
			flowBox.add(lineCharText);
			lineCharText.setSize(400, 60);
			lineCharText.setFont(new Font("sanSerif", Font.BOLD, 16));
			lineCharText.setLocation(160, 70);
			lineCharText.setLineWrap(true);
			lineCharText.setWrapStyleWord(true);
			lineCharText.setEditable(false);
			lineCharText.setText(resList.get(1).getLineSynergyCharacteristic());
			System.out.println("실행!!");
		}
		
		int witdhMarginTextPlus = 0;
		boolean textFlag = true;

		flowBox.add(chmpInfo);
		chmpInfo.setSize(140, 20);
		chmpInfo.setFont(new Font("sanSerif", Font.BOLD,16));
		chmpInfo.setHorizontalAlignment(JLabel.CENTER);
		chmpInfo.setLocation(30, 140);
		
		for (ResponseChampion data : resList) {

			JLabel titleJlabel = new JLabel(data.getName() + ", ");
			flowBox.add(titleJlabel);
			titleJlabel.setSize(100, 20);
			titleJlabel.setFont(new Font("sanSerif", Font.BOLD,14));
			titleJlabel.setHorizontalAlignment(JLabel.CENTER);

			if (textFlag) {
				titleJlabel.setLocation(160, 140);
				witdhMarginTextPlus = 240;

			} else {
				titleJlabel.setLocation((20 + witdhMarginTextPlus), 140);
				witdhMarginTextPlus += 80;
				int countNum = 20 + witdhMarginTextPlus;
				System.out.println("마진 실행중  :    " + countNum);
				if (countNum > 694) {
					titleJlabel.setLocation(50, 150);
				}

			}

			textFlag = false;

		} // 라인 검색 텍스트 end

		add(flowBox);
		add(lineBgBox);
		repaint();

	}
	private void lineSelect() {

		add(searchBox);
		add(searchBtn);

		repaint();
	}

	void tribeSearch(String searchTribeName) {
		

		List<ResponseChampion> resList = sss.selectSynergyByTribe(searchTribeName);

		lineBgBox.add(flowBox);
		flowBox.setSize(704, 200);
		flowBox.setLocation(53, 370);
		flowBox.setLayout(null);
		
		JLabel mtdName = new JLabel(resList.get(1).getTribeName());
		flowBox.add(mtdName);
		mtdName.setSize(100, 50);
		mtdName.setLocation(20, 30);
		mtdName.setFont(new Font("sanSerif", Font.BOLD, 24));
		mtdName.setHorizontalAlignment(JLabel.CENTER);

		flowBox.add(lineEffectText);
		lineEffectText.setSize(430, 60);
		lineEffectText.setFont(new Font("sanSerif", Font.BOLD, 16));
		lineEffectText.setLocation(160, 0);
		lineEffectText.setLineWrap(true);
		lineEffectText.setWrapStyleWord(true);
		lineEffectText.setEditable(false);
		lineEffectText.setText(resList.get(1).getTribeSynergyEffect());
			
		if(resList.get(1).getLineSynergyCharacteristic() != null) {
			flowBox.add(lineCharText);
			lineCharText.setSize(400, 60);
			lineCharText.setFont(new Font("sanSerif", Font.BOLD, 16));
			lineCharText.setLocation(160, 70);
			lineCharText.setLineWrap(true);
			lineCharText.setWrapStyleWord(true);
			lineCharText.setEditable(false);
			lineCharText.setText(resList.get(1).getTribeSynergyCharacteristic());
			System.out.println("실행!!");
		}
		
		int witdhMarginTextPlus = 0;
		boolean textFlag = true;

		flowBox.add(chmpInfo);
		chmpInfo.setSize(140, 20);
		chmpInfo.setFont(new Font("sanSerif", Font.BOLD,16));
		chmpInfo.setHorizontalAlignment(JLabel.CENTER);
		chmpInfo.setLocation(30, 140);
		
		for (ResponseChampion data : resList) {

			JLabel titleJlabel = new JLabel(data.getName() + ", ");
			flowBox.add(titleJlabel);
			titleJlabel.setSize(100, 20);
			titleJlabel.setFont(new Font("sanSerif", Font.BOLD,14));
			titleJlabel.setHorizontalAlignment(JLabel.CENTER);

			if (textFlag) {
				titleJlabel.setLocation(160, 140);
				witdhMarginTextPlus = 240;

			} else {
				titleJlabel.setLocation((20 + witdhMarginTextPlus), 140);
				witdhMarginTextPlus += 80;
				int countNum = 20 + witdhMarginTextPlus;
				System.out.println("마진 실행중  :    " + countNum);
				if (countNum > 694) {
					titleJlabel.setLocation(50, 150);
				}

			}

			textFlag = false;

		} // 라인 검색 텍스트 end

		add(flowBox);
		add(lineBgBox);
		repaint();
		
	}
	private void tribeSelect() {

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
		
		add(lineBtn);
		lineBtn.setSize(352, 40);
		lineBtn.setLocation(50, 220);

		add(tribeBtn);
		tribeBtn.setSize(352, 40);
		tribeBtn.setLocation(402, 220);
		
		lineBgBox.setSize(702, 300);
		lineBgBox.setLocation(50, 260);
		lineBgBox.setBackground(whiteOp);
		lineBgBox.setLayout(null);
		
		tribeBgBox.setSize(702, 300);
		tribeBgBox.setLocation(50, 260);
		tribeBgBox.setBackground(whiteOp);
		tribeBgBox.setLayout(null);
		
		flowBox.setBackground(whiteOp100);
		
		searchBox.setSize(480, 35);
		searchBox.setLocation(130, 300);

		searchBtn.setSize(70, 35);
		searchBtn.setLocation(610, 300);
		
		lineEffectText.setOpaque(true);
		lineEffectText.setBackground(whiteOp100);
		
		lineCharText.setOpaque(true);
		lineCharText.setBackground(whiteOp100);
		
	}
	

	private void addEventListener() {
		lineBtn.addActionListener(this);
		tribeBtn.addActionListener(this);
		searchBtn.addActionListener(this);
	}

	int isBtnType;
	final int LINE_SEARCH_BTN = 1;
	final int TRIBE_SEARCH_BTN = 2;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == lineBtn) {
			lineSelect();
			isBtnType = LINE_SEARCH_BTN;
			tribeBgBox.removeAll();
			flowBox.removeAll();
			remove(tribeBgBox);
			
		} else if(e.getSource() == tribeBtn) {
			tribeSelect();
			isBtnType = TRIBE_SEARCH_BTN;
			lineBgBox.removeAll();
			flowBox.removeAll();
			remove(lineBgBox);
			
		}  else if (e.getSource() == searchBtn) {
			actionType(isBtnType);
		}
		
	}
	
	private void actionType(int isBtnType) {

		if (isBtnType == LINE_SEARCH_BTN) {
			lineSearch(searchBox.getText().trim());
			System.out.println("계열 검색");

		} else if (isBtnType == TRIBE_SEARCH_BTN) {
			System.out.println("종족 검색");
			tribeSearch(searchBox.getText().trim());

		} else {
			System.out.println("선택되지않았습니다.");
		}

	}
	
}
