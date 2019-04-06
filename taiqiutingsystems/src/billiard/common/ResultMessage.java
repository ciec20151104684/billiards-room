package billiard.common;

public class ResultMessage {
	private final static int NORMAL=1;          //此状态表示请求正常,且有数据
    private final static int EXCEPTION=0;       //此状态表示请求异常
    private final static int NULLRESULT=2;      //此状态表示请求正常但是无结果

    private Object object;        //请求到的结果
    private int status;           //请求状态
    private String message;       //请求状态描述

    //构造方法
    public ResultMessage(){}

    //请求异常时会使用到的构造方法
    public ResultMessage(String message){
        this.status=EXCEPTION;
        this.message=message;
        this.object=null;
    }

    //请求正常且有数据时会使用到的构造方法
    public ResultMessage(Object object){
        this.status=NORMAL;
        this.message="操作成功!";
        this.object=object;
    }

    //请求正常但无数据时会使用到的构造方法
    public ResultMessage(String message,Object object){
        this.status=NULLRESULT;
        this.message=message;
        this.object=object;
    }

    /* 请求异常 */
    public static ResultMessage error(String message){
        return new ResultMessage(message);
    }

    /* 请求正常有数据 */
    public static ResultMessage okHaveData(Object object){
        return new ResultMessage(object);
    }

    /* 请求正常无数据 */
    public static ResultMessage okNotData(String message){
        return new ResultMessage(message,null);
    }


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
