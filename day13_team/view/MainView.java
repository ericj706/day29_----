package day13_team.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day13_team.controller.BoardController;
import day13_team.controller.QnaController;
import day13_team.model.Dto.BoardDto;
import day13_team.model.Dto.QnaDto;
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
                else if (ch==2) { qnaMenu(); }
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
    

    // 게시글관리
    public static class BoardView {
        private BoardView(){} // 1.
        private Scanner scan = new Scanner(System.in);
        private static final BoardView instance = new BoardView(); 
        public static BoardView getInstance( ){ return instance; } 
        private BoardController bc = BoardController.getInstance();

        private void boardMenu() {
        while (true) {
            System.out.println("\n--- [게시물 관리] ---");
            System.out.print("1.등록 2.목록 3.수정 4.삭제 5.이전메뉴");
            System.out.println("\n 선택 > ");
            String ch = scan.next();

            if (ch.equals("1")) {  }
            else if (ch.equals("2")) {  }
            else if (ch.equals("3")) { break; }
            else { System.out.println("잘못된 입력입니다."); }
        }
    }

    }
    // 문의글 관리
    public static class QnaView {
        private QnaView(){} // 1.
        private Scanner scan = new Scanner(System.in);
        private static final QnaView instance = new QnaView(); 
        public static QnaView getInstance( ){ return instance; } 
        private QnaController qc = QnaController.getInstance();

        private void qnaMenu() {
            while (true) {
                System.out.println("\n--- [문의글 관리] ---");
                System.out.print("1.등록 2.목록 3.수정 4.삭제 5.이전메뉴");
                System.out.println("\n 선택 > ");
                String ch = scan.next();

                if (ch.equals("1")) {  }
                else if (ch.equals("2")) {  }
                else if (ch.equals("3")) { break; }
                else { System.out.println("잘못된 입력입니다."); }
            }
        }   
        
        // [1] 저장 VIEW
        public void qnaSave( ){
            Scanner scan = MainView.getInstance().scan;
            System.out.print("문의글: ");   String 문의글 = scan.next();  // 1.1 저장할 자료 입력받기 
            System.out.print("작성자: ");   String 작성자 = scan.next();
            QnaDto qnaDto = new QnaDto(0, 문의글, 작성자); // 1.2 자료 객체화하기 , no(아무거나/사용X)
            boolean result = qc.qnaSave( qnaDto ); // 1.3 컨트롤러 에게 전달(dto) 하여 응답(boolean) 받기 
            if( result ){ System.out.println(">등록성공");} // 1.4 응답받은 결과로 출력
            else{ System.out.println(">등록실패"); }
        }
        // [2] 전체조회 VIEW
        public void qnaFindAll( ){
            ArrayList<QnaDto> result = qc.qnaFindAll();// 1. 컨트롤러에게 요청하고 모든 게시물정보 들을 받는다.
            for( QnaDto dto : result ){// 2. 반복문 이용하여 게시물정보들을 출력 
            System.out.println( dto.getNo()+" / "+dto.getWriter()+" / " +dto.getQuestion() );
            }
        }

        // [3] 개별수정 VIEW
        public void qnaUpdate( ){
            Scanner scan = MainView.getInstance().scan;
            System.out.print("수정할번호: ");   int 수정할번호 = scan.nextInt();
            System.out.print("수정할내용: ");   String 수정할내용 = scan.next();
            QnaDto qnaDto = new QnaDto(수정할번호, 수정할내용, null ); // writer 사용안함.null
            boolean result = qc.qnaUpdate( qnaDto );
            if( result ){ System.out.println(">수정 성공"); }
            else{ System.out.println(">수정 실패(없는 번호)"); }
        }

        // [4] 개별삭제 VIEW
        public void qnaDelete( ){
            Scanner scan = MainView.getInstance().scan;
            System.out.print("삭제할번호: ");   int 삭제할번호 = scan.nextInt();
            boolean result = qc.qnaDelete( 삭제할번호 ); // 매개변수가 1개 이므로 dto 없이
            if( result ){ System.out.println(">삭제 성공"); }
            else{ System.out.println(">삭제 실패(없는 번호)"); }
        }
    }
}

