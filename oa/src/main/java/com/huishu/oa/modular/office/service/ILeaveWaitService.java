package com.huishu.oa.modular.office.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huishu.oa.modular.office.model.Leave;


/**
 * <p>
 * 请假表 服务类
 * </p>
 *
 * @author tb
 * @since 2019-06-03
 */
public interface ILeaveWaitService extends IService<Leave> {

  
    /**
     * 分页查询
     * @param page
     * @return
     */
    List<Map<String, Object>>  leaveWaitList(Leave leave,Page<Leave> page);


    /**
     * 根据请假id查询请假
     * @param id
     * @return
     */
    Leave selectById(@Param("id") Integer id);

    /**
     * 条件查询 不分页
     * @param param
     * @return
     */
   // List<Leave> listAll(Map param);
    
    /**
     * 修改请假状态
     */
    int setStatus(Integer leaveId, int status);
    
    
    
    
    

}
