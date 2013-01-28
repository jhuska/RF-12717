package com.compsych.managedbean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.compsych.domain.DataRow;

@ManagedBean(name = "sampleBean")
@SessionScoped
public class SampleBean extends AbstractManagedBean {

    private static final long serialVersionUID = 1L;

    private List<DataRow> data;

    @Override
    public String getBaseResourcePath() {
        return "/";
    }

    @Override
    public String begin() {
        return makeResourcePath("index");
    }

    public String show() {
        /* Build data List */
        data = new ArrayList<DataRow>();
        DataRow row1 = new DataRow(1000L, "Green", new Date(), Arrays.asList("green", "grn"));
        DataRow row2 = new DataRow(1001L, "Blue", new Date(), Arrays.asList("blue", "b"));
        data.add(row1);
        data.add(row2);
        return makeResourcePath("index");
    }

    public String clear() {
        data = null;
        return makeResourcePath("index");
    }

    public String loadDataById(Long id) {
        createFacesMessage(null, null, "Clicked Data Row " + id, null);
        return makeResourcePath("index");
    }

    public List<DataRow> getData() {
        return data;
    }

    public void setData(List<DataRow> data) {
        this.data = data;
    }

}
