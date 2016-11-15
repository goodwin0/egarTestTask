package com.egar.controller;

import com.egar.model.DAO.DataAccess;
import com.egar.model.entity.Order;
import webservice.TimeServer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller to main xhtml page.
 * Attribute "time" stores time received from webservice.
 * Attribute "tableElement" stores list of entities.
 * @see TableElement
 */
@ManagedBean(name = "show")
@ViewScoped
public class Show {

    private String time;

    private List<TableElement> tableElements;


    /**
     * Default constructor.
     * Makes connection to DB to get lists of entities.
     */
    public Show() {
        tableElements = new ArrayList<TableElement>();
        List<Order> orders = DataAccess.selectAllOrders();
        Order selectedOrder = null;
        for (int i = 0; i < orders.size(); i++) {
            selectedOrder = orders.get(i);
            tableElements.add(new TableElement(selectedOrder, DataAccess.selectArticlesForOrder(selectedOrder)));
        }
    }


    public List<TableElement> getTableElements() {
        return tableElements;
    }

    public void setTableElements(List<TableElement> tableElements) {
        this.tableElements = tableElements;
    }

    /**
     * Makes request to webservice to get time.
     * @throws MalformedURLException
     */
    public String getTime() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:9876/time?wsdl");
        QName qname = new QName("http://webservice/", "TimeServerImplService");
        Service service = Service.create(url, qname);
        TimeServer resultTime = service.getPort(TimeServer.class);
        return resultTime.getTimeAsString();
    }

    public void setTime(String time) {
        this.time = time;
    }

}
