package lolChessSearchInfo.hostFrame;

import javax.swing.JFrame;

public class HostDeleteFrame extends HostInsertFrame {

   public HostDeleteFrame() {
      initData();
   }

   private void initData() {
      setTitle("관리자 삭제 페이지");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

}