package billiard.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import billiard.common.ResultMessage;
import billiard.entity.BilliardTable;
import billiard.service.TableService;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/table/")
public class TableController {
	@Autowired
	private TableService tableService;
	
	/**
	 * 获取所有台球桌信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("all")
	public ResultMessage getAll() {
		try {
			List<BilliardTable> dataList = tableService.getAll();
			if(dataList.isEmpty()) {
				return ResultMessage.error("未查到台球桌信息");
			}
			return ResultMessage.okHaveData(dataList);
		}catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.error("系统错误！");
		}
	}
	
	/**
	 * 开台球桌
	 * @param tableid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("start")
	public ResultMessage startPlay(String tableid) {
		try {
			int flag = tableService.isPlayingById(tableid); //判断台球桌是否在使用中
			if(flag != 0) {
				return ResultMessage.error("该桌正在使用中！");
			}
			Date currentTime =new Date();		//设置当前时间为开台时间
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		String startTime = sdf.format(currentTime);
    		BilliardTable table = new BilliardTable();
    		table.setTableId(tableid);
    		table.setTableFlag(1);
    		table.setTableStarttime(startTime);
    		flag = tableService.updateTime(table);
    		if(flag == 1) {
    			return ResultMessage.okNotData("开始计时！开始时间为"+startTime);
    		}
    		return ResultMessage.error("系统错误！");
		}catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.error("系统错误！");
		}
	}
	
	/**
	 * 下机
	 * @param tableid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("settle")
	public ResultMessage settlePlay(String tableid) {
		try {
			int flag = tableService.isPlayingById(tableid);	//判断台球桌是否在使用中
			if(flag == 0) {
				return ResultMessage.error("该桌未使用！");
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date currentTime =new Date();	//设置当前时间为结束时间
			String startTime = tableService.getStartTime(tableid); //从数据库读取开始时间
			Date fromTime = sdf.parse(startTime);  
		    long from = fromTime.getTime();  
		    long to = currentTime.getTime();  
		    int minutes = (int) ((to - from) / (1000 * 60));  //计算游戏时间
		    
		    flag = tableService.clearTime(tableid);
		    if(flag != 0) {
		    	return ResultMessage.okHaveData(minutes);
		    }
		    return ResultMessage.error("系统错误！");

		}catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.error("系统错误！");
		}
	}
}
