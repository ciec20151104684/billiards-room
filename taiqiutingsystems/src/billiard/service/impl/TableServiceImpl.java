package billiard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import billiard.dao.BilliardTableDao;
import billiard.entity.BilliardTable;
import billiard.service.TableService;

@Service
public class TableServiceImpl implements TableService{
	@Resource
	private BilliardTableDao tableDao;
	
	//获取所有台球桌信息
	public List<BilliardTable> getAll() throws Exception{
		return tableDao.selectAll();
	}
	
	//判断指定台球桌是否被使用
	public int isPlayingById(String tableId) throws Exception{
		return tableDao.isPlaying(tableId);
	}
	
	//更新时间
	public int updateTime(BilliardTable data) throws Exception{
		return tableDao.updateTime(data);
	}
	
	//获取开始时间
	public String getStartTime(String tableId) throws Exception{
		return tableDao.getStartTime(tableId);
	}
	
	//清空台球桌被占用状态
	public int clearTime(String tableId) throws Exception{
		return tableDao.clearTime(tableId);
	}
}
