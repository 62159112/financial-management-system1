package com.chongdong.financialmanagementsystem.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * 销售出账条目
 * @TableName tcd_sale
 */
@TableName(value ="tcd_sale")
@Data
public class Sale implements Serializable {
    public interface AddGroup{}
    public interface UpdateGroup{}
    /**
     * 销售出账条目编号
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    @NotNull(message = "条目id不能为空" , groups = {UpdateGroup.class})
    @Null(message = "条目id自动生成，不要求传递", groups = {AddGroup.class})
    private Integer id;

    /**
     * 销售出账条目名称
     */
    @ExcelProperty("条目名称")
    @ColumnWidth(35)
    @NotNull(message = "条目名称不能为空" , groups = {AddGroup.class})
    @Length(min = 2,max = 20, message = "条目名称要求在{min}-{max}之间" , groups = {AddGroup.class,UpdateGroup.class})
    private String name;

    /**
     * 销售出账条目类型
     */
    @ExcelProperty("条目类型")
    @ColumnWidth(25)
    @NotNull(message = "类型不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Length(min = 2,max = 20, message = "类型名称要求在{min}-{max}之间" , groups = {AddGroup.class,UpdateGroup.class})
    private String type;

    /**
     * 销售出账条目总金额
     */
    @ExcelProperty("收入总金额")
    @ColumnWidth(25)
    @NotNull(message = "金额不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Range(min = 0,max = 9999999,message = "金额要求在{min}-{max}之间" ,groups = {AddGroup.class,UpdateGroup.class})
    private BigDecimal amount;

    /**
     * 销售出账数量
     */
    @ExcelProperty("销售数量")
    @ColumnWidth(25)
    @NotNull(message = "数量不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Range(min = 0,max = 999,message = "数量要求在{min}-{max}之间" ,groups = {AddGroup.class,UpdateGroup.class})
    private Integer quantity;

    /**
     * 购买方
     */
    @ExcelProperty("购买方")
    @ColumnWidth(30)
    @NotNull(message = "购买方不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Length(min = 2,max = 20, message = "购买方名称要求在{min}-{max}之间", groups = {AddGroup.class,UpdateGroup.class} )
    private String purchaser;

    /**
     * 购买时间
     */
    @ExcelProperty("购买时间")
    @DateTimeFormat("yyyy-MM-dd")
    @ColumnWidth(30)
    @Null(message = "创建时间要求为空")
    private Date createTime;

    /**
     * 负责人
     */
    @ExcelProperty("负责人")
    @ColumnWidth(30)
    @NotNull(message = "负责人不能为空" , groups = {AddGroup.class,UpdateGroup.class})
    @Length(min = 2,max = 20, message = "负责人名称要求在{min}-{max}之间" , groups = {AddGroup.class,UpdateGroup.class})
    private String director;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}