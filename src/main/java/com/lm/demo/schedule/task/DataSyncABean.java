package com.lm.demo.schedule.task;

import com.lm.demo.schedule.model.TaskModel;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Component("syncABean")
public class DataSyncABean implements IScheduleTaskDealSingle<TaskModel>{
	
	private static final Logger LOG = Logger.getLogger(DataSyncABean.class);

	@Override
	public Comparator<TaskModel> getComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**

	 * 根据条件，查询当前调度服务器可处理的任务

	 * @param taskParameter 任务的自定义参数

	 * @param ownSign 当前环境名称

	 * @param taskQueueNum 当前任务类型的任务队列数量

	 * @param taskItemList 当前调度服务器，分配到的可处理队列

	 * @param eachFetchDataNum 每次获取数据的数量

	 * @return

	 * @throws Exception

	 */
	@Override
	public List<TaskModel> selectTasks(String taskParameter, String ownSign, int taskQueueNum,
			List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
	    LOG.info("IScheduleTaskDealSingleTest配置的参数，taskParameter:"+taskParameter
			+",ownSign:"+ownSign
			+",taskQueueNum:"+taskQueueNum
			+",taskItemList:"+taskItemList
			+", eachFetchDataNum:"+eachFetchDataNum
	    	);  
	    List<TaskModel> modelList = new ArrayList<TaskModel>();
	    modelList.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "test1"));
	    modelList.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "test2"));
	    modelList.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "test3"));
	    modelList.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "test4"));

	    Thread.sleep(3000);
		return modelList;
	}

	@Override
	public boolean execute(TaskModel model, String ownSign) throws Exception {
		System.out.println(model.getJob()+" ************************ "+model.getName());
		return true;
	}

}
