package br.com.treino.api.service;

import br.com.treino.model.entity.Book;
import br.com.treino.model.input.BookInput;
import br.com.treino.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found!"));
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public Book save(BookInput bookInput) {
        Book book = modelMapper.map(bookInput, Book.class);
        return bookRepository.save(book);
    }

    public Book updateById(Long id, BookInput bookInput) {
        Book book = findById(id);
        modelMapper.map(bookInput, book);
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        Book book = findById(id);
        bookRepository.delete(book);
    }
}
