package com.zhiyun.dto;

import com.zhiyun.entity.Layout;
import com.zhiyun.entity.LayoutFolder;

import java.util.List;

public class LayoutFolderDto extends LayoutFolder {

    private static final long serialVersionUID = 5479558995946520753L;

    private List<Layout> layouts;

    public List<Layout> getLayouts() {
        return layouts;
    }

    public void setLayouts(List<Layout> layouts) {
        this.layouts = layouts;
    }
}