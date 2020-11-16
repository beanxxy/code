package com.snimay.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.snimay.app.vo.Clazz;


/**   
 * 类的操作 
 * @title      : ClazzRepository.java
 * @package    : com.snimay.app.clazz.repository
 * @author     : xxy
 * @date       : 2018年5月7日 下午4:20:28
 * @version    : V1.0   
 */
@Repository
public interface ClazzRepository extends CrudRepository<Clazz,Long>{
	/**
	 * 根据名称查找
	 * @author     : xxy
	 * @param name
	 * @return
	 * @throws
	 */
	Clazz findByName(String name);
	/**
	 * 根据id进行查找
	 * @author     : xxy
	 * @param id
	 * @return
	 * @throws
	 */
	Clazz findById(Long id);
}
