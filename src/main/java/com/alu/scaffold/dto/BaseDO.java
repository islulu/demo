package com.alu.scaffold.dto;

import org.springframework.beans.BeanUtils;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 数据库模型对象的基类，所有数据库的DO对象必须继承这个类
 * jairy
 * @since $Revision:1.0.0, $Date: 2016年1月9日 上午11:21:43 $
 */
public abstract class BaseDO implements Serializable {

    private static final long serialVersionUID = -7649569150898094006L;
    @Id
    @GeneratedValue(generator = "JDBC")
    protected Long            id;
    protected Date            gmtCreate;
    protected Date            gmtModify;
    @Transient
    private Long             projectId;

    public <T> T copyPropertiesTo(T target, String... ignoreProperties) {
        BeanUtils.copyProperties(this, target, ignoreProperties);
        return target;
    }
    
    public Long getProjectId() {
		return projectId;
	}
    
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}




	public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BaseDO other = (BaseDO) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

 

}
