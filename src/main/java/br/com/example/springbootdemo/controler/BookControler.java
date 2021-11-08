package br.com.example.springbootdemo.controler;

import br.com.example.springbootdemo.entity.BookEntity;
import br.com.example.springbootdemo.entity.dto.BookDTO;
import br.com.example.springbootdemo.service.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookControler {

    @Autowired
    private BookServices bookServices;

    @GetMapping
    public List<BookEntity> findAll() {
        return bookServices.findAll();
    }

    @GetMapping("/{id}")
    public BookEntity findById(@PathVariable Long id) {
        return bookServices.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity save(@RequestBody BookDTO dto){
        return bookServices.save(dto);
    }

    @PutMapping("/{id}")
    public BookEntity updateBook(@RequestBody BookDTO dto, @PathVariable Long id){
        BookEntity bookEntity = bookServices.findById(id);
        return bookServices.update(bookEntity, dto);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookServices.delete(id);
    }
}
