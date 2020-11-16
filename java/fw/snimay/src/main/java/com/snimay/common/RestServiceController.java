package com.snimay.common;

import java.io.Serializable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**   
 * : restful的基本规范 
 * @title      : RestServiceController.java
 * @package    : com.snimay.common
 * @author     : xxy
 * @date       : 2018年4月27日 上午11:58:19
 * @version    : V1.0  
 * @param <T>
 * @param <ID> 
 */
public interface RestServiceController<T, ID extends Serializable> {
	
    /**
     * :  id 资源的唯一标识
     * @author     : xxy
     * @param id
     * @return
     * @throws
     */
    @GetMapping("/{id}")
    Object getOne(@PathVariable("id") ID id);

    
    /**
     * : 列表分页
     * @author     : xxy
     * @param rowSize 一页数据大小
     * @param page    当前页码
     * @return
     * @throws
     */
    @GetMapping
    Object getList(@RequestParam(value = "rowSize",defaultValue = "100", required = false) Integer rowSize
            , @RequestParam(value = "page", defaultValue = "1", required = false) Integer page);
    
    /**
     * : 提交一个资源
     * @author     : xxy
     * @param entity
     * @return
     * @throws
     */
    @PostMapping
    Object postOne(@RequestBody T entity);
    
    /**
     * : 提交一个资源，并给出标识
     * @author     : xxy
     * @param id
     * @param entity
     * @return
     * @throws
     */
    @PutMapping("/{id}")
    Object putOne(@PathVariable("id") ID id, @RequestBody T entity);
    
    /**
     * : 提交一个资源的一部分，不处理null值
     * @author     : xxy
     * @param id
     * @param entity
     * @return
     * @throws
     */
    @PatchMapping("/{id}")
    Object patchOne(@PathVariable("id") ID id, @RequestBody T entity);
    
    /**
     * : 根据id删除一个资源
     * @author     : xxy
     * @param id
     * @return
     * @throws
     */
    @DeleteMapping("{id}")
    Object deleteOne(@PathVariable("id") ID id);
   /* 
    @RequestMapping(value="",method=RequestMethod.HEAD)
    Object head();
    
    @RequestMapping(value="",method=RequestMethod.OPTIONS)
    Object options();
    
    @RequestMapping(value="",method=RequestMethod.TRACE)
    Object TRACE();*/
    
}
