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

public class HostSelectFrame extends HostCRUDFrame {

   public HostSelectFrame() {
      initData();
   }

   private void initData() {
      setTitle("관리자 조회 페이지");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

}