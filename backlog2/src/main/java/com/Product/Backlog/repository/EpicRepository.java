package com.Product.Backlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Product.Backlog.entity.Epic;

public interface EpicRepository extends CrudRepository<Epic, Integer>{
        //epic is entity and Integer data type of primary key of epic.
	 @Query("Select D from Epic D where D.projectCode=:projectCode")
	 public List<Epic> getProject(@Param("projectCode") int projectCOde);
	 
	 @Query("SELECT case when count(projoectCode)>0 then TRUE else FALSE end FROM Epic d where d.projectCode=:projectCode")
	 public Boolean findByProjectId(@Param("projectCode") int projectCode);

}
