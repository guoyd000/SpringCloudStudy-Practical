package com.huishu.oa.modular.quartz.service;


import com.baomidou.mybatisplus.service.IService;
import com.huishu.oa.modular.quartz.exception.TaskException;
import com.huishu.oa.modular.quartz.model.SysJob;
import org.apache.ibatis.annotations.Param;
import org.quartz.SchedulerException;

import java.util.List;
import java.util.Map;

/**
 * 定时任务调度信息信息 服务类
 * <p>
 * Created by zx
 * Date 2019/01/12 10:11
 * version:1.0
 */
public interface ISysJobService extends IService<SysJob> {

    /**
     * 获取quartz调度器的计划任务
     *
     * @return 调度任务集合
     */
    List<Map<String, Object>> selectJobList(@Param("jobName") String jobName, @Param("status") String status, @Param("methodName") String methodName);

    /**
     * 通过调度任务ID查询调度信息
     *
     * @param jobId 调度任务ID
     * @return 调度任务对象信息
     */
    public SysJob selectJobById(Integer jobId);

    /**
     * 暂停任务
     *
     * @param job 调度信息
     * @return 结果
     */
    public int pauseJob(SysJob job) throws SchedulerException;

    /**
     * 恢复任务
     *
     * @param job 调度信息
     * @return 结果
     */
    public int resumeJob(SysJob job) throws SchedulerException;

    /**
     * 删除任务后，所对应的trigger也将被删除
     *
     * @param job 调度信息
     * @return 结果
     */
    public int deleteJob(SysJob job) throws SchedulerException;

    /**
     * 批量删除调度信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public void deleteJobByIds(String ids) throws SchedulerException;

    /**
     * 任务调度状态修改
     *
     * @param job 调度信息
     * @return 结果
     */
    public int changeStatus(SysJob job) throws SchedulerException;

    /**
     * 立即运行任务
     *
     * @param job 调度信息
     * @return 结果
     */
    public int run(SysJob job) throws SchedulerException;

    /**
     * 新增任务表达式
     *
     * @param job 调度信息
     * @return 结果
     */
    public int insertJobCron(SysJob job) throws SchedulerException, TaskException;

    /**
     * 更新任务的时间表达式
     *
     * @param job 调度信息
     * @return 结果
     */
    public int updateJobCron(SysJob job) throws SchedulerException, TaskException;

    /**
     * 校验cron表达式是否有效
     *
     * @param cronExpression 表达式
     * @return 结果
     */
    public boolean checkCronExpressionIsValid(String cronExpression);
}
