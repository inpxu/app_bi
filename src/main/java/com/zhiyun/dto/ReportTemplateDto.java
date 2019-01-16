package com.zhiyun.dto;

import com.zhiyun.entity.ReportTemplate;

public class ReportTemplateDto extends ReportTemplate {

    private static final long serialVersionUID = 5479559995946520753L;

    // 是否可删除
    private boolean isDel;
    // 解压路径
    private String unzipPath;

    private String pic;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUnzipPath() {
        return unzipPath;
    }

    public void setUnzipPath(String unzipPath) {
        this.unzipPath = unzipPath;
    }

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }
}