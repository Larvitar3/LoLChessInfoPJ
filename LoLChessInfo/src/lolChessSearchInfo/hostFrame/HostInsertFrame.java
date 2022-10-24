package lolChessSearchInfo.hostFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lolChessSearchInfo.stepDao.ChampionDao;
import lombok.Data;
import lombok.Getter;

public class HostInsertFrame extends JFrame implements ActionListener {

	private ChampionDao chpd;
	private JLabel backgroundImg;
	private JButton championBtn;
	public ChampionDao getChpd() {
		return chpd;
	}

	public void setChpd(ChampionDao chpd) {
		this.chpd = chpd;
	}

	public JLabel getBackgroundImg() {
		return backgroundImg;
	}

	public void setBackgroundImg(JLabel backgroundImg) {
		this.backgroundImg = backgroundImg;
	}

	public JButton getChampionBtn() {
		return championBtn;
	}

	public void setChampionBtn(JButton championBtn) {
		this.championBtn = championBtn;
	}

	public JButton getItemBtn() {
		return itemBtn;
	}

	public void setItemBtn(JButton itemBtn) {
		this.itemBtn = itemBtn;
	}


	public void setName(JLabel name) {
		this.name = name;
	}

	public JTextField getInputName() {
		return inputName;
	}

	public void setInputName(JTextField inputName) {
		this.inputName = inputName;
	}

	public JLabel getPrice() {
		return price;
	}

	public void setPrice(JLabel price) {
		this.price = price;
	}

	public JTextField getInputPrice() {
		return inputPrice;
	}

	public void setInputPrice(JTextField inputPrice) {
		this.inputPrice = inputPrice;
	}

	public JLabel getHp() {
		return hp;
	}

	public void setHp(JLabel hp) {
		this.hp = hp;
	}

	public JTextField getInputHp() {
		return inputHp;
	}

	public void setInputHp(JTextField inputHp) {
		this.inputHp = inputHp;
	}

	public JLabel getPower() {
		return power;
	}

	public void setPower(JLabel power) {
		this.power = power;
	}

	public JTextField getInputPower() {
		return inputPower;
	}

	public void setInputPower(JTextField inputPower) {
		this.inputPower = inputPower;
	}

	public JLabel getDps() {
		return dps;
	}

	public void setDps(JLabel dps) {
		this.dps = dps;
	}

	public JTextField getInputDps() {
		return inputDps;
	}

	public void setInputDps(JTextField inputDps) {
		this.inputDps = inputDps;
	}

	public JLabel getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(JLabel attackRange) {
		this.attackRange = attackRange;
	}

	public JTextField getInputAttackRange() {
		return inputAttackRange;
	}

	public void setInputAttackRange(JTextField inputAttackRange) {
		this.inputAttackRange = inputAttackRange;
	}

