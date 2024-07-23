package br.com.codiub.eucuido.api.controller;

import br.com.codiub.eucuido.api.service.BookService;
import br.com.codiub.eucuido.model.entity.Book;
import br.com.codiub.eucuido.model.input.BookInput;
import br.com.codiub.eucuido.model.output.BookOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    @Autowired
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody BookInput bookInput) {
        Book createdBook = bookService.save(bookInput);
        BookOutput bookOutput = new BookOutput(createdBook);
        return ResponseEntity.ok(bookOutput);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody @Valid BookInput bookInput) {
        Book updatedBook = bookService.updateById(id, bookInput);
        BookOutput bookOutput = new BookOutput(updatedBook);
        return ResponseEntity.ok(bookOutput);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deactivateById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Book deleted successfully\"}");
    }

    @GetMapping
    public ResponseEntity<List<BookOutput>> listAll() {
        List<Book> books = bookService.listAllBooks();
        List<BookOutput> responseDTOS = books.stream()
                .map(BookOutput::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookOutput> getById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        BookOutput bookOutput = new BookOutput(book);
        return ResponseEntity.ok(bookOutput);
    }
}
