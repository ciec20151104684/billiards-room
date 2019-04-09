package billiard.dao;

import java.util.List;

import billiard.entity.BilliardTable;

public interface BilliardTableDao {
    
    //获取所有台球桌信息
    List<BilliardTable> selectAll();
    
    //判断指定台球桌是否被使用
    int isPlaying(String tableId);
    
    //更新时间
    int updateTime(BilliardTable record);
    
    //获取开始时间
    String getStartTime(String tableId);
    
    //清空台球桌被占用状态
    int clearTime(String tableId);

}