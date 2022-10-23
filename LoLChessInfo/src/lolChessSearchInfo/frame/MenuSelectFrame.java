package lolChessSearchInfo.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

<<<<<<< HEAD
import lolChessSearchInfo.host.HostMainFrame;
=======
import lolChessSearchInfo.hostFrame.HostMainFrame;
import lombok.Data;
>>>>>>> bongbong0331

@Data
public class MenuSelectFrame extends JFrame implements ActionListener {

   JLabel backgroundImg;
   JButton championSearch;
   JButton itemSearch;
   JButton synergySearch;
   JButton hostButton; // 승원

   public MenuSelectFrame() {
      initData();
      setInitLayout();
      addEventListener();
   }

   private void initData() {
      setSize(810, 640);
      setTitle("롤체 검색");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      backgroundImg = new JLabel(new ImageIcon("Images/menuBackground.jpg"));
      championSearch = new JButton("챔피언 검색");
      itemSearch = new JButton("아이템 검색");
      synergySearch = new JButton("시너지 검색");
      hostButton = new JButton("관리자"); // 승원
   }

   private void setInitLayout() {
      setVisible(true);
      setResizable(false);
      setLocationRelativeTo(null);
      setLayout(null);
      setContentPane(backgroundImg);

      add(championSearch);
      championSearch.setSize(328, 52);
      championSearch.setLocation(230, 328);

      add(itemSearch);
      itemSearch.setSize(328, 52);
      itemSearch.setLocation(230, 400);

      add(synergySearch);
      synergySearch.setSize(328, 52);
      synergySearch.setLocation(230, 472);

      add(hostButton);
      hostButton.setSize(100, 40);
      hostButton.setLocation(650, 530);
   }

   private void addEventListener() {
      championSearch.addActionListener(this);
      itemSearch.addActionListener(this);
      synergySearch.addActionListener(this);
      hostButton.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {

      if (e.getSource() == championSearch) {
         new ChampionSerchFrame();
         setVisible(false);
      } else if (e.getSource() == itemSearch) {
         new ItemSearchFrame();
         setVisible(false);
      } else if (e.getSource() == synergySearch) {
         new SynergySearchFrame();
         setVisible(false);
      } else if (e.getSource() == hostButton) {
         setVisible(false);
         new HostMainFrame();

      }
   }

   public static void main(String[] args) {
      new MenuSelectFrame();
   }

}