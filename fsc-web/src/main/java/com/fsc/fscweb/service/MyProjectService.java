package com.fsc.fscweb.service;

import com.fsc.fscweb.entity.MyProject;
import com.fsc.fscweb.entity.UserName;

import java.util.List;
import java.util.Map;

public interface MyProjectService {
    Boolean updateProject(MyProject myProject);
    Boolean addProject(MyProject myProject);
    MyProject getNewProject();
    Boolean mySubscription(UserName userName, MyProject myProject, Integer myNumber);
    List<Map<String,Object>> participate ();
}
