package com.pinyougou.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        List<TbBrand> brands = brandService.findAll();
        return brands;
    }

    @RequestMapping("/findPage")
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        return brandService.findPage(pageNum, pageSize);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand) {
        try {
            brandService.add(tbBrand);
            return new Result(true, "ok");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "失败！！！");
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand) {
        try {
            brandService.update(tbBrand);
            return new Result(true, "ok");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "失败！！！");
        }
    }

    @RequestMapping("/delee")
    public Result delete(Long[] ids) {
        System.out.println(ids);
        try {
            brandService.dele(ids);
            return new Result(true, "ok");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "失败！！！");
        }
    }

    @RequestMapping("/selectBrandList")
    public List<Map> tbBrandMapper() {
        return brandService.SelectBrandList();
    }

}