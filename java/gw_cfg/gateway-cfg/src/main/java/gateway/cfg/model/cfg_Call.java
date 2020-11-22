package gateway.cfg.model;

/**
 * 函数执行反馈
 * @author bean
 * 2020年11月9日
 */
public class cfg_Call {
	/**
	 * 管理id
	 */
	public int id;
	
	/**
	 * 设备id
	 */
	public String config;
	/**
	 * 设备函数的编码
	 */
	public String funcode;
	/**
	 * 监听数据值
	 */
	public String value;
	/**
	 * 数据地址
	 */
	public String DataAddr;
	/**
	 * 数据模型
	 */
	public String DataModel;
	/**
	 * 反馈消息
	 */
	public String massge;
	/**
	 * 描述
	 */
	public String remark;
	/**
	 * 状态
	 */
	public String state;
}
