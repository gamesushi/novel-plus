package com.java2nb.novel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.java2nb.novel.dao.BookCategoryDao;
import com.java2nb.novel.domain.BookCategoryDO;
import com.java2nb.novel.service.BookCategoryService;

/**
 * 小说类别业务实现类
 * 
 * @author antigravity
 * @date 2026-06-01
 */
@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    
    @Autowired
    private BookCategoryDao bookCategoryDao;
    
    @Override
    public BookCategoryDO get(Integer id){
        return bookCategoryDao.get(id);
    }
    
    @Override
    public List<BookCategoryDO> list(Map<String, Object> map){
        return bookCategoryDao.list(map);
    }
    
    @Override
    public int count(Map<String, Object> map){
        return bookCategoryDao.count(map);
    }
    
    @Override
    public int save(BookCategoryDO category){
        category.setCreateTime(new Date());
        return bookCategoryDao.save(category);
    }
    
    @Override
    public int update(BookCategoryDO category){
        category.setUpdateTime(new Date());
        return bookCategoryDao.update(category);
    }
    
    @Override
    public int remove(Integer id){
        return bookCategoryDao.remove(id);
    }
    
    @Override
    public int batchRemove(Integer[] ids){
        return bookCategoryDao.batchRemove(ids);
    }
}
