package tw.board.dao;

import java.util.List;

import tw.board.domain.BoardBean;

public interface BoardDAO {

	public abstract BoardBean select(Integer id);

	public abstract List<BoardBean> select();

	public abstract BoardBean insert(BoardBean bean);

	public abstract BoardBean update(Integer id,String title,
			java.util.Date begin, java.util.Date end, String user,String content);
	
	public abstract boolean delete(Integer id);

}