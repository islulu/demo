package com.alu.scaffold.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=true)
@Table(name = "tb_one")
public class OneDO extends BaseDO {

	private static final long serialVersionUID = -9141592051306486747L;
	/** 名称 */
	private String name;
	/** 编码 */
	private String code;
	/** 创建时间 */
	private Date gmtCreate;
	/** 更新时间 */
	private Date gmtModify;
	/** 状态 */
	private Integer status;

}