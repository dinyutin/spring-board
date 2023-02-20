package tw.board.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.board.domain.BoardBean;
import tw.board.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardservice;
	
	@GetMapping(value = "/{id}")
	 public BoardBean read(@PathVariable("id") Integer id) {
		return boardservice.select(id);
	 }
	@GetMapping(value = "/")
	 public List<BoardBean> getall() {
		return boardservice.select();
	 }
	@PostMapping(value = "/")
	 public void create(@RequestBody BoardBean bean,HttpSession session) {
		 boardservice.insert(bean);
	 }
//	
	@PutMapping(value = "/")
	 public void update(@RequestBody BoardBean bean) {
		boardservice.update(bean);
		
	 }	
	@DeleteMapping(value = "/{id}")
	 public void delete(@PathVariable("id") Integer id) {
		BoardBean bean=new BoardBean();
		bean.setId(id);
		boardservice.delete(bean); 		 
	 }	
}
