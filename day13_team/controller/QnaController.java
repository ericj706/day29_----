package day13_team.controller;

import java.util.ArrayList;

import day13_team.model.Dao.QnaDao;
import day13_team.model.Dto.BoardDto;
import day13_team.model.Dto.QnaDto;

public class QnaController {
    private QnaController(){}
    private static final QnaController instance = new QnaController();
    public static QnaController getInstance(){ return instance; }

    private QnaDao qd = QnaDao.getInstance();

    // [1] 등록 Controller
    public boolean qnaSave( QnaDto qnaDto ){
        boolean result = qd.qnaSave( qnaDto ); // view에게 전달받은 매개변수을 dao에게전달
        return result; // dao에게 받은 결과을 view 반환
    }
    // [2] 전체조회 Controller 
    public ArrayList<QnaDto> qnaFindAll( ){
        ArrayList<QnaDto> result = qd.qnaFindAll();
        return result;
    }

    // [3] 개별수정 Controller 
    public boolean qnaUpdate( QnaDto qnaDto ){
        return qd.qnaUpdate( qnaDto );
    }

    // [4] 개별삭제 Controller
    public boolean qnaDelete( int no ){
        return qd.qnaDelete( no );
    }
}
