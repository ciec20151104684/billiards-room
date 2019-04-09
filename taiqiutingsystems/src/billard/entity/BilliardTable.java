package billiard.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BilliardTable {
    private String tableId;

    private Integer tableFlag;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")  
    private String tableStarttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")  
    private String tableEndtime;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId == null ? null : tableId.trim();
    }

    public Integer getTableFlag() {
        return tableFlag;
    }

    public void setTableFlag(Integer tableFlag) {
        this.tableFlag = tableFlag;
    }

    public String getTableStarttime() {
        return tableStarttime;
    }

    public void setTableStarttime(String tableStarttime) {
        this.tableStarttime = tableStarttime == null ? null : tableStarttime.trim();
    }

    public String getTableEndtime() {
        return tableEndtime;
    }

    public void setTableEndtime(String tableEndtime) {
        this.tableEndtime = tableEndtime == null ? null : tableEndtime.trim();
    }
}