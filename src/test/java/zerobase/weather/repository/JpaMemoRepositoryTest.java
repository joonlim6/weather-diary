package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {
    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo newMemo = new Memo(1, "insert memo");
        //when
        Memo returnedMemo = jpaMemoRepository.save(newMemo);
        //then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 1);
        assertEquals(newMemo.getText(), returnedMemo.getText());
    }

    @Test
    void findByIdMemoTest() {
        //given
        Memo newMemo = new Memo(11, "insert memo");
        //when
        Memo returnedMemo = jpaMemoRepository.save(newMemo);
        //then
        Memo copy = jpaMemoRepository.findById(returnedMemo.getId())
                .orElseThrow(() -> new RuntimeException("Memo unavailable"));

        System.out.println(copy.getId());
        assertEquals(returnedMemo.getId(), copy.getId());
        assertEquals(returnedMemo.getText(), copy.getText());
    }
}