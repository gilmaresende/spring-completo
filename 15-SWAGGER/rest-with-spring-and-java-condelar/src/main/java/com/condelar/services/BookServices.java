package com.condelar.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condelar.data.vo.v1.BookVO;
import com.condelar.exception.ResourceNotFoundException;
import com.condelar.mapper.DozerMapper;
import com.condelar.model.Book;
import com.condelar.repositories.BookRepository;

@Service
public class BookServices {

	private Logger logger = Logger.getLogger(BookServices.class.getName());

	@Autowired
	BookRepository repository;

	public BookVO findById(Long id) {
		logger.info("Finding one book!");
		Book book = getBook(id);
		return DozerMapper.parceObject(book, BookVO.class);
	}

	public List<BookVO> findAll() {
		return DozerMapper.parceListObject(repository.findAll(), BookVO.class);
	}

	public BookVO create(BookVO bookVO) {
		logger.info("Creating one book!");

		Book book = DozerMapper.parceObject(bookVO, Book.class);
		book = repository.save(book);
		bookVO = DozerMapper.parceObject(book, BookVO.class);

		return bookVO;
	}

	public BookVO update(BookVO bookVO) {
		logger.info("Update one book!");
		Book book = getBook(bookVO.getKey());
		book.setLaunchDate(bookVO.getLaunchDate());
		book.setPrice(bookVO.getPrice());
		book.setTitle(bookVO.getTitle());
		book.setAuthor(bookVO.getAuthor());

		book = repository.save(book);
		bookVO = DozerMapper.parceObject(book, BookVO.class);

		return bookVO;
	}

	public void delete(Long id) {
		logger.info("delete one book!");

		Book entiti = getBook(id);
		repository.delete(entiti);
	}

	private Book getBook(Long id) {
		Book book = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No recors found for this ID!"));
		return book;
	}
}
