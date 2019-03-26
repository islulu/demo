package com.alu.scaffold.dto;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 数据库模型对象的基类，所有数据库的DO对象必须继承这个类
 * jairy
 * @since $Revision:1.0.0, $Date: 2016年1月9日 上午11:21:43 $
 */
@Data
public abstract class BaseDO implements Serializable {

    private static final long serialVersionUID = -7649569150898094006L;
    @Id
    @GeneratedValue(generator = "JDBC")
    protected Long            id;
    protected Date            gmtCreate;
    protected Date            gmtModify;

    public <T> T copyPropertiesTo(T target, String... ignoreProperties) {
        BeanUtils.copyProperties(this, target, ignoreProperties);
        return target;
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