	public JLabel getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(JLabel attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public JTextField getInputAttackSpeed() {
		return inputAttackSpeed;
	}

	public void setInputAttackSpeed(JTextField inputAttackSpeed) {
		this.inputAttackSpeed = inputAttackSpeed;
	}

	public JLabel getDefense() {
		return defense;
	}

	public void setDefense(JLabel defense) {
		this.defense = defense;
	}

	public JTextField getInputDefense() {
		return inputDefense;
	}

	public void setInputDefense(JTextField inputDefense) {
		this.inputDefense = inputDefense;
	}

	public JLabel getMagicResistance() {
		return magicResistance;
	}

	public void setMagicResistance(JLabel magicResistance) {
		this.magicResistance = magicResistance;
	}

	public JTextField getInputMagicResistance() {
		return inputMagicResistance;
	}

	public void setInputMagicResistance(JTextField inputMagicResistance) {
		this.inputMagicResistance = inputMagicResistance;
	}

	public JLabel getImageAddress() {
		return imageAddress;
	}

	public void setImageAddress(JLabel imageAddress) {
		this.imageAddress = imageAddress;
	}

	public JTextField getInputImageAddress() {
		return inputImageAddress;
	}

	public void setInputImageAddress(JTextField inputImageAddress) {
		this.inputImageAddress = inputImageAddress;
	}

	public JButton getInsertBtn() {
		return insertBtn;
	}

	public void setInsertBtn(JButton insertBtn) {
		this.insertBtn = insertBtn;
	}

	public JButton getHomeBtn() {
		return homeBtn;
	}

	public void setHomeBtn(JButton homeBtn) {
		this.homeBtn = homeBtn;
	}

	public Color getWhiteOp() {
		return whiteOp;
	}

	public void setWhiteOp(Color whiteOp) {
		this.whiteOp = whiteOp;
	}

	public Color getWhiteOp100() {
		return whiteOp100;
	}

	public void setWhiteOp100(Color whiteOp100) {
		this.whiteOp100 = whiteOp100;
	}

	public JPanel getItemBgBox() {
		return itemBgBox;
	}

	public void setItemBgBox(JPanel itemBgBox) {
		this.itemBgBox = itemBgBox;
	}

	public JPanel getChampionBgBox() {
		return championBgBox;
	}

	public void setChampionBgBox(JPanel championBgBox) {
		this.championBgBox = championBgBox;
	}

	private JButton itemBtn;

	private JLabel name;
	private JTextField inputName;

	private JLabel price;
	private JTextField inputPrice;

	private JLabel hp;
	private JTextField inputHp;

	private JLabel power;
	private JTextField inputPower;

	private JLabel dps;
	private JTextField inputDps;

	private JLabel attackRange;
	private JTextField inputAttackRange;

	private JLabel attackSpeed;
	private JTextField inputAttackSpeed;

	private JLabel defense;
	private JTextField inputDefense;

	private JLabel magicResistance;
	private JTextField inputMagicResistance;

	private JLabel imageAddress;
	private JTextField inputImageAddress;

	private JButton insertBtn;

	private JButton homeBtn;

	Color whiteOp = new Color(225, 225, 225, 150);
	Color whiteOp100 = new Color(225, 225, 225, 0);

	private JPanel itemBgBox;
	private JPanel championBgBox;

	public HostInsertFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(810, 640);
		setTitle("관리자 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backgroundImg = new JLabel(new ImageIcon("Images/subBg.jpg"));
		championBtn = new JButton("CHAMPION");
		itemBtn = new JButton("ITEM");
		homeBtn = new JButton("HOME");

		name = new JLabel("이름");
		inputName = new JTextField();

		price = new JLabel("가격");
		inputPrice = new JTextField();

		hp = new JLabel("HP");
		inputHp = new JTextField();

		power = new JLabel("Power");
		inputPower = new JTextField();

		dps = new JLabel("DPS");
		inputDps = new JTextField();

		attackRange = new JLabel("공격 사거리");
		inputAttackRange = new JTextField();

		attackSpeed = new JLabel("공격 속도");
		inputAttackSpeed = new JTextField();

		defense = new JLabel("방어력");
		inputDefense = new JTextField();

		magicResistance = new JLabel("마법 저항력");
		inputMagicResistance = new JTextField();

		imageAddress = new JLabel("이미지 주소");
		inputImageAddress = new JTextField();
		insertBtn = new JButton("추가하기");

		championBgBox = new JPanel();
		itemBgBox = new JPanel();
		chpd = new ChampionDao();
	}

	void insertChamp() {

		add(championBgBox);
		championBgBox.setSize(700, 300);
		championBgBox.setLocation(52, 260);
		championBgBox.setLayout(null);
		championBgBox.setBackground(whiteOp);

		championBgBox.add(name);
		name.setSize(80, 20);
		name.setLocation(20, 20);
		name.setFont(new Font("sanSerif", Font.BOLD, 13));
		championBgBox.add(inputName);
		inputName.setSize(100, 30);
		inputName.setLocation(20, 45);

		championBgBox.add(price);
		price.setSize(50, 20);
		price.setLocation(150, 20);
		price.setFont(new Font("sanSerif", Font.BOLD, 13));
		championBgBox.add(inputPrice);
		inputPrice.setSize(50, 30);
		inputPrice.setLocation(150, 45);

		championBgBox.add(hp);
		hp.setSize(50, 20);
		hp.setLocation(230, 20);
		hp.setFont(new Font("sanSerif", Font.BOLD, 13));
		championBgBox.add(inputHp);
		inputHp.setSize(50, 30);
		inputHp.setLocation(230, 45);

		championBgBox.add(power);
		power.setSize(50, 20);
		power.setLocation(310, 20);
		power.setFont(new Font("sanSerif", Font.BOLD, 13));
		championBgBox.add(inputPower);
		inputPower.setSize(50, 30);
		inputPower.setLocation(310, 45);

		championBgBox.add(dps);
		dps.setSize(50, 20);
		dps.setLocation(390, 20);
		dps.setFont(new Font("sanSerif", Font.BOLD, 13));
		championBgBox.add(inputDps);
		inputDps.setSize(50, 30);
		inputDps.setLocation(390, 45);

		championBgBox.add(attackRange);
		attackRange.setSize(80, 20);
		attackRange.setLocation(500, 20);
		attackRange.setFont(new Font("sanSerif", Font.BOLD, 13));
		championBgBox.add(inputAttackRange);
		inputAttackRange.setSize(80, 30);
		inputAttackRange.setLocation(500, 45);

		championBgBox.add(attackSpeed);
		attackSpeed.setSize(80, 20);
		attackSpeed.setLocation(610, 20);
		attackSpeed.setFont(new Font("sanSerif", Font.BOLD, 13));
		championBgBox.add(inputAttackSpeed);
		inputAttackSpeed.setSize(80, 30);
		inputAttackSpeed.setLocation(610, 45);

		championBgBox.add(defense);
		defense.setSize(100, 20);
		defense.setLocation(20, 100);
		defense.setFont(new Font("sanSerif", Font.BOLD, 13));
		championBgBox.add(inputDefense);
		inputDefense.setSize(100, 30);
		inputDefense.setLocation(20, 125);

		championBgBox.add(magicResistance);
		magicResistance.setSize(100, 20);
		magicResistance.setLocation(150, 100);
		defense.setFont(new Font("sanSerif", Font.BOLD, 13));
		championBgBox.add(inputMagicResistance);
		inputMagicResistance.setSize(100, 30);
		inputMagicResistance.setLocation(150, 125);

		championBgBox.add(imageAddress);
		imageAddress.setSize(200, 20);
		imageAddress.setLocation(280, 100);
		defense.setFont(new Font("sanSerif", Font.BOLD, 13));
		championBgBox.add(inputImageAddress);
		inputImageAddress.setSize(200, 30);
		inputImageAddress.setLocation(280, 125);

		championBgBox.add(insertBtn);
		insertBtn.setFont(new Font("sanSerif", Font.BOLD, 13));
		insertBtn.setSize(100, 30);
		insertBtn.setLocation(510, 125);

		repaint();
	}

	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setContentPane(backgroundImg);

		add(championBtn);
		championBtn.setSize(352, 40);
		championBtn.setLocation(50, 220);

		add(itemBtn);
		itemBtn.setSize(352, 40);
		itemBtn.setLocation(402, 220);

		add(homeBtn);
		homeBtn.setSize(80, 40);
		homeBtn.setLocation(670, 70);
	}

	private void addEventListener() {
		championBtn.addActionListener(this);
		itemBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		insertBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == championBtn) {
			System.out.println("챔피온버튼");
			insertChamp();
		} else if (e.getSource() == itemBtn) {
			System.out.println("아이템 버튼");
		} else if (e.getSource() == insertBtn) {
			chpd.insertChamp(this);
		} else if (e.getSource() == homeBtn) {
			System.out.println("홈버튼");
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new HostInsertFrame();
	}

}