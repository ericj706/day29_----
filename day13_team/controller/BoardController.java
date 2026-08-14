package day13_team.controller;

import java.util.ArrayList;

import day13_team.model.Dao.BoardDao;
import day13_team.model.Dto.BoardDto;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){ return instance; }

     //[*] MVC패턴 흐름의 dao 싱글톤 호출
    private BoardDao bd = BoardDao.getInstance();

    // [1] 등록 Controller
    public boolean boardSave( BoardDto boardDto ){
        boolean result = bd.boardSave( boardDto ); // view에게 전달받은 매개변수을 dao에게전달
        return result; // dao에게 받은 결과을 view 반환

    }
    // [2] 전체조회 Controller 
    public ArrayList<BoardDto> boardFindAll( ){
        ArrayList<BoardDto> result = bd.boardFindAll();
        return result;
    }
     // [3] 개별수정 Controller 
    public boolean boardUpdate( BoardDto boardDto ){
        return bd.boardUpdate( boardDto );
    }
    // [4] 개별삭제 Controller
    public boolean boardDelete( int no ){
        return bd.boardDelete( no );
    }



}
