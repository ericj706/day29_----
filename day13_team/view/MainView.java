package day13_team.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import day13_team.controller.BoardController;
import day13_team.controller.QnaController;
import day13_team.view.MainView.BoardView;
import day13_team.view.MainView.QnaView;

public class MainView {
    private MainView() {}
    private Scanner scan = new Scanner(System.in);
    private static final MainView instance = new MainView();
    public static MainView getInstance() { return instance; }

    public void run() {
        while (true) {
            try{ // 예외처리 
                System.out.println("\n========== 메인 메뉴 ==========");
                System.out.print("1.게시물 관리 2.문의글 관리 3.종료: ");
                int ch = scan.nextInt();

                if (ch==1) { boardMenu(); }
                else if (ch==2) { productMenu(); }
                else if (ch==3) {
                    System.out.println("프로그램 종료.");
                    break;
                } else {System.out.println("잘못된 입력입니다.");}
            }catch( InputMismatchException e ){
                // 입력(성공) 했지만 타입반환에서 예외 이므로 입력객체 초기화
                scan = new Scanner( System.in );
                System.out.println("[다시입력]" + e);
            }
        }
    }
    public class BoardView {
        private BoardView(){} // 1.
        private static final BoardView instance = new BoardView(); 
        public static BoardView getInstance( ){ return instance; } 
        private BoardController bc = BoardController.getInstance();
        

    }
    public class QnaView {
        private QnaView(){} // 1.
        private static final QnaView instance = new QnaView(); 
        public static QnaView getInstance( ){ return instance; } 
        private QnaController qc = QnaController.getInstance();


    }
}

