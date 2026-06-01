package com.java2nb.novel.dao;

import com.java2nb.common.annotation.SanitizeMap;
import com.java2nb.novel.domain.BookCategoryDO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

/**
 * 小说类别表
 * 
 * @author antigravity
 * @date 2026-06-01
 */
@Mapper
public interface BookCategoryDao {

    BookCategoryDO get(Integer id);
    
    List<BookCategoryDO> list(@SanitizeMap Map<String, Object> map);
    
    int count(Map<String, Object> map);
    
    int save(BookCategoryDO category);
    
    int update(BookCategoryDO category);
    
    int remove(Integer id);
    
    int batchRemove(Integer[] ids);
}
