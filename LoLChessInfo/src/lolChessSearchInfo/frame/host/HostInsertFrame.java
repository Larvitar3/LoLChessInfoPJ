package lolChessSearchInfo.frame.host;

import javax.swing.JFrame;

public class HostInsertFrame extends HostCRUDFrame {

   public HostInsertFrame() {
      initData();
   }

   private void initData() {
      setTitle("관리자 저장 페이지");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

}