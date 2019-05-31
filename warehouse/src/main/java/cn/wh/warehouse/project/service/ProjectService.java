package cn.wh.warehouse.project.service;
import java.util.Map;

import cn.wh.warehouse.common.web.PageObject;
import cn.wh.warehouse.project.entity.Project;


public interface ProjectService {
  Map<String, Object> findPageObjects(Project project,PageObject pageObject);
  void saveObject(Project project);
  Project FindById(Project project);
  void UpdateProject(Project project);
}





