package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardmapper;
	
	@Test
	public void testGetList() {
		log.info("--------------------------------------");
		boardmapper.getList();
	}
	
	@Test
	public void testinsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("TEST 테스트");
		vo.setContent("content 테스트");
		vo.setWriter("tester");
		
		boardmapper.insert(vo);
		log.info("------------------------");
		log.info("alter insert" + vo.getBno());
		
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("aaaaTEST 테스트");
		vo.setContent("aaaacontent 테스트");
		vo.setWriter("aaaatester");
		
		boardmapper.insertSelecKey(vo);
		
		log.info("------------------------");
		log.info("alter insert selectkey" + vo.getBno());
		
	}
	
	@Test
	public void testread() {
		
		BoardVO vo = boardmapper.read(9L);
		log.info(vo);
	}
	
	@Test
	public void testdelete() {
		
		int count = boardmapper.delete(1L);
		
		log.info("count:"+ count);
	}
	@Test
	public void testupdate() {
		
		BoardVO vo = new BoardVO();
		vo.setBno(9L);
		vo.setTitle("update title");
		vo.setContent("update content");
		vo.setWriter("user00");
		
		log.info("count:" + boardmapper.update(vo));
	}
	
	@Test
	public void testPaging() {
		// 1페이지 10개
		Criteria cri = new Criteria();
		
		List<BoardVO> list = boardmapper.getListWithPaging(cri);
		
		list.forEach(b -> log.info(b));
	}
	@Test
	public void testPageDTO() {
		// 1페이지 10개
		Criteria cri = new Criteria();
		cri.setPageNum(25);
		
		PageDTO pageDTO = new PageDTO(cri, 251);
		
		log.info(pageDTO);
	}
	
	@Test
	public void testSearchPaging() {
		// 1페이지 10개
		Criteria cri = new Criteria();
		cri.setType("TCW");
		cri.setKeyword("test");
				
		List<BoardVO> list = boardmapper.getListWithPaging(cri);
				
		list.forEach(b -> log.info(b));
	}
}
