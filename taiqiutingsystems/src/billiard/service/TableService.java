package billiard.service;

import java.util.List;

import billiard.entity.BilliardTable;

public interface TableService {
	public List<BilliardTable> getAll() throws Exception;
	public int isPlayingById(String tableId) throws Exception;
	public int updateTime(BilliardTable data) throws Exception;
	public String getStartTime(String tableId) throws Exception;
	public int clearTime(String tableId) throws Exception;
}
