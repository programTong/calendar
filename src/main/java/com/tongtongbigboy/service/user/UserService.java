package com.tongtongbigboy.service.user;


import com.alibaba.fastjson.JSONObject;
import com.tongtongbigboy.model.User;

import java.util.List;

/**
 * 示例Service定义
 * @author tongtongbigboy
 * @date 2021/05/29 19:31
 */
public interface UserService {

    /**
     * 创建
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    Integer create(User user);

    /**
     * 主键删除
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    void updateById(User user);

    /**
     * 批量主键更新
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    void updateByIdInBatch(List<User> users);

    /**
     * 主键查询
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    User findById(Integer id);

    /**
     * 条件查询单条记录
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    User findOne(User user);

    /**
     * 条件查询
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    List<User> findList(User user);


    /**
     * 条件统计
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    long count(User user);

    User findByUser(User user);

    JSONObject findByUserName(String username);
}
