package lolChessSearchInfo.hostFrame;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HostUpdateFrame extends HostInsertFrame {

   public HostUpdateFrame() {
      initData();
   }

   private void initData() {
      setTitle("관리자 수정 페이지");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
}