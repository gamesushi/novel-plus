package com.java2nb.novel.service;

import com.java2nb.novel.domain.BookCategoryDO;
import java.util.List;
import java.util.Map;

/**
 * 小说类别表
 * 
 * @author antigravity
 * @date 2026-06-01
 */
public interface BookCategoryService {

    BookCategoryDO get(Integer id);
    
    List<BookCategoryDO> list(Map<String, Object> map);
    
    int count(Map<String, Object> map);
    
    int save(BookCategoryDO category);
    
    int update(BookCategoryDO category);
    
    int remove(Integer id);
    
    int batchRemove(Integer[] ids);
}
