package com.sena.crud_basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sena.crud_basic.model.bookDTO;

public interface IBookRepository extends JpaRepository<bookDTO, Integer> {
@CrossOrigin(origins = "http://localhost:5173")

    @Query("SELECT b FROM book b WHERE b.status=1 AND b.stock > 0")
    List<bookDTO> findAllBookActive();

    // @Query("SELECT b FROM book b WHERE b.title LIKE %?1%")
    // List<bookDTO> search(String filter);
    @Query("SELECT b FROM book b WHERE  b.title LIKE %?1% OR b.author LIKE %?1% OR b.publisher LIKE %?1% AND b.status=1 AND b.stock > 0")
    List<bookDTO> search(String filter);
    /*
     * example
     * 
     * @Query("SELECT b FROM book b WHERE b.title LIKE %?1% b.author LIKE %?2%")
     * List<bookDTO> search(String variable1, String variable2, String Variablen);
     */

}
