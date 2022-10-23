package lolChessSearchInfo.frame.host;

import javax.swing.JFrame;

public class HostDeleteFrame extends HostCRUDFrame {

   public HostDeleteFrame() {
      initData();
   }

   private void initData() {
      setTitle("관리자 삭제 페이지");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

}