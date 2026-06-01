package com.java2nb.novel.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.ApiOperation;

import com.java2nb.novel.domain.BookCategoryDO;
import com.java2nb.novel.service.BookCategoryService;
import com.java2nb.common.utils.PageBean;
import com.java2nb.common.utils.Query;
import com.java2nb.common.utils.R;

/**
 * 小说类别表控制器
 *
 * @author antigravity
 * @date 2026-06-01
 */
@Controller
@RequestMapping("/novel/bookCategory")
public class BookCategoryController {

    @Autowired
    private BookCategoryService bookCategoryService;

    @GetMapping()
    @RequiresPermissions("novel:bookCategory:bookCategory")
    String BookCategory() {
        return "novel/bookCategory/bookCategory";
    }

    @ApiOperation(value = "获取小说类别列表", notes = "获取小说类别列表")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("novel:bookCategory:bookCategory")
    public R list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<BookCategoryDO> bookCategoryList = bookCategoryService.list(query);
        int total = bookCategoryService.count(query);
        PageBean pageBean = new PageBean(bookCategoryList, total);
        return R.ok().put("data", pageBean);
    }

    @ApiOperation(value = "新增小说类别页面", notes = "新增小说类别页面")
    @GetMapping("/add")
    @RequiresPermissions("novel:bookCategory:add")
    String add() {
        return "novel/bookCategory/add";
    }

    @ApiOperation(value = "修改小说类别页面", notes = "修改小说类别页面")
    @GetMapping("/edit/{id}")
    @RequiresPermissions("novel:bookCategory:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        BookCategoryDO bookCategory = bookCategoryService.get(id);
        model.addAttribute("bookCategory", bookCategory);
        return "novel/bookCategory/edit";
    }

    @ApiOperation(value = "查看小说类别页面", notes = "查看小说类别页面")
    @GetMapping("/detail/{id}")
    @RequiresPermissions("novel:bookCategory:detail")
    String detail(@PathVariable("id") Integer id, Model model) {
        BookCategoryDO bookCategory = bookCategoryService.get(id);
        model.addAttribute("bookCategory", bookCategory);
        return "novel/bookCategory/detail";
    }

    @ApiOperation(value = "保存小说类别", notes = "保存小说类别")
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("novel:bookCategory:add")
    public R save(BookCategoryDO bookCategory) {
        if (bookCategoryService.save(bookCategory) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation(value = "修改小说类别", notes = "修改小说类别")
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("novel:bookCategory:edit")
    public R update(BookCategoryDO bookCategory) {
        bookCategoryService.update(bookCategory);
        return R.ok();
    }

    @ApiOperation(value = "删除小说类别", notes = "删除小说类别")
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("novel:bookCategory:remove")
    public R remove(Integer id) {
        if (bookCategoryService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation(value = "批量删除小说类别", notes = "批量删除小说类别")
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("novel:bookCategory:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        bookCategoryService.batchRemove(ids);
        return R.ok();
    }

}
